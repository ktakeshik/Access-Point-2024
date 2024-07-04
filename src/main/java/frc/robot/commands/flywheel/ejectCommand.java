package frc.robot.commands.flywheel;

import frc.robot.Constants.FlywheelConstants;
import frc.robot.subsystems.FlywheelSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


public class ejectCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final FlywheelSubsystem m_flywheelSubsystem;

  public ejectCommand(FlywheelSubsystem m_flywheelSubsystem) {
    this.m_flywheelSubsystem = m_flywheelSubsystem;

    addRequirements(m_flywheelSubsystem);
  }

  @Override
  public void initialize() {
    m_flywheelSubsystem.setShootSpeed(FlywheelConstants.kFlywheelEjectSpeed);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
