// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.SOLENOID;

import edu.wpi.first.wpilibj.Compressor;
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
  // Compressor connected to a PH with a default CAN ID (1)
  private final Compressor m_compressor = new Compressor(PneumaticsModuleType.REVPH);

  public void extend_piston() {
    m_solenoid.set(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
   // Enable closed-loop mode based on the analog pressure sensor connected to the PH.
          // The compressor will run while the pressure reported by the sensor is in the
          // specified range ([70 PSI, 120 PSI] in this example).
          // Analog mode exists only on the PH! On the PCM, this enables digital control.
          
  public void start_compressor(){
   m_compressor.enableAnalog(85, 120);
  }
  // Get the pressure (in PSI) from the analog sensor connected to the PH.
  // This function is supported only on the PH!
  // On a PCM, this function will return 0.
  public double  pressure() {
    return m_compressor.getPressure();
  }
  public void close_compressor(){
    m_compressor.close();
  }
  
}
