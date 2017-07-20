package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.MotionProfile.GearNoArmMotionProfile;
import org.usfirst.frc27.robot.commands.Combined.RunAugerAndElevateBalls;
import org.usfirst.frc27.robot.commands.DriveTrain.MotionProfileCMD;
import org.usfirst.frc27.robot.commands.DriveTrain.MotionProfileObjectCMD;
import org.usfirst.frc27.robot.commands.HarvesterArm.ToggleExtendArm;
import org.usfirst.frc27.robot.commands.Turret.ResetPositionToCenter;
import org.usfirst.frc27.robot.commands.Vision.TrackObject;

/**
 * Created by cyocom on 2/26/17.
 */
public class CenterPegGearNoArmAndShootBlue extends CommandGroup {

	public CenterPegGearNoArmAndShootBlue(){
		addParallel(new ResetPositionToCenter(-55));
		addSequential(new MotionProfileObjectCMD(new GearNoArmMotionProfile()),8);
		addParallel(new TrackObject(true));
		addParallel(new RunAugerAndElevateBalls());
	}
}
