package org.usfirst.frc27.robot.commands.DriveTrain;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;

/**
 * Created by cyocom on 3/1/17.
 */
public class DriveStraightForwardDistanceClosedLoop extends Command {

	private final double targetDistance;
	private final double targetFeetPerSecond;
	private final double errorMultipler;
	private final double rotationMultiplier;
	private boolean preFinish = false;
	private boolean finished = false;
	private boolean started = false;
	private double[] startDistance = new double[2];



	public DriveStraightForwardDistanceClosedLoop(double targetDistance, double targetFeetPerSecond, double errorMultiplier) {
		this.targetDistance = targetDistance;
		this.targetFeetPerSecond = targetFeetPerSecond;
		this.errorMultipler = errorMultiplier;
		rotationMultiplier = .2;
	}

	public DriveStraightForwardDistanceClosedLoop(double targetDistance, double targetFeetPerSecond, double errorMultiplier, double rotationMultiplier) {
		this.targetDistance = targetDistance;
		this.targetFeetPerSecond = targetFeetPerSecond;
		this.errorMultipler = errorMultiplier;
		this.rotationMultiplier = rotationMultiplier;
	}

	protected void initialize() {
		Robot.driveTrain.enableSecondaryClosedLoopMode();
		double[] leftData = Robot.driveTrain.getLeftRotations();
		double[] rightData = Robot.driveTrain.getRightRotations();

		startDistance[0] = leftData[0];
		startDistance[1] = rightData[0];

		finished = false;
		preFinish = false;
		started = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		double angle = Robot.navx.getAngle();

		double[] leftData = Robot.driveTrain.getLeftRotations();
		double[] rightData = Robot.driveTrain.getRightRotations();

		double leftError = targetDistance - (leftData[0] - startDistance[0]);
		double rightError = targetDistance - (rightData[0] - startDistance[1]);

		double avgError = (leftError + rightError) / 2d;
		double multiplier = avgError * errorMultipler;

		multiplier = Math.max(multiplier, 0);
		multiplier = Math.min(multiplier, 1);

		double rotation = angle * rotationMultiplier;
		if(!preFinish){
			Robot.driveTrain.setSpeedSetpointWithOffset(getRPMForFeetPerSecond(targetFeetPerSecond) * -multiplier, rotation);
		} else {
			Robot.driveTrain.setSpeedSetpoint(0, 0);
		}
		

		DriverStation.reportWarning(String.format("Angle: %s Left- Distance: %s Velocity: %s Right- Distance: %s Velocity: %s", angle, leftData[0] - startDistance[0], leftData[1], rightData[0] - startDistance[1], rightData[1]), false);
		
		if((leftData[0] - startDistance[0] > targetDistance || rightData[0] - startDistance[1] > targetDistance) && started){
			DriverStation.reportWarning(String.format("Finished @ Left %s Right %s", leftData[0] - startDistance[0], rightData[0] - startDistance[1]), false);
			preFinish = true;
		}

		if(leftData[1] + rightData[1] > targetFeetPerSecond / 2){
			System.out.println("quitter");
			started = true;
		}
		
		if(leftData[1] + rightData[1] < .2 && started ){
			finished = true;
		}
	}

	private double getRPMForFeetPerSecond(double feetPerSecond){
		double circumference = 4d * Math.PI;
		double feetPerMinute = feetPerSecond * 60d;
		double inchesPerMinute = feetPerMinute * 12d;

		return inchesPerMinute / circumference;
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
