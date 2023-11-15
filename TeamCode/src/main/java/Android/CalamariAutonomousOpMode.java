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

        robot.driveTrain.driveForInches(24, .75);
        robot.driveTrain.turn(90, -.25);
        robot.funnelCake.AutoCake("down");
        robot.driveTrain.driveForInches(22, .75);

        robot.liftArm.AutoArm("down");
        robot.liftArm.AutoArm("up");
        robot.funnelCake.AutoCake("up");

        robot.driveTrain.turn(90, .25);
        robot.driveTrain.driveForInches(23, -.75);
        robot.driveTrain.turn(90, .25);
        robot.driveTrain.driveForInches(21, -.75);
    }
}
