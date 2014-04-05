/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Drive;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author team3574
 */
public class DriveWithScale extends CommandBase {
    double beginspeed;
    double endspeed;
    double ticks;
    
    public DriveWithScale(double beginspeed,double endspeed,double ticks) {
	// Use requires() here to declare subsystem dependencies
	requires(theDrive);
	this.beginspeed = beginspeed;
	this.endspeed = endspeed;
	this.ticks = ticks;
    }

    // Called just before this Command runs the first time
    protected void initialize() { 	thePrintSystem.printWithTimestamp(getClass().getName()); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
