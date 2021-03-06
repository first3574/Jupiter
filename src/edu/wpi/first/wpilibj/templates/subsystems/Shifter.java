/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import team.util.SolenoidDoubleActing;

/**
 *
 * @author team3574
 */
public class Shifter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    SolenoidDoubleActing shifterPort = RobotMap.shifterPort;
    int gear = 1;

    public Shifter() {
	this.gear2();
    }

    public void initDefaultCommand() {
    }
    // Set the default command for a subsystem here.
    //setDefaultCommand(new MySpecialCommand());

    public void gear1() {
	shifterPort.set(false);
	gear = 1;
    }

    public void gear2() {
	shifterPort.set(true);
	gear = 2;
    }

    public int getGear() {
	//TODO: Check solenoid state
	return gear;
    }

    public void updateStatus() {
    }
}
