/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Drive;

import edu.wpi.first.wpilibj.Dashboard;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author team3574
 */
public class DriveFromDashboard extends CommandBase {
    
    double speed = 0.0;
    
    public DriveFromDashboard() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	requires(theDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() { 	thePrintSystem.printWithTimestamp(getClass().getName()); 
	speed = 0.0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	theDrive.goVariable(DriverStation.getInstance().getAnalogIn(1), 
		DriverStation.getInstance().getAnalogIn(1));
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
