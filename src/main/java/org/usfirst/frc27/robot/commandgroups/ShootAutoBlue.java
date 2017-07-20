package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc27.MotionProfile.ForwardShootMotionProfile;
import org.usfirst.frc27.MotionProfile.RPAutonFowardMotionProfile;
import org.usfirst.frc27.MotionProfile.RPAutonFowardMotionProfileRed;
import org.usfirst.frc27.MotionProfile.RPAutonSidewaysMotionProfile;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.commands.Combined.RunAugerAndElevateBalls;
import org.usfirst.frc27.robot.commands.DriveTrain.MotionProfileObjectCMD;
import org.usfirst.frc27.robot.commands.DriveTrain.Turn90InDirectionBasedOnAlliance;
import org.usfirst.frc27.robot.commands.DriveTrain.TurnAmountBasedOnAlliance;
import org.usfirst.frc27.robot.commands.Harvester.Harvest;
import org.usfirst.frc27.robot.commands.HarvesterArm.ExtendArm;
import org.usfirst.frc27.robot.commands.HarvesterArm.ToggleExtendArm;
import org.usfirst.frc27.robot.commands.Turret.GoToRedAngleAndSpinShooter;
import org.usfirst.frc27.robot.commands.Turret.ResetPositionToCenter;
import org.usfirst.frc27.robot.commands.Util.ResetGyro;
import org.usfirst.frc27.robot.commands.Vision.TrackObject;

import java.util.Objects;

public class ShootAutoBlue extends CommandGroup {

	public ShootAutoBlue(){
		addParallel(new ResetGyro());
		addParallel(new ResetPositionToCenter(-90));
		addSequential(new MotionProfileObjectCMD(new ForwardShootMotionProfile()),2.75); // 117 inches
		addSequential(new TurnAmountBasedOnAlliance(45d),.75);
		addParallel(new TrackObject(true));
		addSequential(new RunAugerAndElevateBalls());
	}
}