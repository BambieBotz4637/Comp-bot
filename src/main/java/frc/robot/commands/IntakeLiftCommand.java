/* 
package frc.robot.commands;

import frc.robot.subsystems.IntakeLiftSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.IntakeLiftConstants;

public class IntakeLiftCommand extends Command {
    private final IntakeLiftSubsystem m_lift;

    public IntakeLiftCommand(IntakeLiftSubsystem lift) {
        m_lift = lift;
        addRequirements(lift);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_lift.lift(IntakeLiftConstants.LIFT_HOLD_UP);
    }

    // Called once the command ends or is interrupted. Ensures the roller
    // is not running after we let go of the button.
    @Override
    public void end(boolean interrupted) {
        m_lift.lift(0);
        m_lift.lift(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
    */