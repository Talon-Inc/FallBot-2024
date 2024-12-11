// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.kForkliftMotor;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Forklift extends SubsystemBase {
  private final CANSparkMax forklift = new CANSparkMax(kForkliftMotor, MotorType.kBrushless);

  /** Creates a new Forklift. */
  public Forklift() {}

  public void moveUp() {
    forklift.set(0.5);
  }

  public void moveDown() {
    forklift.set(-0.5);
  }

public void stop() {
  forklift.set(0);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
