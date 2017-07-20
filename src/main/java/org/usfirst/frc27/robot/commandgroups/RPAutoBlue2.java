package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.MotionProfile.RPAutonFowardMotionProfile;
import org.usfirst.frc27.MotionProfile.RPAutonSidewaysMotionProfile;
import org.usfirst.frc27.robot.commands.Combined.RunAugerAndElevateBalls;
import org.usfirst.frc27.robot.commands.DriveTrain.*;
import org.usfirst.frc27.robot.commands.Harvester.Harvest;
import org.usfirst.frc27.robot.commands.HarvesterArm.ExtendArm;
import org.usfirst.frc27.robot.commands.HarvesterArm.ToggleExtendArm;
import org.usfirst.frc27.robot.commands.Turret.ResetPositionToCenter;
import org.usfirst.frc27.robot.commands.Util.PrintTime;
import org.usfirst.frc27.robot.commands.Util.ResetGyro;
import org.usfirst.frc27.robot.commands.Vision.TrackObject;

public class RPAutoBlue2 extends CommandGroup {

	public RPAutoBlue2(){
		addParallel(new PrintTime());
		addParallel(new ExtendArm());
		addParallel(new ResetPositionToCenter(-100));
		addSequential(new ResetGyro());
		addSequential(new DriveStraightForwardDistanceClosedLoopFinishEarly(91, 12, .009, .15)); // 117 inches
		addSequential(new TurnAmountBasedOnAlliance(86d),.75);
		addParallel(new TrackObject(true));
		addSequential(new ResetGyro());
		addParallel(new Harvest());
		addSequential(new DriveStraightForwardDistanceClosedLoopFinishEarly(22, 6, .02)); // 63 inches
		addParallel(new PrintTime());
		addParallel(new DeadReconingRPAutonSlow(0));
		addSequential(new RunAugerAndElevateBalls(),4);
		addParallel(new ToggleExtendArmAndRunHarvester());
		addSequential(new RunAugerAndElevateBalls());
	}
}
