/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author team3574
 */
public class PrintCommandDefault extends CommandBase {
    
    int count = 0;
    
    public PrintCommandDefault() {
	// Use requires() here to declare subsystem dependencies
	requires(thePrintSystem);
	thePrintSystem.print("constructor PrintCommandDefault");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	count = 0;
	thePrintSystem.print("initialize PrintCommandDefault ");
	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if (count < 5) {
	    thePrintSystem.print("execute PrintCommandDefault");
	    count++;
	} //else {
	    
	//}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return false;
	
    }

    // Called once after isFinished returns true
    protected void end() {
	thePrintSystem.print("end PrintCommandDefault ");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
	thePrintSystem.print("interrupted PrintCommandDefault ");
    }
}
