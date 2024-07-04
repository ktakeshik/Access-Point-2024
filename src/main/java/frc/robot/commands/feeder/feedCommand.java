package frc.robot.commands.feeder;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.FlywheelSubsystem;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;


public class feedCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final FlywheelSubsystem m_flywheelSubsystem;
  private GenericHID joystick;

  public feedCommand(FlywheelSubsystem m_flywheelSubsystem, GenericHID joystick) {
    this.m_flywheelSubsystem = m_flywheelSubsystem;
    this.joystick = joystick;

    addRequirements(m_flywheelSubsystem);
  }

  @Override
  public void initialize() {
    m_flywheelSubsystem.setFeedSpeed(0.5);
  }

  @Override
  public void end(boolean interrupted) {
    m_flywheelSubsystem.setFeedSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return !joystick.getRawButton(OperatorConstants.kRightBumperPort);
  }
}
