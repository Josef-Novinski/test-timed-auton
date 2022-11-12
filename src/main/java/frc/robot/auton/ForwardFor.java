package frc.robot.auton;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ForwardFor extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Chassis m_chassis;
  // Upper case for assignment variables
  double Time_fwd;
  double Speed_fwd;
  Timer stopwatch;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ForwardFor(Chassis chassis, double time_fwd ,double speed_fwd) {
    stopwatch = new Timer();
    Time_fwd = time_fwd;
    Speed_fwd = speed_fwd;
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
      m_chassis.forward_method(Speed_fwd);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      m_chassis.forward_method(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return stopwatch.hasElapsed(Time_fwd);
  }
}

