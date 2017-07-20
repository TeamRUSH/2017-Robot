package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.MotionProfile.GearNoArmMotionProfile;
import org.usfirst.frc27.robot.commands.Combined.RunAugerAndElevateBalls;
import org.usfirst.frc27.robot.commands.DriveTrain.DriveStraightForwardDistanceClosedLoop;
import org.usfirst.frc27.robot.commands.DriveTrain.FindTapeAndCenter;
import org.usfirst.frc27.robot.commands.DriveTrain.MotionProfileCMD;
import org.usfirst.frc27.robot.commands.DriveTrain.MotionProfileObjectCMD;
import org.usfirst.frc27.robot.commands.Shooter.SpinShooterAtRPM;
import org.usfirst.frc27.robot.commands.Turret.ResetPositionToCenter;
import org.usfirst.frc27.robot.commands.Util.ResetGyro;
import org.usfirst.frc27.robot.commands.Vision.TrackObject;
import org.usfirst.frc27.robot.commands.Vision.TrackObjectNoSpeed;

/**
 * Created by cyocom on 2/26/17.
 */
public class CenterPegGearNoArmAndShootRed2 extends CommandGroup {

	public CenterPegGearNoArmAndShootRed2(){
		addParallel(new ResetPositionToCenter(45));
		addSequential(new ResetGyro());
		addSequential(new DriveStraightForwardDistanceClosedLoop(60, 4, .05));
		addSequential(new FindTapeAndCenter());
		addSequential(new TrackObjectNoSpeed(true),1);
		addParallel(new SpinShooterAtRPM());
		addParallel(new RunAugerAndElevateBalls());
		addSequential(new TrackObjectNoSpeed(true));
	}
}
