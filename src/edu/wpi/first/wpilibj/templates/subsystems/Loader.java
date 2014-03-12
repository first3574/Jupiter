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
        public static final double PAST_LIMIT = 1.5;
        public static final double LIMIT = 0;
	public static final double START = -0.059;
	public static final double LOAD = -0.347;
	public static final double SHOOTSAFE = -0.386;	
	public static final double CARRY = -0.552;
	public static final double PICKUP = -0.709;
        
       private double limitPosition = 1;
               
              
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
    
    public void setPosition (double positionName) {
	//todo: add offset from a value check on startup
	try {
	    //todo:  why????
	    loaderJag.setX(limitPosition-positionName);
	} catch (Exception e) {
	    System.out.println("DX - Exception! - Loader Set Point");
	    e.printStackTrace();
	    System.out.println(e.getClass().toString());
        
	}
        
        
    }
    public void calibrateTo (double positionName) {
        try {
            this.limitPosition = loaderJag.getPosition() - positionName;
        } catch (Exception e) {
            e.printStackTrace();
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
