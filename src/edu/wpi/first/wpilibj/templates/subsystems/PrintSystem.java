/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.PrintCommandDefault;

/**
 *
 * @author team3574
 */
public class PrintSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	// setDefaultCommand(new PrintCommandDefault());
    }

    public void print(String stringToPrint) {
	System.out.println(stringToPrint);
    }
    
    public void printWithTimestamp(String stringToPrint){
	System.out.print(DriverStation.getInstance().getMatchTime() + ": ");
	System.out.println(stringToPrint);
     }
   
     public void updateStatus() {
    }
}
