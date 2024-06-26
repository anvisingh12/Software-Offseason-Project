
package frc.robot.subsystems;

import org.littletonrobotics.junction.Logger;

// import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  
    // private TalonFX shootermotor1; 
    private final ShooterSubsystemIO io; 
    private final ShooterSubsystemIOInputsAutoLogged inputs = new ShooterSubsystemIOInputsAutoLogged();

 /** Creates a new Shooter. */
    public ShooterSubsystem(ShooterSubsystemIO io) {
      this.io = io;
  }

  // start shooter and set to certain rps 
  public void startShooter(double rps) {
     io.startShooter(rps); 
  }

// stop shooter by setting voltage out to 0
   public void stopShooter() {
      io.stopShooter() ;
  }
  
  @Override
  public void periodic() {
      io.updateInputs(inputs);
      Logger.processInputs("ShooterSubsystem", inputs);
}
}

