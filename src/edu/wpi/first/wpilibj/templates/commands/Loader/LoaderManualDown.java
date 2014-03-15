/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Loader;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author team3574
 */
public class LoaderManualDown extends CommandBase {
    
    public LoaderManualDown() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	requires (theLoader);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	double setpoint = theLoader.getSetpoint();
	if (setpoint != -2) {
		theLoader.setSetpoint(setpoint - .005);
	}
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
