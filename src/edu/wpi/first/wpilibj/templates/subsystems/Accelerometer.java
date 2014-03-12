/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import com.sun.squawk.Method;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;


/**
 *
 * @author team3574
 */
public class Accelerometer extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
//	ADXL345_I2C accel = RobotMap.accel;
    ADXL345_I2C accel = new ADXL345_I2C(1, ADXL345_I2C.DataFormat_Range.k16G);
     
    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());

    }
    
    public double getX(){
	return accel.getAcceleration(ADXL345_I2C.Axes.kX);
    }
    public double getY(){
	return accel.getAcceleration(ADXL345_I2C.Axes.kY);
    }
    public double getZ(){
	return accel.getAcceleration(ADXL345_I2C.Axes.kZ);
    }
    
    
    public void updateStatus() {
	SmartDashboard.putNumber("debug\\accelX", accel.getAcceleration(ADXL345_I2C.Axes.kX));
	SmartDashboard.putNumber("debug\\accelY", accel.getAcceleration(ADXL345_I2C.Axes.kY));
	SmartDashboard.putNumber("debug\\accelZ", accel.getAcceleration(ADXL345_I2C.Axes.kZ));
		
	
	}
	
    
}

