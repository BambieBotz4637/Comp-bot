// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*
package frc.robot.commands;

import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

// A ShooterOutCommand that uses a roller subsystem.
public class ShooterOutCommand extends Command {
  private final ShooterSubsystem m_sout;

   //@param shoots The subsystem used by this command.
  
  public ShooterOutCommand(ShooterSubsystem shoots) {
    m_sout = shoots;
    addRequirements(shoots);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_sout.runShoots(ShooterConstants.SHOOTER_SPEED);
  }

  // Called once the command ends or is interrupted. Ensures the roller
  // is not running after we let go of the button. 
  @Override
  public void end(boolean interrupted) {
    m_sout.runShoots(0.5);
  }

  // Returns true when the command should end.
// Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
*/