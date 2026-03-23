package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;



public class TransitionSubsystem extends SubsystemBase {
    private SparkMax transitionMotor = new SparkMax (3, MotorType.kBrushless);

    public void forward(double speed) {
        transitionMotor.set(speed);
    }   

    /*
    public void reverse() {
        transitionMotor.set(-0.5);
    }   
    */ 

    public void forwardstop() {
        transitionMotor.set(0);
    }   
}
