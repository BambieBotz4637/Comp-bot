/* 
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Commands;

import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TransitionSubsystem;

public class AutoShootCommand extends SequentialCommandGroup {

   public AutoShootCommand(ShooterSubsystem shooter, TransitionSubsystem transition) {

       addCommands(

           // Spin up shooter
           Commands.run(() -> shooter.forward(), shooter)
               .withTimeout(2.0),

           // Feed game piece
           Commands.run(() -> transition.forward(), transition)
               .withTimeout(2.0),

           // Stop everything
           Commands.runOnce(() -> {
               shooter.stop();
               transition.stop();
           })
       );
   }
}
*/