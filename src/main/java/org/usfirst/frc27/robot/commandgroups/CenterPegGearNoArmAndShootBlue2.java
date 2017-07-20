package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.robot.commands.Combined.RunAugerAndElevateBalls;
import org.usfirst.frc27.robot.commands.DriveTrain.DriveStraightForwardDistanceClosedLoop;
import org.usfirst.frc27.robot.commands.DriveTrain.FindTapeAndCenter;
import org.usfirst.frc27.robot.commands.Turret.ResetPositionToCenter;
import org.usfirst.frc27.robot.commands.Util.ResetGyro;
import org.usfirst.frc27.robot.commands.Vision.TrackObject;

/**
 * Created by cyocom on 2/26/17.
 */
public class CenterPegGearNoArmAndShootBlue2 extends CommandGroup {

	public CenterPegGearNoArmAndShootBlue2(){
		addParallel(new ResetPositionToCenter(-75));
		addSequential(new ResetGyro());
		addSequential(new DriveStraightForwardDistanceClosedLoop(60, 4, .05));
		addSequential(new FindTapeAndCenter());
		addParallel(new TrackObject(true));
		addParallel(new RunAugerAndElevateBalls());
	}
}
