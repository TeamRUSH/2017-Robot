package org.usfirst.frc27.robot.commands.HarvesterArm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc27.robot.Robot;

/**
 * Created by cyocom on 2/18/17.
 */
public class ExtendArm extends Command {

	public ExtendArm() {
		requires(Robot.harvesterArm);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.harvesterArm.deploy();
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
