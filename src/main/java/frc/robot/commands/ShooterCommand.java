/*
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends Command {
 private final ShooterSubsystem m_shooter;

    public ShooterCommand(ShooterSubsystem shooter) {
        m_shooter = shooter;
        addRequirements(shooter);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_shooter.shoot(ShooterConstants.Shooter_SPEED_UP);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // forward() is not defined on ShooterSubsystem; call an existing method or implement forward() in the subsystem.
        m_shooter.shoot(ShooterConstants.Shooter_SPEED_UP);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_shooter.stop();
    }

    // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
    }
}
*/