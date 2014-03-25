/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Catapult.Shoot;
import edu.wpi.first.wpilibj.templates.commands.CommandGroupBetterBase;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveForMeasurement;
import edu.wpi.first.wpilibj.templates.commands.Loader.AutonomousLoadPosition;
import edu.wpi.first.wpilibj.templates.commands.Loader.CalibrateCurrentAsStartPosition;
import edu.wpi.first.wpilibj.templates.commands.Loader.CarryPosition;
import edu.wpi.first.wpilibj.templates.commands.Loader.LoadPosition;
import edu.wpi.first.wpilibj.templates.commands.Loader.PickUpPosition;
import edu.wpi.first.wpilibj.templates.commands.Wait;

/**
 *
 * @author team3574
 */
public class SemiAutoFull2Shots extends CommandGroupBetterBase {
    
    protected void initialize() {
	addRunUntillDone(new CalibrateCurrentAsStartPosition());
	addRunUntillDone(new Wait(.2));
	addRunUntillDone(new AutonomousLoadPosition());
	addRunUntillDone(new Wait(.5));
//	addSequential(new Wait(3));
//	int distance =(int)( DriverStation.getInstance().getAnalogIn(1) * 1000);
//	addSequential(new DriveForMeasurement(0.5, 0.5, 816, 816)); // 872
//	addSequential(new DriveForMeasurement(.75, .75, 750, 750)); //650 ,1 Current
	addRunUntillDone(new DriveForMeasurement(1, 1, 573, 573)); //650 ,1
	addRunUntillDone(new CarryPosition());
	addRunUntillDone(new Wait(0.5));
	addRunUntillDone(new Shoot());
//	addSequential(new Wait(2.1)); //this is the working end
	addRunUntillDone(new Wait(5));
	addRunUntillDone(new PickUpPosition());
	addRunUntillDone(new DriveForMeasurement(-1, -1, -573, -573)); //650 ,1
	addRunUntillDone(new Wait(.5));
	addRunUntillDone(new LoadPosition());
    }
    
    public SemiAutoFull2Shots() {
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
