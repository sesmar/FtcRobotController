package Android;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Common.CalamariRobot;

@Autonomous(name="Calamari: Auto Drive Test", group="Calamari")
public class CalamariAutonomousOpMode extends LinearOpMode {

    CalamariRobot robot = new CalamariRobot(this);


    @Override
    public void runOpMode() {
        robot.init();

        waitForStart();
        // run until the end of the match (driver presses STOP)

        for (int i = 0; i < 4; i++) {
            robot.driveTrain.driveForInches(18, .75);
            robot.driveTrain.turn(90, .25);
        }
    }
}
