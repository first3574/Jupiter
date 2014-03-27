/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import team.util.CANJaguar3574;

/**
 *
 * @author team3574
 */
public class Loader extends Subsystem {
//    double StartPosition = .763;
   /* the value for test robot
    public static final double TOP_LIMIT_OFFSET = 0.04;
    public static final double START_OFFSET = 0.0;
    public static final double LOAD_OFFSET = -0.17;
    public static final double SHOOTSAFE_OFFSET = -0.24;
    public static final double CARRY_OFFSET = -0.3;
    public static final double PICKUP_OFFSET = -0.475;
    public static final double AUTONOMOUSLOAD_OFFSET = -.12;
    // setting it to original value
    double StartPosition = .92;
*/
    /// production 
    public static final double TOP_LIMIT_OFFSET = 0.08;
    public static final double START_OFFSET = 0.0;
    public static final double LOAD_OFFSET = -0.16;
    public static final double SHOOTSAFE_OFFSET = -0.29;
    public static final double CARRY_OFFSET = -0.47;
    public static final double PICKUP_OFFSET = -0.58;
    public static final double AUTONOMOUSLOAD_OFFSET = -.12;
    // setting it to original value
    double StartPosition = .92;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public CANJaguar loaderJag = RobotMap.loaderJag;
    AnalogChannel distancer = RobotMap.distancer;
    DigitalInput ballDetectorLeft = RobotMap.ballDetectorLeft;
    DigitalInput ballDetectorRight = RobotMap.ballDetectorRight;
    DigitalInput ballDetectorCenter = RobotMap.ballDetectorCenter;

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());
    }    
//reverse limit switch is load
    public Loader() {
	try {
	    loaderJag.setPID(-1000.0, -0.0, -0.0);
//	    loaderJag.enableControl();
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
    
    public void setOffsetSetpoint (double setpointConstantOffset) {
	//todo: add offset from a value check on startup
	this.setSetpoint(this.StartPosition + setpointConstantOffset);
	
    }
    
    public void setSetpoint (double setpoint) {
	try {
//	    loaderJag.setX(setpoint);
	    loaderJag.enableControl();
	    loaderJag.setX(setpoint);
	    
	} catch (Exception e) {
	    System.out.println("DX - Exception! - Loader Set Point");
	    e.printStackTrace();
	    System.out.println(e.getClass().toString());
	}
    }
    
    public double getSetpoint() {
	try {
	   return loaderJag.getX();	    
	} catch (Exception e) {
	    e.printStackTrace();
	    return -2;
	}
    }
    
    public boolean getBallSensorLeft(){
	return ballDetectorLeft.get();
    }
    
    public boolean getBallSensorRight(){
	return ballDetectorRight.get();
    }
    
    public boolean getBallSensorCenter() {
	return ballDetectorCenter.get();
    }
    
    public void CalibrateCurrentToLimitPosition() {
	try {
	    this.StartPosition = loaderJag.getPosition() - Loader.TOP_LIMIT_OFFSET;	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void CalibrateCurrentToStartPosition() {
	try {
	    this.StartPosition = loaderJag.getPosition();	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public double getPosition() {
	try {
	    return loaderJag.getPosition();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return 0;
    }
    
    public double getOffsetAsAPositionValue (double offsetValue) {
	return StartPosition + offsetValue;
    }

    public void updateStatus() {
	try {
	    SmartDashboard.putNumber("debug\\L setpoint", loaderJag.getX());
	    SmartDashboard.putNumber("debug\\L position", loaderJag.getPosition());
	    SmartDashboard.putBoolean("debug\\L bottom limit", loaderJag.getForwardLimitOK());
	    SmartDashboard.putBoolean("debug\\L top limit", loaderJag.getReverseLimitOK());
	    SmartDashboard.putNumber("debug\\distancer", distancer.getVoltage());
	    SmartDashboard.putBoolean("debug\\L ball Detector Left", ballDetectorLeft.get());
	    SmartDashboard.putBoolean("debug\\L ball Detector Right", ballDetectorRight.get());
	    SmartDashboard.putBoolean("debug\\L ball Detector Center", ballDetectorCenter.get());
	}
	catch(Exception e){
	    System.out.println("DX - Exception! - Loader Status Update");
	    e.printStackTrace();
	    System.out.println(e.getClass().toString());
	}
    }
}
