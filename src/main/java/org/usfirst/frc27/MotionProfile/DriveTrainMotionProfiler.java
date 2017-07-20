package org.usfirst.frc27.MotionProfile;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc27.robot.RobotMap;

import com.ctre.CANTalon;

public class DriveTrainMotionProfiler {
	private CANTalon talonLeft = RobotMap.driveTrainLeftMotor1;
	private CANTalon talonRight = RobotMap.driveTrainRightMotor1;
	
	//private double[][] leftPathPoints;
	//private int leftNumPathPoints
	//private double[][] rightPathPoints;
	
//	leftPath.kNumPoints = 0;
	
	public MotionProfiler leftProfiler = new MotionProfiler(talonLeft, "Left");
	public MotionProfiler rightProfiler = new MotionProfiler(talonRight, "Right");
	
	public void control() {
		leftProfiler.control();
		rightProfiler.control();	
	}
	
	public void reset() {
		leftProfiler.reset();
		rightProfiler.reset();
	}
	
	public void start() {
		leftProfiler.startMotionProfile();
		rightProfiler.startMotionProfile();
	}
	
	
	public List<CANTalon.SetValueMotionProfile> getSetValues() {
		List<CANTalon.SetValueMotionProfile> profiles = new ArrayList<CANTalon.SetValueMotionProfile>();
		profiles.add(leftProfiler.getSetValue());
		profiles.add(rightProfiler.getSetValue());
		return profiles;
	}

	public void setPaths(double[][] leftPath, double[][] rightPath) {
		System.out.println(String.format("Path lengths Right: %d  Left %d",
				leftPath.length,
				rightPath.length));
		
		
		leftProfiler.setPath(leftPath);
		rightProfiler.setPath(rightPath);		
	}
	
	
	public CANTalon.MotionProfileStatus getStatus(){
		return leftProfiler.getStatus();
	}
}