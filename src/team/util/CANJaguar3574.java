/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.util;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author team3574
 */
public class CANJaguar3574 {
    
    public CANJaguar jag;
    public int allowedExceptions = 5;
    int exceptions = 0;
    
    boolean working = true;

    
    public void setX(double outputValue){
	try {
	    if (working) {
		jag.setX(outputValue);
		if (exceptions > 0) {
		    //Could this be reseting the value of the exceptions when we don't run it?
		    exceptions--;
		}
	    }
	} catch (Exception ex) {
	    System.out.println("DX - Exception! - CAN Motor Move");
	    ex.printStackTrace();
	    System.out.println(ex.getClass().toString());
	    exceptions++;
	    if (exceptions >= allowedExceptions) {
		//We stop it from running the motor, but we don't explicitly stop trying to run the motor.
		working = false;
	    }
	}
    }
}
