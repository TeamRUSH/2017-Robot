package org.usfirst.frc27.robot.state;

import java.io.File;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc27.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc27.robot.RobotMap;

/**
 * Created by cyocom on 2/23/17.
 */
public class RobotState {

	public static final String PRACTICE_ROBOT_FILENAME = "/home/lvuser/I_AM_PRACTICE_BOT";

	private final double degreesOfTurretRotation;
	private final double degreesAtHome;
	private boolean manualOverride = false;
	private boolean armRetracting = false;
	private boolean climberOverCurrent = false;
	private boolean turretOverride = false;
	private int shooterOffset = 0;
	private boolean turretInitalized = false;
	private final double shooterDivisor;
	private final int shooterPixelOffsetY; // higher = lower speed
	private final int shooterPixelOffsetXBlue; //
	private final int shooterPixelOffsetXRed; //
	private boolean gearFlapExtended = false;
	private boolean gearCollected = false;
	private final int slaveOffset;
	private final double leftDriveTrainF;
	private final double rightDriveTrainF;
	private final boolean comp;
	private int shooterManualOffset = 0;
	private double turretManualOffset = 0;
	private boolean closedLoopDrive = false;

	public RobotState(){
		File practiceFile = new File(RobotState.PRACTICE_ROBOT_FILENAME);

		if(practiceFile.exists()){
			//
			degreesOfTurretRotation = 227.6185963;
			degreesAtHome = -112.860883;
			shooterDivisor = 0.09;
			shooterPixelOffsetY = 85;
			shooterPixelOffsetXBlue = -9;
			shooterPixelOffsetXRed = 9;
			leftDriveTrainF = 0.235;
			rightDriveTrainF = 0.245;
			comp = false;
			slaveOffset = 50;
		} else{
			// competition
			degreesOfTurretRotation = 227.6185963;
			degreesAtHome = -110.260883;
			shooterDivisor = 0.09;
			shooterPixelOffsetY = 85;
			shooterPixelOffsetXBlue = -9;
			shooterPixelOffsetXRed = 9;
			leftDriveTrainF = 0.238;
			rightDriveTrainF = 0.235;
			comp = true;
			slaveOffset = 33;
		}
	}

	public double getDistanceFromPixels(double pixels){
		if(isComp()){
			double slope = 111.1; // new 111.1 old 138.63
			double intercept = -194.57; // new -194.57 old -247.77
			return Math.exp((pixels - intercept) / slope) * 12;
		} else {
			double slope = 121.87;
			double intercept = -197.57;
			return Math.exp((pixels - intercept) / slope) * 12;
		}
	}

	public double getRpmFromDistance(double distance){
		if(isComp()){
			double slope = 10.512; // new 14 old 10.512
			double intercept = 1864.2; // new 1300 old 1864.2
			return (slope * distance )+ intercept;
		} else {
			double slope = 10.625;
			double intercept = 1961.9;
			return (slope * distance )+ intercept;
		}
	}

	public double getDegreesOfTurretRotation() {
		return degreesOfTurretRotation;
	}

	public double getDegreesAtHome() {
		return degreesAtHome;
	}

	public void setIsManualOverride(boolean manualOverride) {
		this.manualOverride = manualOverride;
	}

	public boolean isManualOverride(){
		return manualOverride;
	}

	public void setArmRetracting(boolean armRetracting) {
		this.armRetracting = armRetracting;
	}

	public boolean isArmRetracting() {
		return armRetracting;
	}

	public boolean isClimberOverCurrent() {
		return climberOverCurrent;
	}

	public void setClimberOverCurrent(boolean climberOvercurrent) {
		this.climberOverCurrent = climberOvercurrent;
	}

	public void setTurretOverride(boolean turretOverride) {
		this.turretOverride = turretOverride;
	}

	public boolean isTurretOverride() {
		return turretOverride;
	}

	public void increaseOffsetRPM(int offset) {
		shooterOffset += offset;
	}

	public void decreaseOffsetRPM(int offset) {
		shooterOffset -= offset;
	}

	public void resetRPMOffset() {
		shooterOffset = 0;
	}

	public int getShooterOffset(){
		return shooterOffset;
	}

	public boolean isTurretInitalized() {
		return turretInitalized;
	}

	public void setTurretInitalized(boolean turretInitalized) {
		this.turretInitalized = turretInitalized;
	}

	public double getAngleOffset(){
		if(isComp()){
			return 0d;
		}

		return 0d;
	}

	public double getShooterDivisor() {
		return shooterDivisor;
	}

	public int getShooterPixelOffset() {
		return shooterPixelOffsetY;
	}

	public boolean isComp() {
		return comp;
	}

	public int getShooterPixelOffsetX() {
		final int returnVal;
		if(Robot.ds.getAlliance().equals(DriverStation.Alliance.Blue)){
			returnVal = shooterPixelOffsetXBlue;
		} else{
			returnVal = shooterPixelOffsetXRed;
		}
		return returnVal;
	}

	public boolean isGearFlapExtended() {
		return gearFlapExtended;
	}

	public void setGearFlapExtended(boolean gearFlapExtended) {
		this.gearFlapExtended = gearFlapExtended;
	}

	public boolean isGearCollected() {
		return gearCollected;
	}

	public void setGearCollected(boolean gearCollected) {
		this.gearCollected = gearCollected;
	}

	public double getLeftDriveTrainF() {
		return leftDriveTrainF;
	}

	public double getRightDriveTrainF() {
		return rightDriveTrainF;
	}

	public int getSlaveOffset() {
		return slaveOffset;
	}

	public void increaseShooterManualOffset() {
		shooterManualOffset+=25;
		DriverStation.reportWarning(String.format("shooter_manual_offset %s",shooterManualOffset), false);
		SmartDashboard.putNumber("shooter_manual_offset", shooterManualOffset);
	}

	public void decreaseShooterManualOffset() {
		shooterManualOffset-=25;
		DriverStation.reportWarning(String.format("shooter_manual_offset %s",shooterManualOffset), false);
		SmartDashboard.putNumber("shooter_manual_offset", shooterManualOffset);
	}

	public void increaseTurretManualOffset() {
		turretManualOffset+=0.5;
		DriverStation.reportWarning(String.format("turret_manual_offset %s",turretManualOffset), false);
		SmartDashboard.putNumber("turret_manual_offset",turretManualOffset);
	}

	public void decreaseTurretManualOffset() {
		turretManualOffset-=0.5;
		DriverStation.reportWarning(String.format("turret_manual_offset %s",turretManualOffset), false);
		SmartDashboard.putNumber("turret_manual_offset",turretManualOffset);
	}

	public int getShooterManualOffset() {
		return shooterManualOffset;
	}

	public double getTurretManualOffset() {
		return turretManualOffset;
	}

	public boolean isClosedLoopDrive() {
		return closedLoopDrive;
	}

	public void setClosedLoopDrive(final boolean closedLoopDrive) {
		this.closedLoopDrive = closedLoopDrive;
	}
}
