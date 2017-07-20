package org.usfirst.frc27.robot.commands.Auger;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc27.robot.Robot;

 
public class RunAuger extends Command {
 
    public RunAuger() {
        requires(Robot.auger);
	}
 
    protected void initialize() {
    	Robot.auger.enableOperatorControl();
    }

    protected void execute() {
    	Robot.auger.feedIn();
    }
    
    protected boolean isFinished() {
    	return false;
	}
 
    protected void end() {
    	Robot.auger.stop();
	}
 
    protected void interrupted() {
        end(); 
	}
}