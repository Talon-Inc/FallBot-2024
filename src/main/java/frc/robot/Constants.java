// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  //Drive Constants
  public static final int DRIVE_LEFT_FRONT_MOTOR = 2;
  public static final int DRIVE_LEFT_BACK_MOTOR = 4;
  public static final int DRIVE_RIGHT_FRONT_MOTOR = 1;
  public static final int DRIVE_RIGHT_BACK_MOTOR = 3;
  public static final MotorType DRIVE_MOTOR_TYPE = MotorType.kBrushless;
  public static final double SPEED = .5;
  public static final IdleMode DRIVE_IDLE_TYPE = IdleMode.kCoast;
  public static final int DRIVE_CURRENT = 30;
  public static double DRIVE_FACTOR = .5; // changed for turbo
  public static double TURN_FACTOR = .5;
  public static int DRIVE_REVERSE = 1; // Default drive; 1 = Front is panel, -1 = Front is intake

  //Controller Constants
  public static final int CONTROLLER_PORT = 0;
  
  //Pneumatics Constants
  public static final int SOLENOID = 5;
  
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
