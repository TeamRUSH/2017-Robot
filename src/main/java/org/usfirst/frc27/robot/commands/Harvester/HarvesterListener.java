package org.usfirst.frc27.robot.commands.Harvester;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;

/**
 * Created by cyocom on 2/26/17.
 */
public class HarvesterListener extends Command {

	private long timeToRunTo = 0;
	private boolean runHarvester = false;

	public HarvesterListener() {
		requires(Robot.harvester);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void initialize() {
	}

	protected void execute() {
		if (Robot.state.isArmRetracting()) {
			timeToRunTo = System.currentTimeMillis() + 5000;
			runHarvester = true;
			Robot.state.setArmRetracting(false);
		}

		if (runHarvester) {
			if (timeToRunTo > System.currentTimeMillis()) {
				Robot.harvester.feedIn();
			} else {
				runHarvester = false;
				Robot.harvester.stop();
			}
		}
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}

}
