package org.usfirst.frc27.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;

public class Climber extends Subsystem {
	private final CANTalon climberMotorMaster;
	private final CANTalon climberMotorSlave;

	private Double[] last10CurrentMaster = new Double[10];
	private Double[] last10CurrentSlave = new Double[10];

	private static final double CURRENT_AVG_CUTOFF = 50;

	private boolean overCurrent = false;

	public Climber(){
		climberMotorMaster = RobotMap.climberMotorMaster;
		climberMotorSlave = RobotMap.climberMotorSlave;
		climberMotorMaster.enableBrakeMode(false);
		climberMotorSlave.enableBrakeMode(false);
	}

	public void enableOperatorControl(){
		climberMotorMaster.enable();
		climberMotorSlave.enable();
		
		initalizeArrays();
	}

	private void initalizeArrays() {
		last10CurrentMaster[0] = 0d;
		last10CurrentMaster[1] = 0d;
		last10CurrentMaster[2] = 0d;
		last10CurrentMaster[3] = 0d;
		last10CurrentMaster[4] = 0d;
		last10CurrentMaster[5] = 0d;
		last10CurrentMaster[6] = 0d;
		last10CurrentMaster[7] = 0d;
		last10CurrentMaster[8] = 0d;
		last10CurrentMaster[9] = 0d;

		last10CurrentSlave[0] = 0d;
		last10CurrentSlave[1] = 0d;
		last10CurrentSlave[2] = 0d;
		last10CurrentSlave[3] = 0d;
		last10CurrentSlave[4] = 0d;
		last10CurrentSlave[5] = 0d;
		last10CurrentSlave[6] = 0d;
		last10CurrentSlave[7] = 0d;
		last10CurrentSlave[8] = 0d;
		last10CurrentSlave[9] = 0d;

	}

	public void stop(){
		climberMotorMaster.set(0);
		climberMotorSlave.set(0);

	}

	public void climb() {
		climberMotorMaster.enable();
		climberMotorSlave.enable();

		Double masterCurrent =  climberMotorMaster.getOutputCurrent();
		Double slaveCurrent =  climberMotorSlave.getOutputCurrent();

		addCurrents(masterCurrent, slaveCurrent);

		double masterAverage = getAvgCurrentFromArray(last10CurrentMaster);
		double slaveAverage = getAvgCurrentFromArray(last10CurrentSlave);
		DriverStation.reportWarning(String.format("Master Average: %samp - Slave Average: %samp", masterAverage, slaveAverage),false);

		if(masterAverage > CURRENT_AVG_CUTOFF ||
				slaveAverage > CURRENT_AVG_CUTOFF){
			overCurrent = true;
		}

		if(overCurrent && !Robot.state.isManualOverride()){
			climberMotorMaster.set(0);
			climberMotorSlave.set(0);
		} else {
			climberMotorMaster.set(1);
			climberMotorSlave.set(1);
		}
	}


	private double getAvgCurrentFromArray(Double[] array){
		double total = 0;

		for(Double value : array){
			total += value;
		}

		double average = total / 10;
		return average;
	}

	private void addCurrents(double masterCurrent, double slaveCurrent){
		last10CurrentMaster[9] = last10CurrentMaster[8];
		last10CurrentMaster[8] = last10CurrentMaster[7];
		last10CurrentMaster[7] = last10CurrentMaster[6];
		last10CurrentMaster[6] = last10CurrentMaster[5];
		last10CurrentMaster[5] = last10CurrentMaster[4];
		last10CurrentMaster[4] = last10CurrentMaster[3];
		last10CurrentMaster[3] = last10CurrentMaster[2];
		last10CurrentMaster[2] = last10CurrentMaster[1];
		last10CurrentMaster[1] = last10CurrentMaster[0];
		last10CurrentMaster[0] = masterCurrent;

		last10CurrentSlave[9] = last10CurrentSlave[8];
		last10CurrentSlave[8] = last10CurrentSlave[7];
		last10CurrentSlave[7] = last10CurrentSlave[6];
		last10CurrentSlave[6] = last10CurrentSlave[5];
		last10CurrentSlave[5] = last10CurrentSlave[4];
		last10CurrentSlave[4] = last10CurrentSlave[3];
		last10CurrentSlave[3] = last10CurrentSlave[2];
		last10CurrentSlave[2] = last10CurrentSlave[1];
		last10CurrentSlave[1] = last10CurrentSlave[0];
		last10CurrentSlave[0] = slaveCurrent;
	}

	@Override
	protected void initDefaultCommand() {
		climberMotorMaster.setInverted(false);
		climberMotorMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		climberMotorSlave.setInverted(true);
		climberMotorSlave.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		climberMotorMaster.enable();
		climberMotorSlave.enable();

	}
}
