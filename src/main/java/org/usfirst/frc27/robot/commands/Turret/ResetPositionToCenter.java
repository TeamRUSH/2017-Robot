package org.usfirst.frc27.robot.commands.Turret;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

import java.sql.Driver;
import java.util.Objects;

/**
 * Created by cyocom on 1/14/17.
 */
public class ResetPositionToCenter extends Command{

	private boolean homed = false;
	private double initVal = -1;
	private boolean isFinished = false;
	private double targetAngle = 1000;
	private boolean isAuto = false;
	
	public ResetPositionToCenter(double angle){
		targetAngle = angle;
		if(angle > 0){
			initVal = 1;
		} else {
			initVal = -1;
		}
	}

	public ResetPositionToCenter(){
	}
	
	protected void initialize() {
    	Robot.turret.disableLimits();
    	homed = false;

    	isFinished = false;
    	if(targetAngle > 400){
			targetAngle = Objects.equals(DriverStation.Alliance.Blue,Robot.ds.getAlliance()) ? -69 : 69;
			if(Alliance.Blue.equals(Robot.ds.getAlliance())){
				initVal = -1;
			} else {
				initVal = 1;
			}
		} else {
			if(targetAngle > 0){
				initVal = 1;
			} else {
				initVal = -1;
			}
		}
		DriverStation.reportWarning(String.format("Setting initVal to %s and targetAngle to %s",initVal, targetAngle),false);
	}

    protected void execute() {
		double diff = Math.abs(Robot.turret.getAngle() - targetAngle);
		DriverStation.reportWarning(String.format("sadness: %s", diff), false);

		if(!RobotMap.leftTurretHallSensor.get()){
			Robot.turret.resetPosLeft();
			Robot.turret.enableLimits();
			initVal = 1;
			homed = true;
			System.out.println("Turret homed!");
		}
		
		if(!RobotMap.rightTurretHallSensor.get()){
			Robot.turret.resetPosRight();
			Robot.turret.enableLimits();
			initVal = -1;
			homed = true;
			System.out.println("Turret homed!");
		}

		if(diff < 10 && homed){
			initVal = 0;
			System.out.println("Turret at angle! " + Robot.turret.getAngle());
			isFinished = true;
		}

		Robot.turret.takeRealValue(initVal);
    }

    protected boolean isFinished() {
    	if(isFinished){
    		isAuto = false;
    	}
        return isFinished;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }

}
