/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.Drive.MotorScaler;

/**
 *
 * @author team3574
 */
public class DriveWithJoysticks extends CommandBase {
    public static MotorScaler motorScalerLeft = new MotorScaler();
    public static MotorScaler motorScalerRight = new MotorScaler();
    double fullSpeed = 1.0;
    
    public DriveWithJoysticks() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	requires(theDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() { 	thePrintSystem.printWithTimestamp(getClass().getName()); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	//double leftSpeed = oi.leftUpAndDown();
	double leftSpeed = motorScalerLeft.scale(oi.leftUpAndDown() * fullSpeed);
	SmartDashboard.putNumber("debug\\leftSpeed", leftSpeed);
	
	//double rightSpeed = oi.rightUpAndDown();
	double rightSpeed = motorScalerRight.scale(oi.rightUpAndDown() * fullSpeed);
	SmartDashboard.putNumber("debug\\rightSpeed", rightSpeed);
	
	theDrive.goVariable(-leftSpeed,-rightSpeed);
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
