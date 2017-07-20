package org.usfirst.frc27.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;
import org.usfirst.frc27.robot.commands.Harvester.HarvesterListener;

/**
 * Created by cyocom on 2/18/17.
 */
public class Harvester extends Subsystem {
	private final CANTalon harvesterMotor;

	private boolean running;

	public Harvester(){
		harvesterMotor = RobotMap.harvesterMotor;
		harvesterMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}

	public void feedIn(){
		harvesterMotor.set(1);
		running = true;
		reportStatus();
	}

	public void feedOut(){
		harvesterMotor.set(-1);
		running = true;
		reportStatus();
	}

	private void reportStatus() {
		SmartDashboard.putBoolean("harvesterRunning", running);
	}

	public void stop(){
		running = false;
		harvesterMotor.set(0);
		harvesterMotor.disable();
		reportStatus();
	}

	public void enableOperatorControl(){
		harvesterMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		harvesterMotor.enable();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new HarvesterListener());
	}

	public boolean isRunning(){
		return running;
	}
}
