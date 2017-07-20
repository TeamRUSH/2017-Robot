package org.usfirst.frc27.robot.commands.DriveTrain;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc27.robot.Robot;

import java.util.Objects;

/**
 * Created by cyocom on 3/1/17.
 */
public class Turn90InDirectionBasedOnAlliance extends Command {

	private double targetAngle = 0;
	private boolean isFinished = false;
	private int count = 0;
	private long time = 0;

	protected void initialize() {
		targetAngle = Objects.equals(Robot.ds.getAlliance(), DriverStation.Alliance.Blue) ? -90 : 90;
		Robot.driveTrain.enableTurnMode();
		Robot.driveTrain.turnToHeading(targetAngle);
		isFinished = false;
		count = 0;
		time = System.currentTimeMillis();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		DriverStation.reportWarning(String.format("navxAngle: %s targetAngle: %s",Robot.navx.getAngle(), targetAngle), false);
		
		if (count >= 5){
			Robot.driveTrain.enableOperatorControl();
			isFinished = true;
		}

		if(Robot.driveTrain.getPIDController().onTarget()){
			count++;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		DriverStation.reportWarning(String.format("Time Elapsed: %s",System.currentTimeMillis() - time), false);
		return isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
