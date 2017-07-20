package org.usfirst.frc27.robot.commands.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

/**
 * Created by cyocom on 1/14/17.
 */
public class SpinShooter extends Command{


    protected void initialize() {
    	// shooter is a PIDSubsystem, so calling enable method will
    	// turn the PID Controller on.
        Robot.shooter.enable();
    }

    protected void execute() {
        SmartDashboard.putNumber("shooter_left_actualRPM", RobotMap.shooterMotor1.getSpeed());
        SmartDashboard.putNumber("motor output value 1",RobotMap.shooterMotor1.pidGet());

        SmartDashboard.putNumber("shooter_right_actualRPM", RobotMap.shooterMotor2.getSpeed());
        SmartDashboard.putNumber("motor output value 2",RobotMap.shooterMotor2.pidGet());
    	Robot.shooter.spinShooter();
//        Robot.shooter.spinAtConstantPower();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.shooter.disable();
    }

    protected void interrupted() {
        end();
    }

}
