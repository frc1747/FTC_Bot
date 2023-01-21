// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Xbox;

public class DriveAndShoot extends CommandBase {
  private Drivetrain drivetrain;
  private Xbox controller;
  private Shooter pew;

  /** Creates a new DriveAndShoot. */
  public DriveAndShoot(Drivetrain drivetrain, Xbox controller, Shooter pew) {
    this.drivetrain = drivetrain;
    this.controller = controller;
    this.pew = pew;
    addRequirements(drivetrain);
    addRequirements(pew);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.setLeftPower((controller.getRightStickY() - controller.getRightStickX()) * 0.5);
    drivetrain.setRightPower((controller.getRightStickY() + controller.getRightStickX()) * 0.5);
    double leftY = controller.getLeftStickY();
    if (leftY <= 0) {
      pew.setPower(leftY);
    } 
    else {
      // pew.setPower(0.0);
      pew.setPower(leftY);
    }
    // drivetrain.setLeftPower((controller.getLeftStickY()) * 0.5);
    // drivetrain.setRightPower((controller.getRightStickY()) * 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.setLeftPower(0.0);
    drivetrain.setRightPower(0.0);
    pew.setPower(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
