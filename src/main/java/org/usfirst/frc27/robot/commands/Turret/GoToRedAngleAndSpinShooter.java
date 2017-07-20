package org.usfirst.frc27.robot.commands.Turret;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

import java.sql.Driver;
import java.util.Objects;

/**
 * Created by cyocom on 2/15/17.
 */
public class GoToRedAngleAndSpinShooter extends Command {

	@Override
	protected void initialize() {
		if (!Robot.state.isManualOverride()) {
			Robot.turret.enablePIDMode();
		}

		Robot.state.resetRPMOffset();
	}

	@Override
	protected void execute() {

			double angle = 110d;
			Robot.turret.setTurretSetpointFromDegree(angle);
			Robot.shooter.spinShooterAtSpeedWithAngle(3300, angle);
		}

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
