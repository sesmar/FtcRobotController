package Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Common.CalamariRobot;

@Autonomous(name="Calamari: Autonomous Drive", group="Calamari")
public class CalamariAutonomousOpMode extends LinearOpMode {

    CalamariRobot robot = new CalamariRobot(this);


    @Override
    public void runOpMode() {
        robot.init();
        IAutonomousProgram program = new AutonomousProgramRedA4(robot);
        waitForStart();

        program.Run();
    }
}
