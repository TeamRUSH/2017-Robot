package org.usfirst.frc27.robot.commands.Vision;

import com.google.gson.Gson;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;
import org.usfirst.frc27.robot.commands.Turret.gson.Block;
import org.usfirst.frc27.robot.commands.Turret.gson.BlockArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by cyocom on 2/15/17.
 */
public class TrackObjectNoSpeed extends Command {

	private long storedLastUpdated = 0;
	private int loopsSinceUpdate = 0;
	private boolean sweeping = false;
	private double[] avgTargetY = new double[5];
	private double lastTargetX = 0;
	private int outOfAverageCount = 0;
	private boolean isAuto = false;
	private boolean offLimit = true;

	public TrackObjectNoSpeed(){
	}

	public TrackObjectNoSpeed(boolean isAuto){
		this.isAuto = isAuto;
	}



	@Override
	protected void initialize() {
		if (!Robot.state.isManualOverride()) {
			Robot.turret.enablePIDMode();
		}

		Robot.state.resetRPMOffset();
	}

	@Override
	protected void execute() {
		String jsonString = SmartDashboard.getString("blockArray", "{blockCount: 1, lastUpdated: 0, blocks: [{targetX: 2 ,targetY: 3,targetHeight: 4,targetWidth: 5}]}");
		
		if(!RobotMap.leftTurretHallSensor.get() && offLimit){
			DriverStation.reportWarning("LEFT HALL SENSOR TRIGGERED", false);
			Robot.turret.resetPosLeft();
			offLimit = false;
		}  
		if(!RobotMap.rightTurretHallSensor.get() && offLimit){
			DriverStation.reportWarning("RIGHT HALL SENSOR TRIGGERED", false);
			Robot.turret.resetPosRight();
			offLimit = false;
		}

		if(RobotMap.rightTurretHallSensor.get() && RobotMap.rightTurretHallSensor.get()){
			offLimit = true;
		}
		
		Gson gson = new Gson();
		BlockArray blockArray = gson.fromJson(jsonString, BlockArray.class);
		
		long totalTargetX = 0;
		long totalTargetY = 0;
		int objectIndex = 0;

		List<Block> eligbleBlocks = new ArrayList<Block>();

		if(blockArray.getBlocks().size() >= 2){
			for(int i = 0; i < blockArray.getBlocks().size(); i++){
				Block baseBlock = blockArray.getBlocks().get(i);
//				DriverStation.reportWarning(String.format("Base: %s", baseBlock), false);

				if(!largeEnough(baseBlock)){
					continue;
				}

				for(int j = i + 1; j < blockArray.getBlocks().size(); j++ ){
					Block compareBlock = blockArray.getBlocks().get(j);
//					DriverStation.reportWarning(String.format("Compare: %s", compareBlock), false);
					if(inRange(baseBlock, compareBlock) && largeEnough(compareBlock)){
						eligbleBlocks.add(compareBlock);
						eligbleBlocks.add(baseBlock);
					}
				}
			}

			for(Block eligbleBlock : eligbleBlocks){
//				DriverStation.reportWarning(String.format("Eligible: %s", eligbleBlock), false);
				totalTargetX += eligbleBlock.getTargetX();
				totalTargetY += eligbleBlock.getTargetY();
				objectIndex += 1;
			}
		}

		double averageTargetX = 0;
		double trueAverageY = computeAverageY();
		if(objectIndex != 0){
			double averageTargetY = totalTargetY / objectIndex;
			averageTargetX = totalTargetX / objectIndex;
			trueAverageY = computeNewAverageY(averageTargetY);
			lastTargetX = averageTargetX;
		} else {
			averageTargetX = lastTargetX;
		}
		

		if (Robot.state.isManualOverride()) {
			Robot.shooter.spinShooter();
		} else {
			if (blockArray.getLastUpdated() == storedLastUpdated || objectIndex == 0) {
				loopsSinceUpdate++;
			} else if (blockArray.getLastUpdated() > storedLastUpdated) {
				loopsSinceUpdate = 0;
			}

			if (blockArray.getLastUpdated() == 0 || loopsSinceUpdate > 100) {
				sweep();
				Robot.shooter.disable();
				DriverStation.reportWarning("sweeping!", false);
			} else {
				Robot.turret.setTurretSetpointFromPixels(averageTargetX);

				if(objectIndex != 0){
					DriverStation.reportWarning(String.format("trueAverageY: %s", trueAverageY), false);
				}
				sweeping = false;
			}
			storedLastUpdated = blockArray.getLastUpdated();
		}
		
        SmartDashboard.putNumber("shooter_left_actualRPM", RobotMap.shooterMotor1.getSpeed());
        SmartDashboard.putNumber("motor output value 1",RobotMap.shooterMotor1.pidGet());

        SmartDashboard.putNumber("shooter_right_actualRPM", RobotMap.shooterMotor2.getSpeed());
        SmartDashboard.putNumber("motor output value 2",RobotMap.shooterMotor2.pidGet());
	}

	private boolean largeEnough(Block compareBlock) {
		return compareBlock.getTargetHeight() > 1;
	}

	private boolean inRange(Block baseBlock, Block compareBlock) {

		double bottomRange = compareBlock.getTargetX() - 5;
		double topRange = compareBlock.getTargetX() + 5;

		return (baseBlock.getTargetX() >= bottomRange) && (baseBlock.getTargetX() <= topRange);
	}

	private boolean isLikeTopBlock(Block block) {
		double aspectRatio = block.getTargetWidth() / block.getTargetHeight();

		double targetAspectRatio = 4 / 15;

		double lowerAspectRatio = targetAspectRatio * .7;
		double upperAspectRatio = targetAspectRatio * 1.3;

		if(aspectRatio > lowerAspectRatio && aspectRatio < upperAspectRatio){
			return true;
		}
		return false;
	}

	private boolean isLikeBottomBlock(Block block) {
		double aspectRatio = block.getTargetWidth() / block.getTargetHeight();

		double targetAspectRatio = 2 / 15;

		double lowerAspectRatio = targetAspectRatio * .7;
		double upperAspectRatio = targetAspectRatio * 1.3;

		if(aspectRatio > lowerAspectRatio && aspectRatio < upperAspectRatio){
			return true;
		}
		return false;
	}

	private double computeNewAverageY(double newAverageTargetY) {

		if(Math.abs(computeAverageY() - newAverageTargetY) > 25){
			if(outOfAverageCount >= 5){
				outOfAverageCount = 0;
				avgTargetY[0] = 0;
				avgTargetY[1] = 0;
				avgTargetY[2] = 0;
				avgTargetY[3] = 0;
				avgTargetY[4] = 0;
			} else {
				outOfAverageCount++;
				return computeAverageY();
			}
		}

		avgTargetY[4] = avgTargetY[3];
		avgTargetY[3] = avgTargetY[2];
		avgTargetY[2] = avgTargetY[1];
		avgTargetY[1] = avgTargetY[0];
		avgTargetY[0] = newAverageTargetY;

		int populatedAverage = 0;
		double totalAverage = 0;
		for(double average : avgTargetY){
			if(average > 0){
				populatedAverage++;
				totalAverage += average;
			}
		}
		double trueAverage = totalAverage / populatedAverage;

		return trueAverage;
	}

	private double computeAverageY() {
		int populatedAverage = 0;
		double totalAverage = 0;
		for(double average : avgTargetY){
			if(average > 0){
				populatedAverage++;
				totalAverage += average;
			}
		}
		double trueAverage = totalAverage / populatedAverage;

		return trueAverage;
	}

	private void sweep(){
		double angle = Robot.turret.getAngle();
		if(angle > 80){
			Robot.turret.setTurretSetpointFromDegree(-90d);
			sweeping = true;
		} else if (angle < -80) {
			Robot.turret.setTurretSetpointFromDegree(90d);
			sweeping = true;
		} else if(!sweeping){
			if(Objects.equals(Robot.ds.getAlliance(), DriverStation.Alliance.Blue)){
				Robot.turret.setTurretSetpointFromDegree(isAuto ? 90d : -90d);
			} else {
				Robot.turret.setTurretSetpointFromDegree(isAuto ? -90d : 90d);
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.turret.enableOperatorMode();
		Robot.shooter.disable();
	}

	@Override
	protected void interrupted() {
		end();
	}


}
