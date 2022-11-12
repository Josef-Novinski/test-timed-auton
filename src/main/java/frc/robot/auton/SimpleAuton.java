package frc.robot.auton;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
public class SimpleAuton extends SequentialCommandGroup{
    Chassis m_chassis;
    double speed1 = 0.4;
    double time1 = 2;
    double time2 = 17;
    double rot_speed2 = 0.5;
    public SimpleAuton(Chassis chassis) {
       m_chassis = chassis;

       addRequirements(m_chassis);
       addCommands(new ForwardFor(m_chassis, time1, speed1),new TurnFor(m_chassis, time2, rot_speed2));
    }
}