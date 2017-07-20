package org.usfirst.frc27.robot.commands.Turret;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.usfirst.frc27.robot.ControllerInputMap;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

/**
 * Created by cyocom on 2/18/17.
 */
public class RotateTurretWithJoystick extends Command {

	GenericHID controller;
	private boolean shouldInit = false;
	private double initVal = -1;
	private boolean homed = false;
	private long lastSecond = 0;

	public RotateTurretWithJoystick(){
		requires(Robot.turret);
		controller = ControllerInputMap.logitechPad;
	}

	protected void initialize() {
		Robot.turret.enableOperatorMode();
	}

	protected void execute() {
//		if(shouldInit){
//			if(Robot.turret.getAngle() > 0 && homed){
//				initVal = 0;
//				shouldInit = false;
//				System.out.println("Turret at angle!" + Robot.turret.getAngle());
//			}
//
//			if(!RobotMap.turretHomeSensor.get()){
//				Robot.turret.resetPos();
//				Robot.turret.enableLimits();
//				initVal = 1;
//				homed = true;
//				System.out.println("Turret homed!");
//			}
//
//			Robot.turret.takeRealValue(initVal);
//		}

		boolean reverseLimitTriggered = !RobotMap.leftTurretHallSensor.get();
		boolean forwardLimitTriggered = !RobotMap.leftTurretHallSensor.get();
		double joystickValue = controller.getX(GenericHID.Hand.kLeft);


		if(reverseLimitTriggered){
			DriverStation.reportWarning("LEFT HALL SENSOR TRIGGERED", false);
			Robot.turret.resetPosLeft();
		} else if(forwardLimitTriggered){
			DriverStation.reportWarning("RIGHT HALL SENSOR TRIGGERED", false);
			Robot.turret.resetPosRight();
		} else{
			if(Robot.state.isManualOverride()){
				Robot.turret.takeJoystickValue(joystickValue);
			}
		}

		if(forwardLimitTriggered && (joystickValue <= 0)){
			if(Robot.state.isManualOverride()){
				Robot.turret.takeJoystickValue(joystickValue);
			}
		}

		if(reverseLimitTriggered && (joystickValue >= 0)){
			if(Robot.state.isManualOverride()){
				Robot.turret.takeJoystickValue(joystickValue);
			}
		}

		SmartDashboard.putNumber("current turret angle", Robot.turret.getAngle());
		SmartDashboard.putNumber("turret raw ticks", Robot.turret.getTicks());

		long currentSecond = LocalDateTime.now().getSecond();
		
		if(currentSecond == 0 || lastSecond < currentSecond){
//			DriverStation.reportWarning(String.format("second: %s turretPosition: %s",currentSecond, Robot.turret.getTicks()), false);
			lastSecond = currentSecond;
		}
	}
	
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.turret.disable();
	}

	protected void interrupted() {
		end();
	}
}
