/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveWithJoysticks;

/**
 *
 * @author team3574
 */
public class Drive extends Subsystem {

    Encoder leftEncoder = RobotMap.leftEncoder;
    Encoder rightEncoder = RobotMap.rightEncoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Drive() {
	super("Drive");
	
	System.out.println("Drive Constructed");
	leftEncoder.setDistancePerPulse(0.052);
	leftEncoder.setSamplesToAverage(5);
	leftEncoder.start();
	rightEncoder.setDistancePerPulse(0.052);
	rightEncoder.setSamplesToAverage(5);
	rightEncoder.start();
	
	LiveWindow.addSensor("Drive", "Left ENCODER ", leftEncoder);
	LiveWindow.addSensor("Drive", "Right ENCODER ", rightEncoder);
	LiveWindow.addActuator("Drive", "back left ", RobotMap.leftBackMotor.jag);
	LiveWindow.addActuator("Drive", "front left ", RobotMap.leftFrontMotor.jag);
	LiveWindow.addActuator("Drive", "back right ", RobotMap.rightBackMotor.jag);
	LiveWindow.addActuator("Drive", "front right ", RobotMap.rightFrontMotor.jag);
    }

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());
	setDefaultCommand(new DriveWithJoysticks());
    }

    public void updateStatus() {
	SmartDashboard.putNumber("debug\\Right encoder", rightEncoder.get());
	SmartDashboard.putNumber("debug\\Right encoder Rate", rightEncoder.getRate());
	SmartDashboard.putNumber("debug\\Left encoder", leftEncoder.get());
	SmartDashboard.putNumber("debug\\Left encoder Rate", leftEncoder.getRate());
    }

    public void goVariable(double leftSpeed, double rightSpeed) {
	RobotMap.leftBackMotor.setX(leftSpeed);
	RobotMap.leftFrontMotor.setX(leftSpeed);
	RobotMap.rightBackMotor.setX(-rightSpeed);
	RobotMap.rightFrontMotor.setX(-rightSpeed);

    }
}