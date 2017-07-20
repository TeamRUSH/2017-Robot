package org.usfirst.frc27.robot.commands.Util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintTime extends Command {

	@Override
	protected void initialize(){
		DriverStation.reportWarning(String.format("Time: %s", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)),false);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
