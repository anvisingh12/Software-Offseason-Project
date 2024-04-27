package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

public class ShooterSubsystemIO_HW implements ShooterSubsystemIO {    
    private TalonFX motor_; 

    // actual updateInputs function; updates all of the inputs from ShooterSubsystemIO 
    @Override
    public void updateInputs(ShooterSubsystemIOInputs inputs) {
        inputs.shootPosition = motor_.getPosition().getValueAsDouble(); 
        inputs.shootVelocity = motor_.getVelocity().getValueAsDouble(); 
        inputs.shootCurrent = motor_.getSupplyCurrent().getValueAsDouble(); 
        inputs.shootVoltage = motor_.getMotorVoltage().getValueAsDouble(); 
        inputs.shootAcceleration = motor_.getAcceleration().getValueAsDouble(); 

  }

}
