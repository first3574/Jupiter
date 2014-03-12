/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Catapult.Shoot;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.CommandGroupBetterBase;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveForMeasurement;
import edu.wpi.first.wpilibj.templates.commands.Loader.LoadPosition;
import edu.wpi.first.wpilibj.templates.commands.Wait;

/**
 *
 * @author team3574
 */
public class AutonomousShootDriveForward extends CommandGroupBetterBase {
    
    protected void initialize() {
	addParallel(new LoadPosition());
	addSequential(new Wait(3));
	addParallel(new Shoot());
	addSequential(new Wait(1.5));
	addParallel(new DriveForMeasurement(0.5, 0.5, 100, 100));

	
    }
}
