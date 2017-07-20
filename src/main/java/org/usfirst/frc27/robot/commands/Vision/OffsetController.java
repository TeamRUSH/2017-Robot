package org.usfirst.frc27.robot.commands.Vision;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.ControllerInputMap;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.subsystems.ShooterOffset;

/**
 * Created by cyocom on 4/8/17.
 */
public class OffsetController extends Command {

	private final GenericHID gamepad;
	private boolean released = true;

	public OffsetController(){
		requires(Robot.shooterOffset);
		gamepad = ControllerInputMap.logitechPad;
	}

	protected void initialize() {
	}

	protected void execute() {

		switch(gamepad.getPOV()){
			case 0:
				// Up
				if(released) {
					released = false;
					Robot.state.increaseShooterManualOffset();
				}
				break;
			case 90:
				// Right
				if(released) {
					released = false;
				Robot.state.increaseTurretManualOffset();
				}
				break;
			case 180:
				// Down
				if(released) {
					released = false;
				Robot.state.decreaseShooterManualOffset();
				}
				break;
			case 270:
				// Left
				if(released) {
					released = false;
				Robot.state.decreaseTurretManualOffset();
				}
				break;
			default:
			case -1:
				released = true;
				break;
		}
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
