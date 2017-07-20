package org.usfirst.frc27.robot.commands.Util;

import org.usfirst.frc27.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetGyro extends Command {


	private long startTime = 0;
	private boolean finished = false;

	@Override
	protected void initialize(){
		startTime = System.currentTimeMillis();
		finished = false;
		Robot.navx.zeroYaw();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(System.currentTimeMillis() - startTime > 100){
			finished = true;
		}
	}

		@Override
	protected boolean isFinished() {
		return finished;
	}

}
