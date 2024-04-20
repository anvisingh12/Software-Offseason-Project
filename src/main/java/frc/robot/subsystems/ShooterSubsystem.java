
package frc.robot.subsystems;

import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  
    private TalonFX shootermotor1; 
    private PIDController pidController_;

  public ShooterSubsystem() {
    shootermotor1 = new TalonFX(0);
    pidController_ = new PIDController(0,0,0,0);
  }


  public void setPID(double kp, double ki, double kd) {
    pidController_.setPID(kp, ki, kd);
  }

  // start shooter and set to certain rps 
  public void startShooter(double rps){
    shootermotor1.setControl(new VelocityVoltage(rps)) ;
  }

// stop shooter by setting voltage out to 0
  public void stopShooter(){
    shootermotor1.setControl(new VoltageOut(0.0)) ;
  }
  
}

