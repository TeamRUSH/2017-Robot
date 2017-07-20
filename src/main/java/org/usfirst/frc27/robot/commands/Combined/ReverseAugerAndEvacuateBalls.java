package org.usfirst.frc27.robot.commands.Combined;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;

/**
 * Created by cyocom on 2/18/17.
 */
public class ReverseAugerAndEvacuateBalls extends Command {

	public ReverseAugerAndEvacuateBalls() {
		requires(Robot.auger);
		requires(Robot.harvester);
	}

	protected void initialize() {
		Robot.auger.enableOperatorControl();
		Robot.harvester.enableOperatorControl();
	}

	protected void execute() {
		if(Robot.state.isManualOverride()){
			Robot.auger.feedOut();
			Robot.harvester.feedOut();
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.auger.stop();
		Robot.harvester.stop();
	}

	protected void interrupted() {
		end();
	}
}
