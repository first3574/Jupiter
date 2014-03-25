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
import edu.wpi.first.wpilibj.templates.commands.Wait;

/**
 *
 * @author team3574
 */
public class DriveShoot1Stop extends CommandGroupBetterBase {
    
    public DriveShoot1Stop() {
	addRunUntillDone(new CalibrateCurrentAsStartPosition());
	addRunUntillDone(new Wait(.1));
	addRunUntillDone(new AutonomousLoadPosition());
	addRunUntillDone(new Wait(.25));
	addRunUntillDone(new DriveForMeasurement(1, 1, 500, 500)); 
	addParallel(new CarryPosition());
	addRunUntillDone(new Wait(0.15));
	addParallel(new Shoot());
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

    protected void initialize() {
    }
}
