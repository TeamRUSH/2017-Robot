package org.usfirst.frc27.robot.commands.Util;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.state.RobotState;

/**
 * Created by cyocom on 2/26/17.
 */
public class SetManualOverride extends Command {

	@Override
	protected void execute(){
		Robot.state.setIsManualOverride(true);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.state.setIsManualOverride(false);
	}

	protected void interrupted() {
		end();
	}
}
