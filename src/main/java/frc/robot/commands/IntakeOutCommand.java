// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*
package frc.robot.commands;

import frc.robot.Constants.IntakeConstants;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/// A command to take FUEL into the robot.
public class IntakeOutCommand extends Command {
  private final IntakeSubsystem m_rout;

  /**
  //Rolls FUEL into the intake.
   
   // @param roller The subsystem used by this command.
  
  public IntakeOutCommand(IntakeSubsystem intake) {
    m_rout = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_rout.runIntake(IntakeConstants.INTAKE_HOLD_OUT);
  }

  // Called once the command ends or is interrupted. This ensures the roller is not running when not intented.
  @Override
  public void end(boolean interrupted) {
    m_rout.runIntake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
  */