package frc.robot.commands.flywheel;

import frc.robot.Constants.FlywheelConstants;
import frc.robot.subsystems.FlywheelSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


public class scoringSpeedCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final FlywheelSubsystem m_flywheelSubsystem;

  public scoringSpeedCommand(FlywheelSubsystem m_flywheelSubsystem) {
    this.m_flywheelSubsystem = m_flywheelSubsystem;

    addRequirements(m_flywheelSubsystem);
  }

  @Override
  public void initialize() {
    m_flywheelSubsystem.setShootSpeed(FlywheelConstants.kFlywheelShootSpeed);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
