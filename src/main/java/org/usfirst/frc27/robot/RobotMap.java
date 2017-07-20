package org.usfirst.frc27.robot;


import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static CANTalon driveTrainLeftMotor1;
    public static CANTalon driveTrainLeftMotor2;
    
    public static CANTalon driveTrainRightMotor1;
    public static CANTalon driveTrainRightMotor2;
    
    public static CANTalon shooterMotor1;
    public static CANTalon shooterMotor2;
    
    public static CANTalon turretMotor;
    
    public static CANTalon climberMotorMaster;
    public static CANTalon climberMotorSlave;

    public static CANTalon harvesterMotor;
    
    public static CANTalon augerMotor;
	public static CANTalon ballElevator;

    public static DigitalInput turretHomeSensor;
    public static DigitalInput gearSensor;
    public static DigitalInput rightTurretHallSensor;
	public static DigitalInput leftTurretHallSensor;

	public static DigitalInput leftPegSensor;
	public static DigitalInput rightPegSensor;

	public static Compressor compressor;
	public static DoubleSolenoid arm;
	public static DoubleSolenoid flapper;

	public static Talon colorStrip;
	

	public static void init() {
    	
    	driveTrainLeftMotor1 = new CANTalon(12);
        LiveWindow.addActuator("DriveTrain", "LeftMotor1", driveTrainLeftMotor1);
        
        driveTrainLeftMotor2 = new CANTalon(14);
        LiveWindow.addActuator("DriveTrain", "LeftMotor2", driveTrainLeftMotor2);
        
        driveTrainRightMotor1 = new CANTalon(11);
        LiveWindow.addActuator("DriveTrain", "RightMotor1", driveTrainRightMotor1);
        
        driveTrainRightMotor2 = new CANTalon(13);
        LiveWindow.addActuator("DriveTrain", "RightMotor2", driveTrainRightMotor2);
        
       
        shooterMotor1 = new CANTalon(15);
        shooterMotor2 = new CANTalon(16);
        LiveWindow.addActuator("Shooter 1", "Shooter 1", shooterMotor1);
        LiveWindow.addActuator("Shooter 2", "Shooter 2", shooterMotor2);

        turretMotor = new CANTalon(17);
        LiveWindow.addActuator("Turret", "Turret Motor", turretMotor);

		// these needs to be inverted
        climberMotorMaster = new CANTalon(18);
        climberMotorSlave = new CANTalon(20);
        LiveWindow.addActuator("Climber", "ClimberMotors", climberMotorMaster);

		// this needs to be inverted
        ballElevator = new CANTalon(19);
        LiveWindow.addActuator("Ball Feed", "Elevator", ballElevator);

        harvesterMotor = new CANTalon(21);
        LiveWindow.addActuator("Ball Feed", "Ball Collector", harvesterMotor);

		// this needs to be inverted
        augerMotor = new CANTalon(22);
        LiveWindow.addActuator("Ball Feed", "AugerMotor", augerMotor);

        arm = new DoubleSolenoid(1,7,0);
		LiveWindow.addActuator("Pneumatics", "Arm", arm);

		flapper = new DoubleSolenoid(1,6,1);
		LiveWindow.addActuator("Pneumatics", "Flipper", flapper);

		turretHomeSensor = new DigitalInput(0);

		gearSensor = new DigitalInput(6);	
		
		rightPegSensor = new DigitalInput(5);
		leftPegSensor = new DigitalInput(4);

		rightTurretHallSensor = new DigitalInput(2);
		leftTurretHallSensor = new DigitalInput(3);

		colorStrip = new Talon(0);

		compressor = new Compressor(0);
		compressor.setClosedLoopControl(true);
	}
}
