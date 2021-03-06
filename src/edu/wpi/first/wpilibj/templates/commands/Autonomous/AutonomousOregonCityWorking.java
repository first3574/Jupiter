/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Catapult.Shoot;
import edu.wpi.first.wpilibj.templates.commands.CommandGroupBetterBase;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveForMeasurement;
import edu.wpi.first.wpilibj.templates.commands.Loader.CalibrateCurrentAsStartPosition;
import edu.wpi.first.wpilibj.templates.commands.Loader.CarryPosition;
import edu.wpi.first.wpilibj.templates.commands.Wait;

/**
 *
 * @author team3574
 */
public class AutonomousOregonCityWorking extends CommandGroupBetterBase {

    protected void initialize() { 	
	thePrintSystem.printWithTimestamp(getClass().getName()); 
	addRunUntillDone(new CalibrateCurrentAsStartPosition());
	addRunUntillDone(new Wait(.2));
	addRunUntillDone(new CarryPosition());
	addRunUntillDone(new Wait(2.0));
//	addSequential(new Wait(3));
//	int distance =(int)( DriverStation.getInstance().getAnalogIn(1) * 1000);
//	addSequential(new DriveForMeasurement(0.5, 0.5, 816, 816)); // 872
	addRunUntillDone(new DriveForMeasurement(.75, .75, 750, 750)); //650 ,1
//	addParallel(new CarryPosition());
	addRunUntillDone(new Wait(1.0));
	addParallel(new Shoot());
	addRunUntillDone(new Wait(1.5));
//	Encoder 100 per rotation
//	Robot moves 19in per rotation
    }
	    

    public AutonomousOregonCityWorking() {	
	// Add Commands here:
	// e.g. addSequential(new Command1());
	//      addSequential(new Command2());
	// these will run in order.

	// To run multiple commands at the same time,
	// use addParallel()
	// e.g. addParallel(new Command1());
	//      addSequential(new Command2());
	// Command1 and Command2 will run in parallel.

	// A command group will require all of the subsystems that each member
	// would require.
	// e.g. if Command1 requires chassis, and Command2 requires arm,
	// a CommandGroup containing them would require both the chassis and the
	// arm.
    }
}
