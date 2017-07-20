package org.usfirst.frc27.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.robot.commands.Harvester.Harvest;
import org.usfirst.frc27.robot.commands.HarvesterArm.ToggleExtendArm;

/**
 * Created by cyocom on 2/26/17.
 */
public class ToggleExtendArmAndRunHarvester extends CommandGroup {

	public ToggleExtendArmAndRunHarvester(){
		addParallel(new ToggleExtendArm());
		addParallel(new Harvest(), 3);
	}
}
