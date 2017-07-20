package org.usfirst.frc27.robot.commands.Combined;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;

/**
 * Created by cyocom on 2/18/17.
 */
public class RunAugerAndElevateBalls extends Command {

	public RunAugerAndElevateBalls() {
		requires(Robot.auger);
		requires(Robot.ballElevator);
	}

	protected void initialize() {
		Robot.auger.enableOperatorControl();
		Robot.ballElevator.enableOperatorControl();
	}

	protected void execute() {
		if(Robot.shooter.isAtSpeed() || Robot.state.isManualOverride()){
			Robot.auger.feedIn();
			Robot.ballElevator.ballsUp();
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.auger.stop();
		Robot.ballElevator.stop();
	}

	protected void interrupted() {
		end();
	}
}
