// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Pneumatics;


public class shoot_cannon extends Command {

  private Pneumatics pneumatics = null; 

  /** Creates a new shoot_cannon. */
  public shoot_cannon(Pneumatics pneumatics) {
    this.pneumatics = pneumatics;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /**Checks to see if tank pressure is lower than 85 psi
     * or greater than 110 psi and adjusts as needed
     * until proper threshold is met before "shooting cannon".
    */
    while(pneumatics.pressure() < 85 && pneumatics.pressure() > 110)
      if (pneumatics.pressure() < 85){
        pneumatics.start_compressor();
    
    } if (pneumatics.pressure() > 110){
        pneumatics.close_compressor();
    }  
    pneumatics.extend_piston();
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
