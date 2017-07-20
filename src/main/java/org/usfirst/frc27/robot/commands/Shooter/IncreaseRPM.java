package org.usfirst.frc27.robot.commands.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;

/**
 * Created by cyocom on 3/1/17.
 */
public class IncreaseRPM extends Command {
	protected void initialize() {
		if(Robot.state.isManualOverride()) {
			Robot.state.increaseOffsetRPM(25);
		}
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}
