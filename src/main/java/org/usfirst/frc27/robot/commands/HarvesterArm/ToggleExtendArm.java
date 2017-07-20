package org.usfirst.frc27.robot.commands.HarvesterArm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

/**
 * Created by cyocom on 2/18/17.
 */
public class ToggleExtendArm extends Command {

	public ToggleExtendArm() {
		requires(Robot.harvesterArm);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.harvesterArm.toggle();
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}
