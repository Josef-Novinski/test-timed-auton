package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Chassis extends SubsystemBase {
  public DifferentialDrive drivey_lad;
  public WPI_TalonFX left_motor;
  public WPI_TalonFX right_motor;
  public Chassis() {
      left_motor = new WPI_TalonFX(Constants.left_motor_ID);
      right_motor = new WPI_TalonFX(Constants.right_motor_ID);
      right_motor.setInverted(true);
      drivey_lad = new DifferentialDrive(left_motor, right_motor);
  }
  public void forward_method (double fwd){
      drivey_lad.arcadeDrive(fwd, 0);
  }
  public void rotation_method (double rot){
      drivey_lad.arcadeDrive(0, rot);
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
/*
class A {
    private int a;
    public void setATo(int nA) {
        a = nA;
    } 
    public void forward (double fwd) {
        robot.forward(fwd);
    }
    public int getA() {
        return a;
    }
    public A(int p_a) {
        a = p_a;
    }
}
A a = new A(0);

a.setATo(1);

println(a.getA());
*/