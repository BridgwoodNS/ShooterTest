// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class setShootSpeed extends CommandBase {

  private double topSpeed, bottomSpeed;
  ShooterSubsystem shooterSubsystem;

  /** Creates a new setShootSpeed. */
  public setShootSpeed(ShooterSubsystem shooterSubsystem) {

    this.shooterSubsystem = shooterSubsystem;
    this.topSpeed = topSpeed;
    this.bottomSpeed = bottomSpeed;
    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    shooterSubsystem.motorsOn();
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