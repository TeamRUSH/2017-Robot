package org.usfirst.frc27.robot.commands.Turret.gson;

public class Block {
	private long targetX;
	private long targetY;
	private long targetHeight;
	private long targetWidth;
	
	public long getTargetX() {
		return targetX;
	}
	public void setTargetX(long targetX) {
		this.targetX = targetX;
	}
	public long getTargetY() {
		return targetY;
	}
	public void setTargetY(long targetY) {
		this.targetY = targetY;
	}
	public long getTargetHeight() {
		return targetHeight;
	}
	public void setTargetHeight(long targetHeight) {
		this.targetHeight = targetHeight;
	}
	public long getTargetWidth() {
		return targetWidth;
	}
	public void setTargetWidth(long targetWidth) {
		this.targetWidth = targetWidth;
	}

	@Override
	public String toString(){
		return String.format("Block [targetX: %s, targetY: %s, targetHeight: %s, targetWidth: %s]", //
				targetX, targetY, targetHeight, targetWidth);
	}
}
