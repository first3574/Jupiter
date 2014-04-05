/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Catapult.Shoot;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.CommandGroupBetterBase;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveForMeasurement;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveForMeasurementNegative;
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
public class AutonomousCurrentProject extends CommandGroupBetterBase {
    
    protected void initialize() { 	 

	thePrintSystem.printWithTimestamp(getClass().getName());
	addRunUntillDone(new CalibrateCurrentAsStartPosition());
	addRunUntillDone(new Wait(.1));
	addRunUntillDone(new AutonomousLoadPosition());
	addRunUntillDone(new Wait(.25));
//	addSequential(new Wait(3));
//	int distance =(int)( DriverStation.getInstance().getAnalogIn(1) * 1000);
//	addSequential(new DriveForMeasurement(0.5, 0.5, 816, 816)); // 872
//	addSequential(new DriveForMeasurement(.75, .75, 750, 750)); //650 ,1 Current
	addRunUntillDone(new DriveForMeasurement(1, 1, 475, 475)); //650 ,1 //585 ?? right number is 475
	addParallel(new CarryPosition());
	addRunUntillDone(new Wait(0.15));
	addParallel(new Shoot());
//	addSequential(new Wait(2.1)); //this is the working end
	addRunUntillDone(new Wait(2.1));
	addParallel(new PickUpPosition());
	addRunUntillDone(new DriveForMeasurementNegative(-1, -1, -475, -475)); //650 ,1
	addRunUntillDone(new Wait(.5));
	addRunUntillDone(new LoadPosition());
//	Encoder 100 per rotation
//	Robot moves 19in per rotation
	addRunUntillDone(new Wait(0.2));
	addRunUntillDone(new DriveForMeasurement(1, 1, 475, 475));

	
    }
}
