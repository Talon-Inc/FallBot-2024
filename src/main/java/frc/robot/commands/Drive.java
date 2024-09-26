// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.DRIVE_FACTOR;
import static frc.robot.Constants.DRIVE_REVERSE;
import static frc.robot.Constants.TURN_FACTOR;

import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.Command;

public class Drive extends Command {
  private Drivetrain drivetrain = null;
  private PS5Controller controller = null;
  /** Creates a new Drive. */
  public Drive(Drivetrain drivetrain, PS5Controller controller) {
    this.drivetrain = drivetrain;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }



 // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double moveSpeed = DRIVE_REVERSE * DRIVE_FACTOR * -controller.getLeftY();
    double rotateSpeed = TURN_FACTOR * -controller.getLeftX();
    drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
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
