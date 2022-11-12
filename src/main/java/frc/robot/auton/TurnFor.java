package frc.robot.auton;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TurnFor extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Chassis m_chassis;
  // Upper case for assignment variables
  double Time_rot;
  double Speed_rot;
  Timer stopwatch;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TurnFor(Chassis chassis, double time_rot ,double speed_rot) {
    stopwatch = new Timer();
    Time_rot = time_rot;
    Speed_rot = speed_rot;
    m_chassis = chassis;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      stopwatch.reset();
      stopwatch.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      m_chassis.rotation_method(Speed_rot);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      m_chassis.rotation_method(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return stopwatch.hasElapsed(Time_rot);
  }
}