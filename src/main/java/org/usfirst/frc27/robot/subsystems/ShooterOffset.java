package org.usfirst.frc27.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc27.robot.RobotMap;
import org.usfirst.frc27.robot.commands.BlinkenLights.BlinkController;
import org.usfirst.frc27.robot.commands.BlinkenLights.BlinkMode;
import org.usfirst.frc27.robot.commands.Vision.OffsetController;

/**
 * Created by cyocom on 3/12/17.
 */
public class ShooterOffset extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new OffsetController());
	}
}