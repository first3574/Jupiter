package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.ADXL345_SPI;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import team.util.CANJaguar3574;
import team.util.SolenoidDoubleActing;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    public static CANJaguar3574 leftBackMotor;
    public static CANJaguar3574 leftFrontMotor;
    public static CANJaguar3574 rightFrontMotor;
    public static CANJaguar3574 rightBackMotor;
    public static CANJaguar loaderJag;
    public static DigitalInput ballDetectorRight = new DigitalInput (1);
    public static DigitalInput ballDetectorLeft = new DigitalInput (2);
    public static Encoder leftEncoder = new Encoder(11 , 10, true);
    public static Encoder rightEncoder = new Encoder(14, 13, false);
    public static DigitalInput catapultLimitSwich = new DigitalInput(8);
    //public static ADXL345_I2C accel = new ADXL345_I2C(1, ADXL345_I2C.DataFormat_Range.k2G);
    public static Compressor airCompressor = new Compressor(5, 1);
    
    public static SolenoidDoubleActing shifterPort = new SolenoidDoubleActing(7,8);
    
    public static AnalogChannel distancer = new AnalogChannel(3);
    
    //TODO
    public static SolenoidDoubleActing pin = new SolenoidDoubleActing(1, 2, true);
    public static SolenoidDoubleActing tensionHigh = new SolenoidDoubleActing(3, 4, true);
    public static SolenoidDoubleActing tensionLow  = new SolenoidDoubleActing(5, 6, true);
   

    static {
	System.out.println("Robot Map");
	try {
	    leftBackMotor = new CANJaguar3574();
	    leftBackMotor.jag = new CANJaguar(4, CANJaguar.ControlMode.kPercentVbus);
	} catch (Exception ex) {
	    System.out.println("!!! - 3 Failed init");
	    ex.printStackTrace();
	    System.out.println(ex.getClass().toString());
	}
	try {
	    leftFrontMotor = new CANJaguar3574();
	    leftFrontMotor.jag = new CANJaguar(5, CANJaguar.ControlMode.kPercentVbus);
//	    System.out.println("uinjiji");
	} catch (Exception ex) {
	    System.out.println("!! - 2 Failed init");
	    ex.printStackTrace();
	    System.out.println(ex.getClass().toString());	    
	}
	try {
	    rightFrontMotor = new CANJaguar3574();
	    rightFrontMotor.jag = new CANJaguar(3, CANJaguar.ControlMode.kPercentVbus);
	} catch (Exception ex) {
	    System.out.println("!!!! - 4 Failed init");
	    ex.printStackTrace();
	    System.out.println(ex.getClass().toString());
	}
	try {
	    rightBackMotor = new CANJaguar3574();
	    rightBackMotor.jag = new CANJaguar(2, CANJaguar.ControlMode.kPercentVbus);
	} catch (Exception ex) {
	    System.out.println("!!!!! - 5 Failed init");
	    ex.printStackTrace();
	    System.out.println(ex.getClass().toString());
	}
		try {
	    loaderJag = new CANJaguar(6, CANJaguar.ControlMode.kPosition);
	} catch (Exception ex) {
	    System.out.println("!!!!!! - 6 Failed init");
	    ex.printStackTrace();
	    System.out.println(ex.getClass().toString());
	}


	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static final int leftMotor = 1;
	// public static final int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static final int rangefinderPort = 1;
	// public static final int rangefinderModule = 1;
    }
}
