/*
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.IntakeDownConstants;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

// An IntakeDown command that uses an Intake subsystem. 
public class IntakeDownCommand extends Command {
  private final IntakeSubsystem m_take;

  /**
   * Powers the intake down, when finished passively holds the intake down.
   * 
   * We recommend that you use this to only move the intake into the paracord
   * and let the passive portion hold the intake down.
   *
   * @param intake The subsystem used by this command.
   */
  /* public IntakeDownCommand(IntakeSubsystem intake) {
    m_take = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_take.runIntake(IntakeDownConstants.INTAKE_DOWN_SPEED_DOWN);
  }
  */
/*
  // Called once the command ends or is interrupted.
  // Here we run intake down at low speed to ensure it stays down
  // When the next command is caled it will override this command
  @Override
  public void end(boolean interrupted) {
    m_take.runIntake(IntakeDownConstants.INTAKE_DOWN_HOLD_OUT);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
*/