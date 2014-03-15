/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Loader;

import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.Loader;

/**
 *
 * @author team3574
 */
public class CalibrateLoaderToLimit extends CommandBase {
    
    boolean isDone = false;
    
    public CalibrateLoaderToLimit() {
	// Use requires() here to declare subsystem dependencies
	 requires(theLoader);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	this.isDone = false;
	
	theLoader.setSetpoint(1.5);
	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	try {
	    if(!theLoader.loaderJag.getReverseLimitOK()) { // then we must be at the limit
		
		// since we're at the limit, calibrate!!
		theLoader.CalibrateCurrentToLimitPosition();
		
		// now that we've calibrated, go to the start postition
		theLoader.setOffsetSetpoint(Loader.START_OFFSET);
		isDone = true;
	    }
	} catch (CANTimeoutException ex) {
	    ex.printStackTrace();
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return this.isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
