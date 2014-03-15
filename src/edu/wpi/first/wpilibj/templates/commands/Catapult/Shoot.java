/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Catapult;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.Loader;

/**
 *
 * @author team3574
 */
public class Shoot extends CommandBase {

    Timer time = new Timer();
    boolean isFinsh;
    int state;

    public Shoot() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	requires(theCatapult);
	super.setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	theLoader.setOffsetSetpoint(Loader.SHOOTSAFE_OFFSET);
	theCatapult.PinRelease();
	time.reset();
	time.start();
	state = 0;
	isFinsh = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	switch (state) {
	    case 0:
		if (time.get() >= 1) {
		    theCatapult.tensionRelease();
		    state++;
		}
		break;
	    case 1:
		if (RobotMap.catapultLimitSwich.get() == true) {
		    time.reset();
		    state++;
		    //todo: make sure the timer starts again
		}
		break;
	    case 2:
		if (time.get() >= 2 && RobotMap.catapultLimitSwich.get() == true) {
		    theCatapult.pinHold();
		    state++;
		    time.reset();
		}
		break;
	    case 3:
		if (time.get() >= .5) {
		    state++;
		}
		break;
	    case 4:
		theCatapult.ApplyTension();
		isFinsh = true;
		break;
	}
	System.out.println(state);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return isFinsh;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    public boolean isInterruptible() {
	return false;
    }
}
