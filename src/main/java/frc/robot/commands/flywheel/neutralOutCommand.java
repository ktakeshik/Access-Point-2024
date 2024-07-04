package frc.robot.commands.flywheel;

import frc.robot.subsystems.FlywheelSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


public class neutralOutCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final FlywheelSubsystem m_flywheelSubsystem;

  public neutralOutCommand(FlywheelSubsystem m_flywheelSubsystem) {
    this.m_flywheelSubsystem = m_flywheelSubsystem;

    addRequirements(m_flywheelSubsystem);
  }

  @Override
  public void initialize() {
    m_flywheelSubsystem.stopShootFlywheel();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
