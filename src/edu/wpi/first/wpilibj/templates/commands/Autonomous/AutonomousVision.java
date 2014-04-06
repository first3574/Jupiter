/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Catapult.Shoot;
import edu.wpi.first.wpilibj.templates.commands.CheckIsGoalHot;
import edu.wpi.first.wpilibj.templates.commands.CommandGroupBetterBase;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveForMeasurement;
import edu.wpi.first.wpilibj.templates.commands.Loader.AutonomousLoadPosition;
import edu.wpi.first.wpilibj.templates.commands.Loader.CalibrateCurrentAsStartPosition;
import edu.wpi.first.wpilibj.templates.commands.Loader.CarryPosition;
import edu.wpi.first.wpilibj.templates.commands.Loader.LoadPosition;
import edu.wpi.first.wpilibj.templates.commands.Wait;
import edu.wpi.first.wpilibj.templates.commands.WaitForTimeToShoot;

/**
 *
 * @author team3574
 */
public class AutonomousVision extends CommandGroupBetterBase {
    
    public AutonomousVision() {
//	addRunUntillDone(new CheckIsGoalHot());
	addRunUntillDone(new CalibrateCurrentAsStartPosition());
	addRunUntillDone(new Wait(.1));
	addRunUntillDone(new AutonomousLoadPosition());
	addRunUntillDone(new Wait(.25));
	// when we got to arben it was 532
	addRunUntillDone(new DriveForMeasurement(1, 1, 542, 542	));
//	addParallel(new CarryPosition()); // at the competition this worked, but we're changing it anyway because we're silly
	addParallel(new LoadPosition());
	addRunUntillDone(new WaitForTimeToShoot());
	addRunUntillDone(new Shoot());
    }

    protected void initialize() { 	 
	thePrintSystem.printWithTimestamp(getClass().getName());
    }
}
