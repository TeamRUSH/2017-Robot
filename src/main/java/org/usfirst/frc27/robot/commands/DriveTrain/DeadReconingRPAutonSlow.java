package org.usfirst.frc27.robot.commands.DriveTrain;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc27.robot.Robot;

/**
 * Created by cyocom on 3/1/17.
 */
public class DeadReconingRPAutonSlow extends Command {

	private final int targetDistance;

	public DeadReconingRPAutonSlow(int targetDistance) {
		this.targetDistance = targetDistance;
	}

	protected void initialize() {
		Robot.driveTrain.setControlMode(CANTalon.TalonControlMode.PercentVbus);
		Robot.driveTrain.enableGearMode();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.takeRawValue(-.5, -.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.enableOperatorControl();
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
