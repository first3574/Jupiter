/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Drive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author team3574
 */
public class DriveForMeasurement extends CommandBase {

    double lSpeed = 0.0;
    double rSpeed = 0.0;
    double originalRightSpeed , originalLeftSpeed;
    int distanceLeft = 0;
    int distanceRight = 0;
    boolean done = false;
    Timer timer = new Timer();

    public DriveForMeasurement(double lSpeed, double rSpeed, int distanceLeft, int distanceRight) {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	//TODO: left and right count reset
	requires(theDrive);
	this.lSpeed = lSpeed;
	this.rSpeed = rSpeed;
	originalRightSpeed = rSpeed;
	originalLeftSpeed = lSpeed;
	this.distanceLeft = distanceLeft;
	this.distanceRight = distanceRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() { 	thePrintSystem.printWithTimestamp(getClass().getName()); 
	timer.reset();
	timer.start();
	done = false;
	theDrive.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if (RobotMap.rightEncoder.get() >= distanceRight) {
	    rSpeed = 0;
	}/*else if(RobotMap.rightEncoder.get() >= xRight - 200) {
	    rSpeed = ((xRight - RobotMap.rightEncoder.get())/200) * ((xRight - RobotMap.rightEncoder.get())/200) * originalRightSpeed;
	}*/
	
	if (RobotMap.leftEncoder.get() >= distanceLeft) {
	    lSpeed = 0;
	}/*else if (RobotMap.leftEncoder.get() >= xLeft - 200) {
	    lSpeed = ((xLeft - RobotMap.leftEncoder.get())/200) * ((xLeft - RobotMap.leftEncoder.get())/200) * originalLeftSpeed;
	    System.out.println("drive slow down");
	}*/
	theDrive.goVariable(lSpeed, rSpeed);
	if ((rSpeed == 0 && lSpeed == 0)) {
	    
	    done = true;
	}
	System.out.println("Left Encoder - " + RobotMap.leftEncoder.get() + ", Right Encoder - " + RobotMap.rightEncoder.get());
	System.out.println("Timer - " + timer.get());
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
