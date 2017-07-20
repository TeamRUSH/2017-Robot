package org.usfirst.frc27.robot.commands.BlinkenLights;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

/**
 * Created by cyocom on 2/18/17.
 */
public class BlinkController extends Command {

	public BlinkController() {
		requires(Robot.lights);
	}

	protected void initialize() {
	}

	protected void execute() {
		BlinkMode blinkMode = BlinkMode.NONE;

		if(Robot.flipper.isDeployed()){
			blinkMode = BlinkMode.GEAR_FLAP_EXTENDED;
		}
		if(!RobotMap.gearSensor.get()){
			blinkMode = BlinkMode.GEAR_COLLECTED;
		}
		if(Robot.shooter.isAtSpeed()){
			blinkMode = BlinkMode.SHOOTER_AT_SPEED;
		}

		Robot.lights.processBlinkMode(blinkMode);
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
