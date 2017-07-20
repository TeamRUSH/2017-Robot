package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.robot.commands.DriveTrain.Turn90InDirectionBasedOnAlliance;
import org.usfirst.frc27.robot.commands.Util.ResetGyro;

/**
 * Created by cyocom on 3/25/17.
 */
public class ResetGyroAndTurn90 extends CommandGroup {

	public ResetGyroAndTurn90(){
		addSequential(new ResetGyro());
		addSequential(new Turn90InDirectionBasedOnAlliance());
	}
}
