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
public class RPAngleAndSpinShooter extends Command {

	@Override
	protected void initialize() {
		Robot.turret.enablePIDMode();
		Robot.state.resetRPMOffset();
	}

	@Override
	protected void execute() {

		double angle = -107d;
		angle = Objects.equals(Robot.ds.getAlliance(), DriverStation.Alliance.Blue) ? angle : -1 * angle;
		Robot.turret.setTurretSetpointFromDegree(angle);
		Robot.shooter.spinShooterAtSpeedWithAngle(3600, angle);

		SmartDashboard.putNumber("shooter_left_actualRPM", RobotMap.shooterMotor1.getSpeed());
        SmartDashboard.putNumber("motor output value 1",RobotMap.shooterMotor1.pidGet());

        SmartDashboard.putNumber("shooter_right_actualRPM", RobotMap.shooterMotor2.getSpeed());
        SmartDashboard.putNumber("motor output value 2",RobotMap.shooterMotor2.pidGet());
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
