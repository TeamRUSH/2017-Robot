
package org.usfirst.frc27.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.RobotMap;
import org.usfirst.frc27.robot.commands.Flipper.FlipperController;


public class Flipper extends Subsystem {

	private final DoubleSolenoid flapper;

	boolean deployed = false;

	public Flipper(){
		flapper = RobotMap.flapper;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new FlipperController());
	}

	private void retract(){
		flapper.set(Value.kReverse);
		deployed = false;
	}

	private void deploy(){
		flapper.set(Value.kForward);
		deployed = true;
	}
	public void toggle(){
		if(Robot.harvesterArm.isDeployed() || !RobotMap.gearSensor.get()){
			retract();
		} else {
			if(deployed){
				retract();
			} else {
				deploy();
			}
		}
		SmartDashboard.putBoolean("flipperDeployed", deployed);
	}

	public boolean isDeployed(){
		return deployed;
	}
}