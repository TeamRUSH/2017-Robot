package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.robot.commands.Combined.RunAugerAndElevateBalls;
import org.usfirst.frc27.robot.commands.DriveTrain.DriveStraightForwardDistanceClosedLoop;
import org.usfirst.frc27.robot.commands.DriveTrain.FindTapeAndCenter;
import org.usfirst.frc27.robot.commands.DriveTrain.TurnAmount;
import org.usfirst.frc27.robot.commands.Turret.ResetPositionToCenter;
import org.usfirst.frc27.robot.commands.Util.ResetGyro;
import org.usfirst.frc27.robot.commands.Vision.TrackObject;

/**
 * Created by cyocom on 2/26/17.
 */
public class RightPegGearNoArmBlue extends CommandGroup {

	public RightPegGearNoArmBlue(){
		addParallel(new ResetPositionToCenter(-2));
		addSequential(new ResetGyro());
		addSequential(new DriveStraightForwardDistanceClosedLoop(105, 8, .015));
		addSequential(new TurnAmount(-60),1);
		addSequential(new FindTapeAndCenter());
	}
}
