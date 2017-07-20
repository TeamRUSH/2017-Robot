package org.usfirst.frc27.robot.commands.DriveTrain;

import java.util.List;

import org.usfirst.frc27.MotionProfile.DriveTrainMotionProfiler;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc27.MotionProfile.FalconPathPlanner;

public class MotionMagic extends Command {
	
	public MotionMagic()
    {
		requires(Robot.driveTrain);
    }
    
//    public static DriveTrainMotionProfiler driveTrainMotionProfiler = new DriveTrainMotionProfiler();

    double desiredRotations;
    double distancePerRotation;
    double wheelDiameter;
    double travelDistance;
    double ticksPerRotation;
    
	protected void initialize() {
		Robot.driveTrain.setControlMode(TalonControlMode.MotionMagic);
	
		ticksPerRotation = 4096; // This is ticks/rev per mag encoder revolution
		travelDistance = 3; //Give in feet
		wheelDiameter = 4; //Give in inches
		distancePerRotation = Math.PI * wheelDiameter / 12; // In feet
		desiredRotations = travelDistance/distancePerRotation;
	}

	
	protected void execute() {
		Robot.driveTrain.setMagicMotionPosition(6, 6);		
	}

	
	protected boolean isFinished() {
	    return false;
	}

	
	protected void end() {
		Robot.driveTrain.setControlMode(TalonControlMode.PercentVbus);
		Robot.driveTrain.stop();
		/* clear our buffer and put everything into a known state */
		//driveTrainMotionProfiler.reset();
	}

	
	protected void interrupted() {
	    end();
	}
    
}
