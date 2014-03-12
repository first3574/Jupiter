/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import team.util.CANJaguar3574;

/**
 *
 * @author team3574
 */
public class Loader extends Subsystem {
	public static final double START = .830;
	public static final double LOAD = START - .229;
	public static final double CARRY = START - .512;
	public static final double PICKUP = START - .632;
	protected static final double SHOOTSAFE = START - .277;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    CANJaguar loaderJag = RobotMap.loaderJag;
    AnalogChannel distancer = RobotMap.distancer;

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());
    }    
//reverse limit switch is load
    public Loader() {
	try {
	    loaderJag.setPID(-1000.0, -0.0, -0.0);
	    loaderJag.enableControl();
	    loaderJag.setPositionReference(CANJaguar.PositionReference.kPotentiometer);
	    loaderJag.configPotentiometerTurns(1);
	} catch (Exception e) {
	    System.out.println("DX - Exception! - Loader PID Potentiometer");
	    e.printStackTrace();
	    System.out.println(e.getClass().toString());
	}
	try {
	    loaderJag.setX(0.0);
	}
	catch(Exception e){
	    System.out.println("DX - Exception! - Loader Set 0.0");
	    e.printStackTrace();
	    System.out.println(e.getClass().toString());
	}
    }
    
    public void setSetpoint (double setpoint) {
	//todo: add offset from a value check on startup
	try {
	    //todo:  why????
	    loaderJag.setX(setpoint);
	} catch (Exception e) {
	    System.out.println("DX - Exception! - Loader Set Point");
	    e.printStackTrace();
	    System.out.println(e.getClass().toString());
	}
    }
    
    

    public void updateStatus() {
	try {
	    SmartDashboard.putNumber("debug\\L getX", loaderJag.getX());
	    SmartDashboard.putNumber("debug\\L position", loaderJag.getPosition());
	    SmartDashboard.putBoolean("debug\\L forward limit", loaderJag.getForwardLimitOK());
	    SmartDashboard.putBoolean("debug\\L reverse limit", loaderJag.getReverseLimitOK());
	    SmartDashboard.putNumber("debug\\distancer", distancer.getVoltage());
	}
	catch(Exception e){
	    System.out.println("DX - Exception! - Loader Status Update");
	    e.printStackTrace();
	    System.out.println(e.getClass().toString());
	}
    }
}
