package org.usfirst.frc27.robot.commands.BallElevator;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;

/**
 * Created by cyocom on 2/18/17.
 */
public class ElevateBalls extends Command {
	public ElevateBalls() {
		requires(Robot.ballElevator);
	}

	protected void initialize() {
		Robot.ballElevator.enableOperatorControl();
	}

	protected void execute() {
		Robot.ballElevator.ballsUp();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.ballElevator.stop();
	}

	protected void interrupted() {
		end();
	}
}
