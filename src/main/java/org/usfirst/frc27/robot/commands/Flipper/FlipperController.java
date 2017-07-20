package org.usfirst.frc27.robot.commands.Flipper;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

/**
 * Created by cyocom on 3/12/17.
 */
public class FlipperController extends Command {
	public FlipperController() {
		requires(Robot.flipper);
	}

	protected void initialize() {
	}

	protected void execute() {
		if(!RobotMap.gearSensor.get()){
			Robot.flipper.toggle();
		}
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
