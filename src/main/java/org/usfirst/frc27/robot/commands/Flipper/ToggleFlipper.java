package org.usfirst.frc27.robot.commands.Flipper;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;

/**
 * Created by cyocom on 2/18/17.
 */
public class ToggleFlipper extends Command {

	public ToggleFlipper() {
		requires(Robot.flipper);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.flipper.toggle();
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
