package org.usfirst.frc27.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc27.robot.RobotMap;

public class BallElevator extends Subsystem {
	private final CANTalon ballElevator;

	public BallElevator(){
		ballElevator = RobotMap.ballElevator;
		ballElevator.setInverted(true);
		ballElevator.enableBrakeMode(true);
		ballElevator.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}

	public void enableOperatorControl(){
		ballElevator.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		ballElevator.enable();
	}

	public void stop(){
		ballElevator.set(0);
		ballElevator.disable();
	}

	public void ballsUp(){
		ballElevator.set(1);
	}

	public void ballsDown(){
		ballElevator.set(-1);
	}

	@Override
	protected void initDefaultCommand() {

	}
}
