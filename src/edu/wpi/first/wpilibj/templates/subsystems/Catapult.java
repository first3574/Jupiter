/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import team.util.SolenoidDoubleActing;

/**
 *
 * @author team3574
 */
public class Catapult extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SolenoidDoubleActing pin = RobotMap.pin;
    SolenoidDoubleActing tensionHigh = RobotMap.tensionHigh;
    SolenoidDoubleActing tensionLow = RobotMap.tensionLow;
    
    boolean stateOfTensionMore;
    boolean stateOfTensionLess;
    boolean isLoaderArmBroke = false;

    public Catapult() {
	this.pinHold();
	this.ChooseHowMuchTensionToUse(true, true);
	this.ApplyTension();
    }
    

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());
    }

    public void tensionRelease() {
	tensionHigh.set(false);
	tensionLow.set(false);
    }
    
    public void pinHold() {
	pin.set(true);
    }
    
    public void PinRelease() {
	pin.set(false);
    }
    public void ChooseHowMuchTensionToUse(boolean tensionMoreInegaged, boolean tensionLessInegaged) {
	stateOfTensionMore = tensionMoreInegaged;
	stateOfTensionLess = tensionLessInegaged;
    }
    public void ApplyTension() {
	tensionHigh.set(stateOfTensionMore);
	tensionLow.set(stateOfTensionLess);
    }
    
    public void shootOverrideBecauseArmBroke(boolean state) {
	this.isLoaderArmBroke = state;
    }
    
    public boolean getIfTheLoaderArmBroke() {
	return isLoaderArmBroke;
    }
	    
    public void updateStatus() {
	SmartDashboard.putBoolean("debug\\LimitSwitchState", RobotMap.catapultLimitSwich.get());
	
    }
}
