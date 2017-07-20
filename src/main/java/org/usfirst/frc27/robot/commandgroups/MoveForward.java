package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.robot.commands.DriveTrain.MotionProfileCMD;
import org.usfirst.frc27.robot.commands.HarvesterArm.ToggleExtendArm;
import org.usfirst.frc27.robot.commands.Turret.ResetPositionToCenter;

/**
 * Created by cyocom on 2/26/17.
 */
public class MoveForward extends CommandGroup {

	public MoveForward(){
		addParallel(new ToggleExtendArm());
		addParallel(new ResetPositionToCenter(0));
		addSequential(new MotionProfileCMD(MotionProfileCMD.OBJECTS));
	}
}
