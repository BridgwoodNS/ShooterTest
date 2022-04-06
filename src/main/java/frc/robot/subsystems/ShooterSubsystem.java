// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.misc.Constants;

public class ShooterSubsystem extends SubsystemBase {

  private final WPI_TalonFX bottom = new WPI_TalonFX(7);
  private final WPI_TalonFX top = new WPI_TalonFX(8);

  public int targetTopVelocity = 2000;
  public int targetBottomVelocity = 2000;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {

    bottom.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor,0, 10); //Read more into timeout Param
    top.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 10);

    bottom.setInverted(false);
    top.setInverted(true);
    bottom.setSensorPhase(false);
    top.setSensorPhase(false);

    SmartDashboard.putNumber("Top Velocity", 0);
    SmartDashboard.putNumber("Bottom Velocity", 0);

  }

  public void motorsOn(){
    
    bottom.set(ControlMode.Velocity, SmartDashboard.getNumber("Top Velocity", 0));
    top.set(ControlMode.Velocity, SmartDashboard.getNumber("Bottom Velocity", 0));

    bottom.config_kF(0, SmartDashboard.getNumber("Bottom kF", 0.0451));
    bottom.config_kP(0, SmartDashboard.getNumber("Bottom kP", 0.010005));
    bottom.config_kI(0, SmartDashboard.getNumber("Botttom kI", 0.0000009536743));
    bottom.config_kD(0, SmartDashboard.getNumber("Bottom kD", 0.000006));
    
    top.config_kF(0, SmartDashboard.getNumber("Top kF", 0.0451));
    top.config_kP(0, SmartDashboard.getNumber("Top kP", 0.010005));
    top.config_kI(0, SmartDashboard.getNumber("Top kI", 0.0000009536743));
    top.config_kD(0, SmartDashboard.getNumber("Top kD", 0.000006));

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Recorded Top Velocity", top.getSelectedSensorVelocity());
    SmartDashboard.putNumber("Recorded Bottom Velocity", bottom.getSelectedSensorVelocity());
  }
}
