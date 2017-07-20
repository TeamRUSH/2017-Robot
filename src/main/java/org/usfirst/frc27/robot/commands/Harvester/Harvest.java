package org.usfirst.frc27.robot.commands.Harvester;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;

/**
 * Created by cyocom on 2/18/17.
 */
public class Harvest extends Command {
	public Harvest() {
		requires(Robot.harvester);
	}

	protected void initialize() {
		Robot.harvester.enableOperatorControl();
	}

	protected void execute() {
		Robot.harvester.feedIn();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.harvester.stop();
	}

	protected void interrupted() {
		end();
	}
}
