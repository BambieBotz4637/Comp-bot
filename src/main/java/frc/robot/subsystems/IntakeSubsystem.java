package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.IntakeSubsystem;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {
    private SparkMax intakeMotor;

    public IntakeSubsystem() {
        intakeMotor = new SparkMax(12, MotorType.kBrushless);
    }

    public void runIntake(double speed) {
        intakeMotor.set(0.5);
    }

    /*
     * public void reverseIntake() {
     * intakeMotor.set(-0.5);
     */


    public void stopIntake() {
        intakeMotor.set(0);
    }
}