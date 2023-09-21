// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class AddFiveDrivetrain extends CommandBase {
  /** Creates a new AddFiveDrivetrain. */
  public AddFiveDrivetrain() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (Constants.drivetrainSpeed < 1) {
        Constants.drivetrainSpeed += 0.05;
        System.out.println("Drivetrain Speed: " + Constants.drivetrainSpeed);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
