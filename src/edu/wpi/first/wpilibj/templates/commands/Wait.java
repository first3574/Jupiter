/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;


/**
 *
 * @author team3574
 */
public class Wait extends CommandBase {
    public double m_timeSeconds;
    private String m_message = "Default";
    
    public Wait(double timeSeconds) {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	m_timeSeconds = timeSeconds;
	this.setTimeout(m_timeSeconds);
//	System.out.println("Wait instanced");
    }
    
    public Wait(double timeSeconds, String message) {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	this(timeSeconds);
	m_message = message;
//	System.out.println("Wait instanced");
    }

    // Called just before this Command runs the first time
    protected void initialize() { 	thePrintSystem.printWithTimestamp(getClass().getName()); 
	System.out.println("Wait initialized " + m_message);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//	System.out.println("Wait done? " + isTimedOut());
	if (this.isTimedOut()) {
	    System.out.println("Finished " + m_message + " Length: " + m_timeSeconds);
	    return true;
	} else {
	    return false;
	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
