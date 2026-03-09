package frc.robot.subsystems;

import java.nio.channels.Channel;
import java.security.cert.PKIXCertPathValidatorResult;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeOutConstants;

public class IntakeSubsystem extends SubsystemBase {

    
    /**
     * This subsytem that controls the Intake.
     */
    public IntakeSubsystem () {
    
    // Set up the motor as a brushless motor if using brushless
    SparkMax OutMotor = new SparkMax(IntakeOutConstants.IntakeOut_MOTOR_ID, MotorType.kBrushless);


    // Set can timeout. Because this project only sets parameters once on
    // construction, the timeout can be long without blocking robot operation. Code
    // which sets or gets parameters during operation may need a shorter timeout.
    rollerMotor.setCANTimeout(250);
    
    // Create and apply configuration for roller motor. Voltage compensation helps
    // the roller behave the same as the battery
    // voltage dips. The current limit helps prevent breaker trips or burning out
    // the motor in the event the roller stalls.
    SparkMaxConfig rollerConfig = new SparkMaxConfig();
    rollerConfig.voltageCompensation(IntakeOutConstants.IntakeOut_UP);
    rollerConfig.smartCurrentLimit(IntakeOutConstants.IntakeOut_MOTOR_CURRENT_LIMIT);
    rollerConfig.idleMode(IdleMode.kBrake);
    rollerMotor.configure(rollerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    /**
     *  This is a method that makes the roller spin to your desired speed.
     *  Positive values make it spin forward and negative values spin it in reverse.
     * 
     * @param speedmotor speed from -1.0 to 1, with 0 stopping it
     */
    public void runRoller(double speed){
        rollerMotor.set(speed);
    }

}