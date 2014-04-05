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
public class CalibrateCurrentAsStartPosition extends CommandBase {
    
    public CalibrateCurrentAsStartPosition() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	requires(theLoader);
    }

    // Called just before this Command runs the first time
    protected void initialize() { 	
	thePrintSystem.printWithTimestamp(getClass().getName()); 
	theLoader.CalibrateCurrentToStartPosition();
	System.out.println("Start Position" + theLoader.StartPosition);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
