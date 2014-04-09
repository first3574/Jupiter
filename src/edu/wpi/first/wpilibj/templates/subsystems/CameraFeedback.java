/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author team3574
 */
public class CameraFeedback extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    NetworkTable client = NetworkTable.getTable("Vision");
    public boolean isGoalHot = false;
     
    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());
    }
    public boolean timeToShoot() {
	boolean verAndHorClose = client.getBoolean("Vertical_And_Horizontal_Close", false);
	isGoalHot = verAndHorClose;
//	System.out.println(verAndHorClose);
	return verAndHorClose;
    }
    public void updateStatus() {
	SmartDashboard.putBoolean("debug\\Time to Shoot!", timeToShoot());
	//System.out.println("camera: " + timeToShoot());
    }
}
