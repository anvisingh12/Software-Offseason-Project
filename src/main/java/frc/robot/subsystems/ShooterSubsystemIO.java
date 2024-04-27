package frc.robot.subsystems;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterSubsystemIO {
    @AutoLog
    public static class ShooterSubsystemIOInputs {
       
        // all of the inputs: 
        public double shootPosition = 0.0;
        public double shootVelocity = 0.0;
        public double shootAcceleration = 0.0;
        public double shootCurrent = 0.0;
        public double shootVoltage = 0.0;

    }
    // updating all of the inputs
    public default void updateInputs(ShooterSubsystemIOInputs inputs) {}

    // setting shooter voltage
    public default void setVoltage(double volts) {}
  
    // setting shooter velocity
    public default void setVelocity(double rps) {}
  }