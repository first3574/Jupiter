/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.PrintSystem;

/**
 *
 * @author team3574
 */
public class PrintCommandButton extends CommandBase {
    
    int count = 0;
    
    public PrintCommandButton() {
	// Use requires() here to declare subsystem dependencies
	requires(thePrintSystem);
	thePrintSystem.print("constructor PrintCommandButton");
	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//	print.print("A");
	count = 0;
	thePrintSystem.print("initialize PrintCommandButton");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if (count < 5) {
	    thePrintSystem.print("execute PrintCommandButton");
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
	thePrintSystem.print("end PrintCommandButton");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
	thePrintSystem.print("interrupted PrintCommandButton");
    }
}
