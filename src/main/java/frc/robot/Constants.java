// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.List;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public final class Constants {
  public static class SwerveModuleConstants {

    public static final int kDriverControllerPort = 0;

    public static final double kRotationGearRatio = 1 / (150 / 7.0);
    public static final double kDriveGearRatio = 1/ 8.14;
    public static final double kWheelDiameter = Units.inchesToMeters(4);

    // Drive Port Constants
    public static final int kLeftFrontWheelPort = 16;
    public static final int kLeftFrontRotationPort = 17;
    public static final int kLeftFrontCANCoderPort = 3;

    public static final int kRightFrontWheelPort = 2;
    public static final int kRightFrontRotationPort = 3;
    public static final int kRightFrontCANCoderPort = 1;

    public static final int kLeftBackWheelPort = 18;
    public static final int kLeftBackRotationPort = 19;
    public static final int kLeftBackCANCoderPort = 2;

    public static final int kRightBackWheelPort = 20;
    public static final int kRightBackRotationPort = 21;
    public static final int kRightBackCANCoderPort = 4;

    public static final double kLeftFrontCANCoderOffset = 4.9;
    public static final double kRightFrontCANCoderOffset = 3.3;
    public static final double kLeftBackCANCoderOffset = 4.25;
    public static final double kRightBackCANCoderOffset = 1.59;
    
    // Reverse Booleans
    public static final boolean kLeftFrontDriveReversed = false;
    public static final boolean kRightFrontDriveReversed = true;
    public static final boolean kLeftBackDriveReversed = false;
    public static final boolean kRightBackDriveReversed = true;

    public static final boolean kLeftFrontRotationReversed = true;
    public static final boolean kRightFrontRotationReversed = true;
    public static final boolean kLeftBackRotationReversed = true;
    public static final boolean kRightBackRotationReversed = true;

    public static final boolean kLeftFrontCANCoderReversed = false;
    public static final boolean kRightFrontCANCoderReversed = false;
    public static final boolean kLeftBackCANCoderReversed = false;
    public static final boolean kRightBackCANCoderReversed = false;

    // Conversion Units
    public static final double kRotationToMeters = kDriveGearRatio * Math.PI * kWheelDiameter;
    public static final double kRotationToRadians = kRotationGearRatio * 2 * Math.PI;

    // Measurement Units
    public static final double kMetersPerSecond = kRotationToMeters / 60.0 ;
    public static final double kRadiansPerSecond = kRotationToRadians / 60.0;

    // PID Constants
    public static final double kTurningP = 0.4;
    public static final double kTurningI = 0;
    public static final double kTurningD = 0;

    // The distances between each Module from the center of the robot (Meters)
    public static final double kModuleDistance = 0.312;

    // 2d translation coordinates relative to center 
    public static final double kLeftFront2dX = kModuleDistance;
    public static final double kLeftFront2dY = kModuleDistance;

    public static final double kRightFront2dX = kModuleDistance;
    public static final double kRightFront2dY = -kModuleDistance;

    public static final double kLeftBack2dX = -kModuleDistance;
    public static final double kLeftBack2dY = kModuleDistance;

    public static final double kRightBack2dX = -kModuleDistance;
    public static final double kRightBack2dY = -kModuleDistance;

    public static final Translation2d leftFrontLocation = new Translation2d(
      SwerveModuleConstants.kLeftFront2dX, 
      SwerveModuleConstants.kLeftFront2dY
    );

    public static final Translation2d rightFrontLocation = new Translation2d(
      SwerveModuleConstants.kRightFront2dX,
      SwerveModuleConstants.kRightFront2dY
    );

    public static final Translation2d leftBackLocation = new Translation2d(
      SwerveModuleConstants.kLeftBack2dX,
      SwerveModuleConstants.kLeftBack2dY
    );

    public static final Translation2d rightBackLocation = new Translation2d(
      SwerveModuleConstants.kRightBack2dX,
      SwerveModuleConstants.kRightBack2dY
    );

    public static final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
      leftFrontLocation, 
      rightFrontLocation,
      leftBackLocation,
      rightBackLocation
    );
  }

  public static class DriveConstants {
    // Drive Speed Constants
    public static final double kDriveMaxMetersPerSecond = 4.95;
    public static final double kRotationMaxRadiansPerSecond = 2 * Math.PI;
    public static final double kDriveMetersPerSecondLimit = 2; //4.5;

    public static final double kTeleDriveMaxAcceleration = kDriveMaxMetersPerSecond * 8;
    public static final double kTeleRotationMaxAngularAcceleration = kRotationMaxRadiansPerSecond * 8;

  }

  public static class AutoConstants {
    //auto constraints 
    public static final double kAutoDriveMaxMetersPerSecond = 0.5;
    public static final double kAutoDriveMaxAcceleration = kAutoDriveMaxMetersPerSecond;
    public static final double kAutoDriveMaxRadiansPerSecond = 2;
    public static final double kAutoDriveMaxAngularAcceleration = kAutoDriveMaxRadiansPerSecond;

    //path planner constraint 
    // public static final PathConstraints pathConstraints = new PathConstraints(
    //   kAutoDriveMaxMetersPerSecond, 
    //   kAutoDriveMaxAcceleration, 
    //   kAutoDriveMaxRadiansPerSecond, 
    //   kAutoDriveMaxAngularAcceleration
    // );

    //PID Constants
    public static final double kPController = 0.1;
    public static final double kIController = 0;
    public static final double kDController = 0.0;

    public static final double kPThetaController = 0.4;
    public static final double kIThetaController = 0;
    public static final double kDThetaController = 0;

    public final static List<Translation2d> figureEightPath = List.of(
      //first point (-0.25, 0.5)
      new Translation2d(-0.25, 0.5),
      //second point (-0.5, 0)
      new Translation2d(-0.5, 0),
      //third point (-0.25, -0.5)
      new Translation2d(-0.25, -0.5),
      //fourth point (0, 0)
      new Translation2d(0, 0),
      //fifth point (0.25, 0.5)
      new Translation2d(0.25, 0.5),
      //sixth point (0.5, 0)
      new Translation2d(0.5, 0),
      //seventh point (0.25, -0.5)
      new Translation2d(0.25, -0.5)
    );

    public final static List<Translation2d> straightLineTest = List.of(
      new Translation2d(0.5, 0)
    );

    //max module speed
    public static final double kMaxModuleSpeed = 4.5;

    //Path planner config
    // public static final HolonomicPathFollowerConfig pathFollowingConfig = new HolonomicPathFollowerConfig(
    //   new PIDConstants(kPController, kIController, kDController),
    //   new PIDConstants(kPThetaController, kIThetaController, kDThetaController),
    //   kMaxModuleSpeed, 
    //   SwerveModuleConstants.leftFrontLocation.getNorm(),
    //   new ReplanningConfig()
    // );

  }

  
  public static class LEDConstants {
    public static final int CANdleID = 4;
    public static final int LEDcount = 22; //69
  }


  public final static class FlywheelConstants {
    public final static int kFeedFlywheelID = 6;
    public final static int kShootFlywheelID = 11;

    public final static boolean kFeedFlywheelReversed = false;
    public final static boolean kShootFlywheelReversed = true;

    public final static double kFlywheelMAXSpeed = 6000;
    public final static double kFlywheelShootSpeed = 50;
    public final static double kFlywheelEjectSpeed = 25;

    public final static double kFlywheelFeedSpeed = 0.15;
  }

  public static class OperatorConstants {
    public static final int kPrimaryGamepadPort = 0;

    // Gamepad Axis Ports
    public static final int kleftXJoystickPort = 0;
    public static final int kLeftYJoystickPort = 1;
    public static final int kRightXJoystickPort = 4;
    public static final int kRightYJoystickPort = 5; 
    public final static int kLeftTriggerPort = 2;
    public final static int kRightTriggerPort = 3;

    // Gamepad Button Ports
    public final static int kAButtonPort = 1;
    public final static int kBButtonPort = 2;
    public final static int kXButtonPort = 3;
    public final static int kYButtonPort = 4;
    public final static int kLeftBumperPort = 5;
    public final static int kRightBumperPort = 6;
    public final static int kBackButtonPort = 7;
    public final static int kStartButtonPort = 8;   

    //joystick port for the gamepad
    public final static int kPrimaryLeftStickPort = 0;
    public final static int kPrimaryRightStickPort = 1;
    public final static int kSecondaryPort = 1;

    //Dpad values
    public final static int kDpadUp = 0;
    public final static int kDpadDown = 180;

    //Attack3 button ports
    public final static int kAttackTriggerPort = 1;
    public final static int kAttackButtonTwo = 2;

    //Attack3
    public final static int kAttackYAxisPort = 1;

    //joystick deadzones
    public final static double kDeadzone = 0.1;
    public static final double kDeadband = 0.07;
  }
}
