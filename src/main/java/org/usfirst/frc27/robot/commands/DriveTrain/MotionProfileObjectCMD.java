package org.usfirst.frc27.robot.commands.DriveTrain;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc27.MotionProfile.DriveTrainMotionProfiler;
import org.usfirst.frc27.MotionProfile.FalconPathPlanner;
import org.usfirst.frc27.MotionProfile.LeftMotionProfile;
import org.usfirst.frc27.MotionProfile.MotionProfile;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

import java.util.List;
import java.util.Objects;

public class MotionProfileObjectCMD extends Command {

	public static DriveTrainMotionProfiler driveTrainMotionProfiler = new DriveTrainMotionProfiler();
	private final MotionProfile motionProfile;
	private boolean isFinished = false;

	public MotionProfileObjectCMD(MotionProfile motionProfile){
		requires(Robot.driveTrain);
		this.motionProfile = motionProfile;

	}

	protected void initialize() {
		Robot.driveTrain.enableClosedLoopControl();
		driveTrainMotionProfiler.setPaths(motionProfile.getPoints(), motionProfile.getPoints());

		List<CANTalon.SetValueMotionProfile> setValues = driveTrainMotionProfiler.getSetValues();
		int leftSetpoint = setValues.get(0).value;
		int rightSetpoint = setValues.get(1).value;
		Robot.driveTrain.setMPValue(leftSetpoint, rightSetpoint);
		driveTrainMotionProfiler.control();
		driveTrainMotionProfiler.start();
		isFinished = false;
	}


	protected void execute() {		
		SmartDashboard.putString("mo pro", "Mo pro mode!");
		List<CANTalon.SetValueMotionProfile> setValues = driveTrainMotionProfiler.getSetValues();
		int leftSetpoint = setValues.get(0).value;
		int rightSetpoint = setValues.get(1).value;
		Robot.driveTrain.setMPValue(leftSetpoint, rightSetpoint);
		driveTrainMotionProfiler.control();
	}


	protected boolean isFinished() {
		return isFinished;
	}


	protected void end() {
		Robot.driveTrain.enableOperatorControl();
		Robot.driveTrain.stop();
		/* clear our buffer and put everything into a known state */
		driveTrainMotionProfiler.reset();
	}


	protected void interrupted() {
		end();
	}

}
