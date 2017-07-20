package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.MotionProfile.RPAutonFowardMotionProfile;
import org.usfirst.frc27.MotionProfile.RPAutonSidewaysMotionProfile;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.commands.Combined.RunAugerAndElevateBalls;
import org.usfirst.frc27.robot.commands.DriveTrain.MotionProfileObjectCMD;
import org.usfirst.frc27.robot.commands.DriveTrain.Turn90InDirectionBasedOnAlliance;
import org.usfirst.frc27.robot.commands.Harvester.Harvest;
import org.usfirst.frc27.robot.commands.HarvesterArm.ExtendArm;
import org.usfirst.frc27.robot.commands.HarvesterArm.ToggleExtendArm;
import org.usfirst.frc27.robot.commands.Turret.ResetPositionToCenter;
import org.usfirst.frc27.robot.commands.Util.ResetGyro;
import org.usfirst.frc27.robot.commands.Vision.TrackObject;

import java.util.Objects;

public class RPAutoBlue extends CommandGroup {

	public RPAutoBlue(){
		addParallel(new ExtendArm());
		addParallel(new ResetGyro());
		addParallel(new ResetPositionToCenter(-100));
		addSequential(new MotionProfileObjectCMD(new RPAutonFowardMotionProfile()),2.25); // 117 inches
		addSequential(new Turn90InDirectionBasedOnAlliance(),.75);
		addParallel(new TrackObject(true));
		addSequential(new MotionProfileObjectCMD(new RPAutonSidewaysMotionProfile()), 2.5); // 63 inches
		addSequential(new RunAugerAndElevateBalls(),4);
		addParallel(new ToggleExtendArm());
		addParallel(new Harvest(), 3);
		addSequential(new RunAugerAndElevateBalls());
	}
}
