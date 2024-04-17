
package frc.robot.subsystems;

import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
  
    private TalonFX shootermotor1; 

  public ShooterSubsystem() {
    shootermotor1 = new TalonFX(0); 
    // add PID stuff
  }

  // start shooter and set to certain rps 
  public void startShooter(double rps){
    shootermotor1.setControl(new VelocityVoltage(rps)) ;
  }

// stop shooter by setting speed to 0
  public void stopShooter(){
    shootermotor1.setControl(new VoltageOut(0.0)) ;
  }





  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command runShooter() {
    startShooter(50); 
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}

