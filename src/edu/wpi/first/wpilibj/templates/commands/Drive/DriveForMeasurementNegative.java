/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Drive;

import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author team3574
 */
public class DriveForMeasurementNegative extends CommandBase {

    double lSpeed = 0.0;
    double rSpeed = 0.0;
    double originalRightSpeed , originalLeftSpeed;
    int xLeft = 0;
    int xRight = 0;
    boolean done = false;

    public DriveForMeasurementNegative(double lSpeed, double rSpeed, int xLeft, int XRight) {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	//TODO: left and right count reset
	requires(theDrive);
	this.originalLeftSpeed = lSpeed;
	this.originalRightSpeed = rSpeed;
	this.lSpeed = lSpeed;
	this.rSpeed = rSpeed;
	this.xLeft = xLeft;
	this.xRight = XRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() { 	thePrintSystem.printWithTimestamp(getClass().getName()); 
	done = false;
	theDrive.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	theDrive.goVariable(lSpeed, rSpeed);
	if (RobotMap.rightEncoder.get() <= xRight) {
	    rSpeed = 0;
	} else if (RobotMap.rightEncoder.get() <= xRight + 200) {
	    rSpeed = ((xRight - RobotMap.rightEncoder.get()) / 200) * -originalRightSpeed;
	}
	
	if (RobotMap.leftEncoder.get() <= xLeft) {
	    lSpeed = 0;
	} else if (RobotMap.leftEncoder.get() <= xLeft + 200) {
	    lSpeed = ((xLeft - RobotMap.leftEncoder.get()) / 200) * -originalLeftSpeed;
	}
	if ((rSpeed == 0 && lSpeed == 0)) {
	    theDrive.goVariable(lSpeed, rSpeed);
	    done = true;
	}

//	speed += 0.001;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
