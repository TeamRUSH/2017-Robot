package org.usfirst.frc27.robot.commands.Climber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;

/**
 * Created by cyocom on 2/18/17.
 */
public class Climb extends Command {
	public Climb() {
		requires(Robot.climber);
	}

	protected void initialize() {
		Robot.climber.enableOperatorControl();
	}

	protected void execute() {
		Robot.climber.climb();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.climber.stop();
	}

	protected void interrupted() {
		end();
	}
}
