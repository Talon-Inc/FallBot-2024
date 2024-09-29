// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.SOLENOID;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  /** Creates a new Pneumatics. */
  public Pneumatics() {}

  // Solenoid corresponds to a single solenoid.
  // In this case, it's connected to channel 0 of a PH with the default CAN ID.
  private final Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.REVPH, SOLENOID);

  public void extend_piston() {
    m_solenoid.set(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
