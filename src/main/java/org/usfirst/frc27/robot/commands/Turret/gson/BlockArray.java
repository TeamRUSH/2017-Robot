package org.usfirst.frc27.robot.commands.Turret.gson;

import java.util.ArrayList;
import java.util.List;

public class BlockArray {

	private long blockCount;
	private long lastUpdated;
	private final List<Block> blocks = new ArrayList<Block>();
	
	public long getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(long blockCount) {
		this.blockCount = blockCount;
	}
	public long getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public List<Block> getBlocks() {
		return blocks;
	}
}
