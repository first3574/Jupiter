/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author team3574
 */
public class RobotSelfCheck extends CommandBase {
    
    int state = 0;
    boolean isDone = false;
    
    public RobotSelfCheck() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	
    }

    // Called just before this Command runs the first time
    protected void initialize() { 	thePrintSystem.printWithTimestamp(getClass().getName()); 
	state = 0;
	isDone = false;
    }
    
    void p(String s) {
	System.out.println(s);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	switch (state) {
	    case 0:
		p("robot self test!  use joystick 2, press Y for Yes, and X for no");
		p("are you ready?? (the wheels will turn)");
		if (oi.joystickTwoY()) {
		    state++;
		}
		if (oi.joystickTwoX()) {
		    p("then get ready");
		}
		break;
	    case 1:
		p("the test is done, good job");
		state++;
		break;
	    case 2:
		isDone = true;
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
