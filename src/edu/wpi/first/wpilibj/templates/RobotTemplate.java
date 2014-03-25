/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import com.sun.squawk.platform.BaseGCFFile;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.Autonomous.AutonomousCurrentProject;
import edu.wpi.first.wpilibj.templates.commands.Autonomous.AutonomousVision;
import edu.wpi.first.wpilibj.templates.commands.Autonomous.DriveShoot1Stop;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveForMeasurement;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveFromDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.ExampleCommand;
import edu.wpi.first.wpilibj.templates.commands.ShiftGear2;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
	// instantiate the command used for the autonomous period
//	autonomousCommand = new DriveShoot1Stop();
	autonomousCommand = new AutonomousVision();
//	autonomousCommand = new AutonomousCurrentProject();
	
	// Initialize all subsystems
	CommandBase.init();
    }

    public void disabledPeriodic() {
	this.updateStatus();
    }

    public void autonomousInit() {
	// schedule the autonomous command (example)
	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
	Scheduler.getInstance().run();
	this.updateStatus();
	RobotMap.airCompressor.start();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
	// teleop starts running. If you want the autonomous to 
	// continue until interrupted by another command, remove
	// this line or comment it out.
	autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
	Scheduler.getInstance().run();
	this.updateStatus();
	RobotMap.airCompressor.start();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
	LiveWindow.run();
	this.updateStatus();
    }

    private void updateStatus() {
	CommandBase.theDrive.updateStatus();
	CommandBase.theBling.updateStatus();
	CommandBase.theCatcher.updateStatus();
	CommandBase.theLoader.updateStatus();
	CommandBase.theShifter.updateStatus();
	CommandBase.theCatapult.updateStatus();
	CommandBase.thePrintSystem.updateStatus();
	CommandBase.theAccel.updateStatus();
	CommandBase.theCameraFeedback.updateStatus();
	//TODO: Move Update Status to subsystem base class.
    }
}
