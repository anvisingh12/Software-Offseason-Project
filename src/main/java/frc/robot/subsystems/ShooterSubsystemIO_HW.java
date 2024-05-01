package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

public class ShooterSubsystemIO_HW implements ShooterSubsystemIO {    
    private TalonFX shootermotor1_; 

    public ShooterSubsystemIO_HW() {
    shootermotor1_ = new TalonFX(3);
    
    var slot0Configs = new Slot0Configs();
    slot0Configs.kS = 0.05; // Add 0.05 V output to overcome static friction
    slot0Configs.kV = 0.12; // A velocity target of 1 rps results in 0.12 V output
    slot0Configs.kP = 0.11; // An error of 1 rps results in 0.11 V output
    slot0Configs.kI = 0; // no output for integrated error
    slot0Configs.kD = 0; // no output for error derivative

    shootermotor1_.getConfigurator().apply(slot0Configs);
  }

    // actual updateInputs function; updates all of the inputs from ShooterSubsystemIO 
    @Override
    public void updateInputs(ShooterSubsystemIOInputs inputs) {
        inputs.shootPosition = shootermotor1_.getPosition().getValueAsDouble(); 
        inputs.shootVelocity = shootermotor1_.getVelocity().getValueAsDouble(); 
        inputs.shootCurrent = shootermotor1_.getSupplyCurrent().getValueAsDouble(); 
        inputs.shootVoltage = shootermotor1_.getMotorVoltage().getValueAsDouble(); 
        inputs.shootAcceleration = shootermotor1_.getAcceleration().getValueAsDouble(); 
  }
  
    @Override
     // start shooter and set to certain rps 
      public void startShooter(double rps){
        shootermotor1_.setControl(new VelocityVoltage(rps)) ;
  }

    @Override
     // stop shooter by setting voltage out to 0
      public void stopShooter(){
        shootermotor1_.setControl(new VoltageOut(0.0)) ;
  }

}
