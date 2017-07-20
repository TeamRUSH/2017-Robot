package org.usfirst.frc27.robot.commands.DriveTrain;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

/**
 * Created by cyocom on 3/1/17.
 */
public class DriveForwardBasedOnBannerSensors extends Command {

	private final int targetDistance;
	private boolean preFinish = false;
	private boolean finished = false;

	public DriveForwardBasedOnBannerSensors(int targetDistance) {
		this.targetDistance = targetDistance;
	}

	protected void initialize() {
		Robot.driveTrain.setControlMode(CANTalon.TalonControlMode.PercentVbus);
		Robot.navx.zeroYaw();
		Robot.driveTrain.zeroPosition();
		finished = false;
		preFinish = false;
		Robot.driveTrain.enableBrakeMode();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		final double rotationSpeed = .3;

		double rotation = 0;
		double speed = .6;

		if(RobotMap.leftPegSensor.get() && RobotMap.rightPegSensor.get()){
		} else if (RobotMap.leftPegSensor.get()){
			rotation = -rotationSpeed;
		} else if(RobotMap.rightPegSensor.get()){
			rotation = rotationSpeed;
		}

		if(!preFinish){
			// arcade expects left and backwards to be 1 for legacy reasons.
			Robot.driveTrain.takeArcadeInputs(-speed, rotation);
		} else {
			Robot.driveTrain.takeArcadeInputs(0, 0);
		}
		
		double[] leftData = Robot.driveTrain.getLeftRotations();
		double[] rightData = Robot.driveTrain.getRightRotations();
		
		DriverStation.reportWarning(String.format("Left- Distance: %s Velocity: %s Right- Distance: %s Velocity: %s", leftData[0], leftData[1], rightData[0], rightData[1]), false);
		
		if(leftData[0] > targetDistance || rightData[0] > targetDistance){
			DriverStation.reportWarning(String.format("Finished @ Left %s Right %s", leftData[0], rightData[0]), false);
			preFinish = true;
		}
		
		if(leftData[1] + rightData[1] < .2 && preFinish){
			finished = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
		Robot.driveTrain.enableOperatorControl();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
