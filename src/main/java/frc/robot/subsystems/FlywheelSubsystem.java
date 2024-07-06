package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlywheelConstants;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.controls.VelocityVoltage;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FlywheelSubsystem extends SubsystemBase {
    private final TalonFX feedFlywheel;
    private final TalonFX shootFlywheel;
    private final VelocityVoltage shootFlywheelVelocity = new VelocityVoltage(0);
    
    public FlywheelSubsystem() {
        feedFlywheel = new TalonFX(FlywheelConstants.kFeedFlywheelID);
        shootFlywheel = new TalonFX(FlywheelConstants.kShootFlywheelID);

        TalonFXConfiguration FeedConfig = new TalonFXConfiguration();

        TalonFXConfiguration ShootConfig = new TalonFXConfiguration();
        ShootConfig.Slot0.kS = 0.1; // Add 0.1 V output to overcome static friction
        ShootConfig.Slot0.kV = 0.22; // A velocity target of 1 rps results in 0.12 V output
        ShootConfig.Slot0.kP = 1.01; // An error of 1 rps results in 0.11 V output
        ShootConfig.Slot0.kI = 0.2; // no output for integrated error
        ShootConfig.Slot0.kD = 0; // no output for error derivative

        feedFlywheel.getConfigurator().apply(FeedConfig);
        shootFlywheel.getConfigurator().apply(ShootConfig);
    }

    public double getFeedFlywheelSpeed() {
        return feedFlywheel.getVelocity().getValueAsDouble();
    }

    public double getShootFlywheelSpeed() {
        return shootFlywheel.getVelocity().getValueAsDouble();
    }

    public void setFeedSpeed(double percentPower) {
        feedFlywheel.set(percentPower);
    }

    public void setShootSpeed(double speed) {
        shootFlywheel.setControl(shootFlywheelVelocity.withVelocity(speed));
    }

    public void stopShootFlywheel() {
        shootFlywheel.setControl(new NeutralOut());
    }

    public void brakeShootFlywheel() {
        shootFlywheel.setControl(shootFlywheelVelocity.withVelocity(0));
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("DV", shootFlywheelVelocity.Velocity);
        SmartDashboard.putNumber("CV", getShootFlywheelSpeed());
    }
}       
