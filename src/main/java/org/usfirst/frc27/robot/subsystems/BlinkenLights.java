package org.usfirst.frc27.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc27.robot.RobotMap;
import org.usfirst.frc27.robot.commands.BlinkenLights.BlinkController;
import org.usfirst.frc27.robot.commands.BlinkenLights.BlinkMode;

/**
 * Created by cyocom on 3/12/17.
 */
public class BlinkenLights extends Subsystem {

	private final Talon color;

	public BlinkenLights() {
		color = RobotMap.colorStrip;
	}


	public void stop() {
		color.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new BlinkController());
	}

	public void gearCollectedBlink() {
		color.set(1);
	}

	public void needGearBlink() {
		color.set(0.75);
	}

	public void shooterAtSpeedBlink() {
		color.set(0.5);
	}

	public void processBlinkMode(BlinkMode blinkMode) {
		switch(blinkMode){
			case NONE:
				stop();
				break;
			case GEAR_FLAP_EXTENDED:
				needGearBlink();
				break;
			case GEAR_COLLECTED:
				gearCollectedBlink();
				break;
			case SHOOTER_AT_SPEED:
				shooterAtSpeedBlink();
				break;
		}
	}
}