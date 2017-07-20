package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.robot.commands.Combined.RunAugerAndElevateBalls;
import org.usfirst.frc27.robot.commands.DriveTrain.MotionProfileCMD;
import org.usfirst.frc27.robot.commands.Harvester.Harvest;
import org.usfirst.frc27.robot.commands.HarvesterArm.ToggleExtendArm;
import org.usfirst.frc27.robot.commands.Turret.ResetPositionToCenter;
import org.usfirst.frc27.robot.commands.Vision.TrackObject;

/**
 * Created by cyocom on 2/26/17.
 */
public class CenterPegGearAndShootRed extends CommandGroup {

	public CenterPegGearAndShootRed(){
		addParallel(new ToggleExtendArm());
		addParallel(new ResetPositionToCenter(55));
		addSequential(new MotionProfileCMD(MotionProfileCMD.OBJECTS),8);
		addParallel(new RunAugerAndElevateBalls());
		addSequential(new TrackObject(true),4);
		addParallel(new ToggleExtendArm());
		addParallel(new Harvest(), 3);
		addParallel(new TrackObject(true));
		addParallel(new RunAugerAndElevateBalls());
	}
}
