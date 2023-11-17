package Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Autonomous.Programs.IAutonomousProgram;
import Autonomous.Programs.AutonomousProgramRedF4;
import Autonomous.Programs.AutonomousProgramBlueA4;
import Autonomous.Programs.AutonomousProgramRedF2;
import Autonomous.Programs.AutonomousProgramBlueA2;

import Common.CalamariRobot;

@Autonomous(name="Calamari: Autonomous Drive", group="Calamari", preselectTeleOp = "Calamari: TeleOpMode")
public class CalamariAutonomousOpMode extends LinearOpMode {

    CalamariRobot robot = new CalamariRobot(this);


    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();
        IAutonomousProgram program1 = new AutonomousProgramRedF4(robot);
		IAutonomousProgram program2 = new AutonomousProgramRedF2(robot);

		IAutonomousProgram program3 = new AutonomousProgramBlueA4(robot);
		IAutonomousProgram program4 = new AutonomousProgramBlueA2(robot);

        waitForStart();

        program2.Run();
    }
}
