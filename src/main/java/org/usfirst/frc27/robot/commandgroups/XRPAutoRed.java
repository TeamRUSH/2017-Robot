package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.robot.commands.Combined.RunAugerAndElevateBalls;
import org.usfirst.frc27.robot.commands.DriveTrain.DriveStraightForwardDistanceClosedLoop;
import org.usfirst.frc27.robot.commands.DriveTrain.DriveStraightForwardDistanceClosedLoopFinishEarly;
import org.usfirst.frc27.robot.commands.DriveTrain.TurnAmount;
import org.usfirst.frc27.robot.commands.DriveTrain.TurnAmountBasedOnAlliance;
import org.usfirst.frc27.robot.commands.Harvester.Harvest;
import org.usfirst.frc27.robot.commands.HarvesterArm.ExtendArm;
import org.usfirst.frc27.robot.commands.Turret.ResetPositionToCenter;
import org.usfirst.frc27.robot.commands.Util.PrintTime;
import org.usfirst.frc27.robot.commands.Util.ResetGyro;
import org.usfirst.frc27.robot.commands.Vision.TrackObject;

public class XRPAutoRed extends CommandGroup {

	public XRPAutoRed(){
		addParallel(new PrintTime());
		addParallel(new ExtendArm());
		addParallel(new ResetGyro());
		addParallel(new ResetPositionToCenter(110));
		addSequential(new DriveStraightForwardDistanceClosedLoopFinishEarly(70, 8, .015)); // 117 inches
		addParallel(new ResetGyro());
		addSequential(new TurnAmount(50),1);
		addParallel(new ResetGyro());
		addParallel(new Harvest());
		addSequential(new DriveStraightForwardDistanceClosedLoopFinishEarly(41, 8, .075)); // 117 inches
		addParallel(new ResetGyro());
		addSequential(new TurnAmount(50),1);
		addParallel(new TrackObject(true));
		addSequential(new ResetGyro());
		addSequential(new DriveStraightForwardDistanceClosedLoopFinishEarly(26, 8, .075)); // 63 inches
		addParallel(new PrintTime());
		addSequential(new RunAugerAndElevateBalls(),3.5);
		addParallel(new ToggleExtendArmAndRunHarvester());
		addSequential(new RunAugerAndElevateBalls());
	}
}

