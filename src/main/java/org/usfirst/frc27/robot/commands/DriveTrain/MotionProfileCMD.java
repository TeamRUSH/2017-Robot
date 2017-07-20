package org.usfirst.frc27.robot.commands.DriveTrain;

import java.util.List;
import java.util.Objects;

import org.usfirst.frc27.MotionProfile.*;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MotionProfileCMD extends Command {

	public static final String INTERNAL_WAYPOINTS = "Internal Waypoints";
	public static final String OBJECTS = "Object";
	public static final String OBJECTS_2 = "Object_2";

	private String pointSource;

	public static DriveTrainMotionProfiler driveTrainMotionProfiler = new DriveTrainMotionProfiler();

	public MotionProfileCMD(String pSource) {
		requires(Robot.driveTrain);
		pointSource = pSource;
	}

	protected void initialize() {
		Robot.driveTrain.enableClosedLoopControl();

		if (Objects.equals(pointSource, INTERNAL_WAYPOINTS)) {

			//Waypoints are real-world coordinates.  Currently, units are in feet.
			double[][] waypoints = new double[][]{
					{0, 0},
					{0, 2},
					{2, 2},
					{2, 4}
			};

			double totalTime = 5; //seconds
			double timeStep = 0.01; //period of control loop on Rio, seconds
			double robotTrackWidth = 2.583; //distance between left and right wheels, feet

			final FalconPathPlanner path = new FalconPathPlanner(waypoints);
			// Use the waypoints to calculate the set of points that will be fed to 
			// the Talon.
			path.calculate(totalTime, timeStep, robotTrackWidth);

			// Feed the points into the MotionProfilers.  We are loading the "Top Buffer",
			// which is the buffer in the RoboRio.  The MotionProfilers will transfer points as 
			// needed from the top buffer to the "Bottom Buffer", which is inside the Talons.
			driveTrainMotionProfiler.setPaths(path.talonLeftVelocity, path.talonRightVelocity);
		}

		if (Objects.equals(pointSource, OBJECTS)) {
			driveTrainMotionProfiler.setPaths(GearMotionProfile.Points, GearMotionProfile.Points);
		}


		List<CANTalon.SetValueMotionProfile> setValues = driveTrainMotionProfiler.getSetValues();
		int leftSetpoint = setValues.get(0).value;
		int rightSetpoint = setValues.get(1).value;
		Robot.driveTrain.setMPValue(leftSetpoint, rightSetpoint);
		driveTrainMotionProfiler.control();

		driveTrainMotionProfiler.start();
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
		return false;
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
