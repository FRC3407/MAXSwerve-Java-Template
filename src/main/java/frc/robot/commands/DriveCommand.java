// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.math.MathUtil;
import frc.robot.Constants.OIConstants;

public class DriveCommand extends CommandBase {
  public final DriveSubsystem m_driveSubsystem;
  public final XboxController m_driverController;

  public DriveCommand(DriveSubsystem subsystem, XboxController controller) {
    this.m_driveSubsystem = subsystem;
    this.m_driverController = controller;
    this.addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveSubsystem.drive(
      -MathUtil.applyDeadband(m_driverController.getRightY(), OIConstants.kDriveDeadband),
      -MathUtil.applyDeadband(m_driverController.getRightX(), OIConstants.kDriveDeadband),
      -MathUtil.applyDeadband(m_driverController.getLeftX(), OIConstants.kDriveDeadband),
      true, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
