// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj. GenericHID;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.IntakeLiftSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TransitionSubsystem;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import java.util.List;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
   
    // Operators Controllers (we are using the F310, but you can use any other controller if you prefer)
    private final CommandXboxController m_operatorController = new CommandXboxController(1);

  // The robot's subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final IntakeLiftSubsystem m_intakeLiftSubsystem = new IntakeLiftSubsystem();
  private final TransitionSubsystem m_TransitionSubsystem = new TransitionSubsystem();

  // The driver's controller
   GenericHID m_driverController = new  GenericHID(OIConstants.kDriverControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    m_robotDrive.setDefaultCommand(
        // The left stick controls translation of the robot.
        // Turning is controlled by the X axis of the right stick.
        new RunCommand(
            () -> m_robotDrive.drive(
                -MathUtil.applyDeadband(m_driverController.getRawAxis(1), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getRawAxis(0), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getRawAxis(4), OIConstants.kDriveDeadband),
                true),
            m_robotDrive));

            //SmartDashboard.putData(m_chooser);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
   * subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link GenericHID}), and then calling
   * passing it to a
   * {@link JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(m_driverController, 6)
        .whileTrue(new RunCommand(
            () -> m_robotDrive.setX(),
            m_robotDrive));

    new JoystickButton(m_driverController, 8)
        .onTrue(new InstantCommand(
            () -> m_robotDrive.zeroHeading(),
            m_robotDrive));
        
        // Shooter
        m_operatorController.rightBumper().whileTrue(new RunCommand(
            () -> m_shooterSubsystem.shoot(0.5), m_shooterSubsystem));

        m_operatorController.rightTrigger().whileTrue(new RunCommand(
            () -> m_shooterSubsystem.stop(), m_shooterSubsystem));

        // Transition
        m_operatorController.x().whileTrue(new RunCommand(
            () -> m_TransitionSubsystem.forward(0.5), m_TransitionSubsystem));   

        m_operatorController.x().whileFalse(new RunCommand(
            () -> m_TransitionSubsystem.forwardstop(), m_TransitionSubsystem));   

        // Intake
        m_operatorController.leftBumper().whileTrue(new RunCommand(
           () -> m_intakeSubsystem.runIntake(0.5), m_intakeSubsystem));

        m_operatorController.leftTrigger().whileTrue(new RunCommand(
            () -> m_intakeSubsystem.stopIntake(), m_intakeSubsystem));

       // IntakeLift Up
        m_operatorController.y().whileTrue(new RunCommand(
            () -> m_intakeLiftSubsystem.runArmUp(0.5), m_intakeLiftSubsystem));
    
        m_operatorController.y().whileFalse(new RunCommand(
            () -> m_intakeLiftSubsystem.stopArmUp(), m_intakeLiftSubsystem));

        // IntakeLift Down
        m_operatorController.a().whileTrue(new RunCommand(
            () -> m_intakeLiftSubsystem.runArmDown(0.5), m_intakeLiftSubsystem));

        m_operatorController.a().whileFalse(new RunCommand(
            () -> m_intakeLiftSubsystem.stopArmDown(), m_intakeLiftSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Create config for trajectory
    TrajectoryConfig config = new TrajectoryConfig(
        AutoConstants.kMaxSpeedMetersPerSecond,
        AutoConstants.kMaxAccelerationMetersPerSecondSquared)
        // Add kinematics to ensure max speed is actually obeyed
        .setKinematics(DriveConstants.kDriveKinematics);

    // An example trajectory to follow. All units in meters.
    Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(0, 0, new Rotation2d(0)),
        // Pass through these two interior waypoints, making an 's' curve path
        List.of(new Translation2d(1, 1), new Translation2d(2, -1)),
        // End 3 meters straight ahead of where we started, facing forward
        new Pose2d(3, 0, new Rotation2d(0)),
        config);

    var thetaController = new ProfiledPIDController(
        AutoConstants.kPThetaController, 0, 0, AutoConstants.kThetaControllerConstraints);
    thetaController.enableContinuousInput(-Math.PI, Math.PI);

    SwerveControllerCommand swerveControllerCommand = new SwerveControllerCommand(
        exampleTrajectory,
        m_robotDrive::getPose, // Functional interface to feed supplier
        DriveConstants.kDriveKinematics,

        // Position controllers
        new PIDController(AutoConstants.kPXController, 0, 0),
        new PIDController(AutoConstants.kPYController, 0, 0),
        thetaController,
        m_robotDrive::setModuleStates,
        m_robotDrive);

    // Reset odometry to the starting pose of the trajectory.
    m_robotDrive.resetOdometry(exampleTrajectory.getInitialPose());

    // Run path following command, then stop at the end.
    return swerveControllerCommand.andThen(() -> m_robotDrive.drive(0, 0, 0, true)); 
    }

    /* 
return new AutoShootCommand(shooter, transition);
}

@Override
public void autonomousInit() {
autonomousCommand = robotContainer.getAutonomousCommand();

if (autonomousCommand != null) {
autonomousCommand.schedule();
}
}

@Override
public void teleopInit() {
if (autonomousCommand != null) {
autonomousCommand.cancel();
}

  }
*/
}