/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Catapult;

import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author team3574
 */
public class TensionLow extends CommandBase {
    
    public TensionLow() {
	// Use requires() here to declare subsystem dependencies
//	 eg. requires(chassis);
	requires(theCatapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	theCatapult.tensionRelease();
	theCatapult.ChooseHowMuchTensionToUse(false, true);
	theCatapult.ApplyTension();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if(RobotMap.catapultLimitSwich.get() == true) {
	    theCatapult.pinHold();

	}
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
