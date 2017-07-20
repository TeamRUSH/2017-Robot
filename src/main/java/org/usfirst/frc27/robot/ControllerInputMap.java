

package org.usfirst.frc27.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc27.robot.commandgroups.ResetGyroAndTurn90;
import org.usfirst.frc27.robot.commandgroups.ToggleExtendArmAndRunHarvester;
import org.usfirst.frc27.robot.commands.Climber.Climb;
import org.usfirst.frc27.robot.commands.Combined.ReverseAugerAndEvacuateBalls;
import org.usfirst.frc27.robot.commands.Combined.RunAugerAndElevateBalls;
import org.usfirst.frc27.robot.commands.DriveTrain.DriveStraightForwardDistance;
import org.usfirst.frc27.robot.commands.DriveTrain.DriveStraightForwardDistanceClosedLoop;
import org.usfirst.frc27.robot.commands.DriveTrain.FindTapeAndCenter;
import org.usfirst.frc27.robot.commands.DriveTrain.Turn90InDirectionBasedOnAlliance;
import org.usfirst.frc27.robot.commands.Flipper.ToggleFlipper;
import org.usfirst.frc27.robot.commands.Harvester.Harvest;
import org.usfirst.frc27.robot.commands.HarvesterArm.ToggleExtendArm;

import org.usfirst.frc27.robot.commands.Turret.GoToClosePegAngleAndSpinShooter;
import org.usfirst.frc27.robot.commands.Turret.ResetPositionToCenter;
import org.usfirst.frc27.robot.commands.Vision.TrackObject;
import org.usfirst.frc27.robot.commands.Util.SetManualOverride;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class ControllerInputMap {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

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




    private JoystickButton button_Y;
	private JoystickButton button_B;
	private JoystickButton button_X;
	private JoystickButton button_A;
	private JoystickButton button_11;
	public static GenericHID logitechPad;
	private GenericHID leftJoystick;
	private GenericHID rightJoystick;
	private JoystickButton trigger_Left;
	private JoystickButton trigger_Right;
	private JoystickButton pad_trigger_left;
	private JoystickButton pad_trigger_right;

	private JoystickButton Right_12;
	private JoystickButton Right_8;
	private JoystickButton Right_7;
	private JoystickButton Right_6;
	private JoystickButton Right_5;
	private JoystickButton Right_4;
	private JoystickButton Right_3;
	private JoystickButton Right_2;
	private JoystickButton Left_2;
	private JoystickButton Left_3;
	private JoystickButton Left_4;
	private JoystickButton Left_5;
	private JoystickButton Left_6;
	private JoystickButton Left_7;
	private JoystickButton Left_8;
	private JoystickButton Left_12;
	private JoystickButton Right_11;
	private JoystickButton Right_10;
	private JoystickButton Right_9;
	private JoystickButton trigger_right;
	private JoystickButton trigger_left;
	private JoystickButton bumper_right;
	private JoystickButton bumper_left;
	private JoystickButton back;
	private JoystickButton start;
	private JoystickButton left_stick_press;
	private JoystickButton right_stick_press;
	private JoystickButton Left_9;
	private JoystickButton Left_10;
	private JoystickButton Left_11;

	public ControllerInputMap() {
        leftJoystick = new Joystick(0);
        rightJoystick = new Joystick(1);
        logitechPad = new Joystick(2);
        
        //////////////////////////////////////////////////////////////////////////////////////////////
        //                                                                    ^                     //
        //                Mapping the buttons on the joy stick to their IDs   |                     //
        //      |----------Remember to add constructor at top                 |                     // 
        //      V                                                                                   //
        //////////////////////////////////////////////////////////////////////////////////////////////
        					/////////////////////////////
        					//     Right Joystick      //
        					/////////////////////////////
        trigger_Right = new JoystickButton(rightJoystick, 1);
        Right_2 = new JoystickButton(rightJoystick, 2);
        Right_3 = new JoystickButton(rightJoystick, 3);
        Right_4 = new JoystickButton(rightJoystick, 4);
        Right_5 = new JoystickButton(rightJoystick, 5);
        Right_6 = new JoystickButton(rightJoystick, 6);
        Right_7 = new JoystickButton(rightJoystick, 7);
        Right_8 = new JoystickButton(rightJoystick, 8);
        Right_9 = new JoystickButton(rightJoystick, 9);
        Right_10 = new JoystickButton(rightJoystick, 10);
        Right_11 = new JoystickButton(rightJoystick, 11);
        Right_12 = new JoystickButton(rightJoystick, 12);
							/////////////////////////////
							//     Left Joystick       //
							/////////////////////////////
        trigger_Left = new JoystickButton(leftJoystick, 1);
        Left_2 = new JoystickButton(leftJoystick, 2);
        Left_3 = new JoystickButton(leftJoystick, 3);
        Left_4 = new JoystickButton(leftJoystick, 4);
        Left_5 = new JoystickButton(leftJoystick, 5);
        Left_6 = new JoystickButton(leftJoystick, 6);
        Left_7 = new JoystickButton(leftJoystick, 7);
        Left_8 = new JoystickButton(leftJoystick, 8);
        Left_9 = new JoystickButton(leftJoystick, 9);
        Left_10 = new JoystickButton(leftJoystick, 10);
        Left_11 = new JoystickButton(leftJoystick, 11);
        Left_12 = new JoystickButton(leftJoystick, 12);
							/////////////////////////////
							//        Controller       //
							/////////////////////////////
        button_X = new JoystickButton(logitechPad, 1);        
        button_A = new JoystickButton(logitechPad, 2);
        button_B = new JoystickButton(logitechPad, 3);
        button_Y = new JoystickButton(logitechPad, 4);
        bumper_left = new JoystickButton(logitechPad, 5);
        bumper_right = new JoystickButton(logitechPad, 6);
        pad_trigger_left = new JoystickButton(logitechPad, 7);
        pad_trigger_right = new JoystickButton(logitechPad, 8);
        back = new JoystickButton(logitechPad, 9);
        start = new JoystickButton(logitechPad, 10);
        left_stick_press = new JoystickButton(logitechPad, 11);
        right_stick_press = new JoystickButton(logitechPad, 12);
        
        //////////////////////////////////////////////////////////////////////////////////////////////
        //                                                                          |               //
        //     Defining what code will be called when mapped buttons are pressed    |               //
        //                                                                          V               //
        //////////////////////////////////////////////////////////////////////////////////////////////
        
		button_B.whenPressed(new ToggleExtendArmAndRunHarvester());
		button_X.whileHeld(new Climb());
		button_A.toggleWhenPressed(new Harvest());
		button_Y.whenPressed(new ToggleFlipper());
		bumper_right.whileHeld(new RunAugerAndElevateBalls());
		bumper_left.whileHeld(new TrackObject());
//		pad_trigger_left.whenPressed(new DriveStraightForwardDistanceClosedLoop(84, 4));
		pad_trigger_left.whenPressed(new FindTapeAndCenter());
		pad_trigger_right.whileHeld(new ReverseAugerAndEvacuateBalls());
		back.whenPressed(new ResetPositionToCenter());
		start.toggleWhenPressed(new SetManualOverride());
    }

    
    public Joystick getLeftJoystick() {
        return (Joystick) leftJoystick;
    }

    public Joystick getRightJoystick() {
        return (Joystick) rightJoystick;
    }

    public Joystick getLogitechPad() {
        return (Joystick) logitechPad;
    }    
    
}

