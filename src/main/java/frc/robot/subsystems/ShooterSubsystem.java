package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.ShooterSubsystem;



public class ShooterSubsystem extends SubsystemBase {
    private SparkMax shooterMotor;
   
    public ShooterSubsystem() {
        shooterMotor = new SparkMax(17, MotorType.kBrushless);
    }

    public void shoot(double speed) {
        shooterMotor.set(1.0);
    }

    /* 
    public void reverse() {
        shooterMotor.set(-0.5);
    }
    */

    public void stop() {
        shooterMotor.set(0);
    }
}
