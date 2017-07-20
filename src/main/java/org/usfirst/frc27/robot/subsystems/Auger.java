package org.usfirst.frc27.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

public class Auger extends Subsystem {

	private final CANTalon augerMotor;

	private Double[] last10Current = new Double[5];
	private static final double CURRENT_AVG_CUTOFF = 18;
	private boolean overCurrent = false;
	private long overCurrentMillis = 0;


	public Auger(){
		augerMotor = RobotMap.augerMotor;
		augerMotor.setInverted(false);
		augerMotor.enableBrakeMode(false);
		augerMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		initalizeArrays();
	}

	private void initalizeArrays() {
		last10Current[0] = 0d;
		last10Current[1] = 0d;
		last10Current[2] = 0d;
		last10Current[3] = 0d;
		last10Current[4] = 0d;
	}


	public void feedIn(){

		if(System.currentTimeMillis() % 25 == 0){
			Double current =  augerMotor.getOutputCurrent();	
			addCurrent(current);
		}
		
		
		double averageCurrent = getAvgCurrentFromArray(last10Current);

		if(averageCurrent > CURRENT_AVG_CUTOFF && !overCurrent){
			overCurrent = true;
			overCurrentMillis = System.currentTimeMillis() + 250;
		}

		if(overCurrent && !Robot.state.isManualOverride()){
			DriverStation.reportWarning("!OVERCURRENT!", false);
			if(System.currentTimeMillis() > overCurrentMillis){
				overCurrent = false;
				initalizeArrays();
				overCurrentMillis = 0;
			} else {
				feedOut();
			}
		} else {
			augerMotor.set(1);
		}
	}

	private double getAvgCurrentFromArray(Double[] array){
		double total = 0;

		for(Double value : array){
			total += value;
		}

		double average = total / 5;
		return average;
	}

	private void addCurrent(double current) {
		last10Current[4] = last10Current[3];
		last10Current[3] = last10Current[2];
		last10Current[2] = last10Current[1];
		last10Current[1] = last10Current[0];
		last10Current[0] = current;
	}

	public void feedOut(){
		augerMotor.set(-1);
	}

	public void stop(){
		augerMotor.set(0);
		augerMotor.disable();
	}

	public void enabledPIDMode(){
		augerMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
		augerMotor.enable();
	}

	public void enableOperatorControl(){
		augerMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		augerMotor.enable();
	}

	@Override
	protected void initDefaultCommand() {

	}
}
