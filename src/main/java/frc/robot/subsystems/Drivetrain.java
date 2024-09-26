// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.*;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase {
  private final CANSparkMax m_leftFrontDrive = new CANSparkMax(DRIVE_LEFT_FRONT_MOTOR, DRIVE_MOTOR_TYPE);
  private final CANSparkMax m_leftBackDrive = new CANSparkMax(DRIVE_LEFT_BACK_MOTOR, DRIVE_MOTOR_TYPE);

  private final CANSparkMax m_rightFrontDrive = new CANSparkMax(DRIVE_RIGHT_FRONT_MOTOR, DRIVE_MOTOR_TYPE);
  private final CANSparkMax m_rightBackDrive = new CANSparkMax(DRIVE_RIGHT_BACK_MOTOR, DRIVE_MOTOR_TYPE);


  private DifferentialDrive m_roboDrive = null;
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    m_leftBackDrive.follow(m_leftFrontDrive);
    m_rightBackDrive.follow(m_rightFrontDrive);

    m_leftFrontDrive.restoreFactoryDefaults();
    m_leftBackDrive.restoreFactoryDefaults();
    m_rightFrontDrive.restoreFactoryDefaults();
    m_rightBackDrive.restoreFactoryDefaults();

    //set right motors to be inversed/reversed
    //m_leftFrontDrive.setInverted(false);

    //set current limits
    m_leftFrontDrive.setSmartCurrentLimit(DRIVE_CURRENT);
    m_leftBackDrive.setSmartCurrentLimit(DRIVE_CURRENT);
    m_rightFrontDrive.setSmartCurrentLimit(DRIVE_CURRENT);
    m_rightBackDrive.setSmartCurrentLimit(DRIVE_CURRENT);

    //set idle behavior
    m_leftFrontDrive.setIdleMode(DRIVE_IDLE_TYPE);
    m_leftBackDrive.setIdleMode(DRIVE_IDLE_TYPE);
    m_rightFrontDrive.setIdleMode(DRIVE_IDLE_TYPE);
    m_rightBackDrive.setIdleMode(DRIVE_IDLE_TYPE);

    m_roboDrive = new DifferentialDrive(m_leftFrontDrive, m_rightFrontDrive);

  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    m_roboDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  public void moveLeftMotors(double speed) {
    m_leftFrontDrive.set(speed);
  }

  public void moveRightMotors(double speed) {
    m_rightFrontDrive.set(speed);
  }

  public void stop() {
    moveLeftMotors(0);
    moveRightMotors(0);
  }

  public void turbu() {
    DRIVE_FACTOR = 1;
  }

  public void unturbo() {
    DRIVE_FACTOR = .6;
  }

  public void reverseDirection() {
    DRIVE_REVERSE *= -1;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
