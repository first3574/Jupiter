package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.Catapult.TensionHigh;
import edu.wpi.first.wpilibj.templates.commands.Catapult.TensionLow;
import edu.wpi.first.wpilibj.templates.commands.Catapult.TensionMedium;
import edu.wpi.first.wpilibj.templates.commands.Catapult.Shoot;
import edu.wpi.first.wpilibj.templates.commands.Loader.CalibrateLoaderToLimit;
import edu.wpi.first.wpilibj.templates.commands.Loader.CarryPosition;
import edu.wpi.first.wpilibj.templates.commands.Loader.LoaderManualUp;
import edu.wpi.first.wpilibj.templates.commands.Loader.LoadPosition;
import edu.wpi.first.wpilibj.templates.commands.Loader.LoaderManualDown;
import edu.wpi.first.wpilibj.templates.commands.Loader.LoaderManualStay;
import edu.wpi.first.wpilibj.templates.commands.Loader.PickUpPosition;
import edu.wpi.first.wpilibj.templates.commands.Loader.StartPosition;
import edu.wpi.first.wpilibj.templates.commands.PrintCommandButton;
import edu.wpi.first.wpilibj.templates.commands.ShiftGear1;
import edu.wpi.first.wpilibj.templates.commands.ShiftGear2;
import edu.wpi.first.wpilibj.templates.subsystems.PrintSystem;
import team.util.JoystickTrigger;
import team.util.XboxController;
import team.util.joystick.Axis;
import team.util.joystick.AxisSide;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public Joystick stickOne = new Joystick(1);
    Button btnA = new JoystickButton(stickOne, XboxController.A);
    Button btnB = new JoystickButton(stickOne, XboxController.B);
    Button btnX = new JoystickButton(stickOne, XboxController.X);
    Button btnY = new JoystickButton(stickOne, XboxController.Y);
    Button btnLB = new JoystickButton(stickOne, XboxController.LB);
    Button btnRB = new JoystickButton(stickOne, XboxController.RB);
    Button btnLeftStickClick = new JoystickButton(stickOne, XboxController.LeftStickClick);
    Button btnRightStickClick = new JoystickButton(stickOne, XboxController.RightStickClick);
    Button btnStart = new JoystickButton(stickOne,XboxController.Start);
    Button btnSelect = new JoystickButton(stickOne, XboxController.Select);
    Button btnDPLeft = new JoystickTrigger(stickOne, Axis.dPadHorizontal, AxisSide.left);
    Button btnDPRight = new JoystickTrigger(stickOne, Axis.dPadHorizontal, AxisSide.right);
    
    public OI() {
	System.out.print("Oi constructor!");
	btnA.whenPressed(new Shoot());
	btnX.whenPressed(new PickUpPosition());
	btnY.whenPressed(new CarryPosition());
	btnB.whenPressed(new LoadPosition());
	btnStart.whenPressed(new StartPosition());
	btnSelect.whenPressed(new CalibrateLoaderToLimit());

	btnRB.whenPressed(new ShiftGear2());
	btnLB.whenPressed(new ShiftGear1());
	
//	btnRightStickClick.whenPressed(new TensionHigh());
//	btnLeftStickClick.whenPressed(new TensionLow());
	

	btnDPLeft.whenPressed(new LoaderManualDown());
	btnDPLeft.whenReleased(new LoaderManualStay());
	
	btnDPRight.whenPressed(new LoaderManualUp());	
	btnDPRight.whenReleased(new LoaderManualStay());	
    }

    public double leftUpAndDown() {
	return stickOne.getRawAxis(2); //2
    }

    public double rightUpAndDown() {
	return stickOne.getRawAxis(5); //5
    }
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
