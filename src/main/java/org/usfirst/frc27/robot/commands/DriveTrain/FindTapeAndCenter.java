package org.usfirst.frc27.robot.commands.DriveTrain;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

/**
 * Created by cyocom on 3/1/17.
 */
public class FindTapeAndCenter extends Command {

	private boolean finished = false;
	private boolean started = false;
	private boolean preStart = false;
	private int directionToTurn = 0;
	private long startTime = 0;


	protected void initialize() {
		started = false;
		finished = false;
		preStart = false;
		directionToTurn = 0;
		startTime = 0;
		Robot.driveTrain.enableGearMode();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		if(startTime != 0 && Math.abs(System.currentTimeMillis() - startTime) > 1000){
			preStart = true;
		}

		if(RobotMap.rightPegSensor.get() && RobotMap.leftPegSensor.get()){
			directionToTurn = 2;
			if(!started){
				started = true;
				startTime = System.currentTimeMillis();
			}
			DriverStation.reportWarning("both",false);
		} else if(RobotMap.rightPegSensor.get()){
			directionToTurn = 1;
			DriverStation.reportWarning("right",false);
		} else{
			directionToTurn = -1;
			DriverStation.reportWarning("left",false);
		}

		if(directionToTurn == 2){
			Robot.driveTrain.takeArcadeInputs(-.5,0);
		} else if(directionToTurn != 0){
			Robot.driveTrain.takeArcadeInputs(0,directionToTurn * .7);
		}

		double[] leftData = Robot.driveTrain.getLeftRotations();
		double[] rightData = Robot.driveTrain.getRightRotations();

		if(rightData[1] + leftData[1] < .1 && started && preStart){
			System.out.println(String.format("Current Time: %s Start Time: %s",System.currentTimeMillis(),startTime));
			finished = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		startTime = 0;
		Robot.driveTrain.stop();
		Robot.driveTrain.enableOperatorControl();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
