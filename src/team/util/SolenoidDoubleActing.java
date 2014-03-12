/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.util;

import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author team3574
 */
public class SolenoidDoubleActing {

    private Solenoid solenoid1;
    private Solenoid solenoid2;

    public SolenoidDoubleActing(int channel, int channel2) {
	SolenoidSetUP(channel, channel2);
	
    }
    
    public SolenoidDoubleActing(int channel, int channel2, boolean flip){
	if(flip = true) {
	    SolenoidSetUP(channel2, channel);
	}else{
	    SolenoidSetUP(channel, channel2);
	}
    }

    public void set(boolean on) {
	solenoid1.set(on);
	solenoid2.set(!on);
    }

    public boolean get() {
	return solenoid1.get();
    }

    private void SolenoidSetUP(int channel, int channel2) {
	solenoid1 = new Solenoid(channel);
	solenoid2 = new Solenoid(channel2);
    }
}
