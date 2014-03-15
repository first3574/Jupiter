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
public class DriveForMeasurement extends CommandBase {

    double lSpeed = 0.0;
    double rSpeed = 0.0;
    int xLeft = 0;
    int xRight = 0;
    boolean done = false;

    public DriveForMeasurement(double lSpeed, double rSpeed, int xLeft, int XRight) {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	//TODO: left and right count reset
	requires(theDrive);
	this.lSpeed = lSpeed;
	this.rSpeed = rSpeed;
	this.xLeft = xLeft;
	this.xRight = XRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	done = false;
	theDrive.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	theDrive.goVariable(lSpeed, rSpeed);
	if (RobotMap.rightEncoder.get() >= xRight) {
	    rSpeed = 0;
	}
	if (RobotMap.leftEncoder.get() >= xLeft) {
	    lSpeed = 0;
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
