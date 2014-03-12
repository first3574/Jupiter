/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author team3574
 */
public class WaitForTimeToShoot extends CommandBase {
    Timer time = new Timer();
    boolean isFinsh;
    
    public WaitForTimeToShoot() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	time.reset();
	time.start();
	isFinsh = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if (theCameraFeedback.timeToShoot() || time.get() > 5.0) {
	    isFinsh = true;
	   // TODO: Make this fail safe
	} else {
	   
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return isFinsh;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
