// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*
package frc.robot.commands;

import frc.robot.Constants.IntakeConstants;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/// A command to take fuel into the robot.
public class IntakeInCommand extends Command {
  private final IntakeSubsystem m_rin;


  //Rolls fuel into the intake.
  
  // @param roller The subsystem used by this command.
  public IntakeInCommand(IntakeSubsystem intake) {
    m_rin = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_rin.runIntake(IntakeConstants.INTAKE_HOLD_IN);
  }

  // Called once the command ends or is interrupted. This ensures the roller is not running when not intented.
  @Override
  public void end(boolean interrupted) {
    m_rin.runIntake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
*/