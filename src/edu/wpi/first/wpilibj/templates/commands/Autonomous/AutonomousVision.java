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
import edu.wpi.first.wpilibj.templates.commands.WaitForTimeToShoot;

/**
 *
 * @author team3574
 */
public class AutonomousVision extends CommandGroupBetterBase {
    
    public AutonomousVision() {
	addRunUntillDone(new CalibrateCurrentAsStartPosition());
	addRunUntillDone(new Wait(.1));
	addRunUntillDone(new AutonomousLoadPosition());
	addRunUntillDone(new Wait(.25));
	addRunUntillDone(new DriveForMeasurement(1, 1, 532, 532)); //was 564 - too close, was 500 - too far
	addParallel(new CarryPosition());
	addRunUntillDone(new WaitForTimeToShoot());
	addRunUntillDone(new Shoot());
    }

    protected void initialize() {
    }
}
