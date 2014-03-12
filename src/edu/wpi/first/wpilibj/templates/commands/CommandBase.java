package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveWithJoysticks;
import edu.wpi.first.wpilibj.templates.subsystems.Accelerometer;
import edu.wpi.first.wpilibj.templates.subsystems.Bling;
import edu.wpi.first.wpilibj.templates.subsystems.CameraFeedback;
import edu.wpi.first.wpilibj.templates.subsystems.Catapult;
import edu.wpi.first.wpilibj.templates.subsystems.Catcher;
import edu.wpi.first.wpilibj.templates.subsystems.Drive;
import edu.wpi.first.wpilibj.templates.subsystems.Loader;
import edu.wpi.first.wpilibj.templates.subsystems.PrintSystem;
import edu.wpi.first.wpilibj.templates.subsystems.Shifter;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Accelerometer theAccel = new Accelerometer();
    public static PrintSystem thePrintSystem = new PrintSystem();    
    public static Drive theDrive = new Drive();
    public static Shifter theShifter = new Shifter();
    public static Catapult theCatapult = new Catapult();
    public static Catcher theCatcher = new Catcher();
    public static Loader theLoader = new Loader();
    public static Bling theBling = new Bling();
    public static CameraFeedback theCameraFeedback = new CameraFeedback();
	    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(thePrintSystem);
        SmartDashboard.putData(theDrive);
	SmartDashboard.putData(theBling);
	SmartDashboard.putData(theCatapult);
	SmartDashboard.putData(theLoader);
	SmartDashboard.putData(theCatcher);
	SmartDashboard.putData(theShifter);
	SmartDashboard.putData(thePrintSystem);
	SmartDashboard.putData(theCameraFeedback);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
