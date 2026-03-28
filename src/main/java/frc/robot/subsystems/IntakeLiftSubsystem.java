package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeLiftConstants;
import frc.robot.subsystems.IntakeLiftSubsystem;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

public class IntakeLiftSubsystem extends SubsystemBase {
    private SparkMax liftMotor = new SparkMax(2, MotorType.kBrushless);
    

   public IntakeLiftSubsystem() {


      // Set can timeout. Because this project only sets parameters once on
    // construction, the timeout can be long without blocking robot operation. Code
    // which sets or gets parameters during operation may need a shorter timeout.
    liftMotor.setCANTimeout(250);

    // Create and apply configuration for lift motor. Voltage compensation helps
    // the lift behave the same as the battery
    // voltage dips. The current limit helps prevent breaker trips or burning out
    // the motor in the event the arm stalls.
    SparkMaxConfig liftConfig = new SparkMaxConfig();
    liftConfig.voltageCompensation(10);
    liftConfig.smartCurrentLimit(IntakeLiftConstants.INTAKE_LIFT_MOTOR_CURRENT_LIMIT);
    liftConfig.idleMode(IdleMode.kBrake);
    liftMotor.configure(liftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    @Override
    public void periodic() {
    }
    /** 
     * This is a method that makes the arm move at your desired speed
     *  Positive values make it spin forward and negative values spin it in reverse
     * 
     * @param speed motor speed from -1.0 to 1, with 0 stopping it
     */
    public void runArmUp(double speed){
        liftMotor.set(speed);
    }
    
    public void stopArmUp() {
        liftMotor.set(0);
    }

    public void runArmDown(double speed){
        liftMotor.set(speed);
    }

    public void stopArmDown(){
        liftMotor.set(0);
    }
}