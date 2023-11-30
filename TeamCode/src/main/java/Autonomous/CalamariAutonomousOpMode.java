package Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.PtzControl;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;

import Autonomous.Programs.AutonomousProgramBlue;
import Autonomous.Programs.AutonomousProgramInitialize;
import Autonomous.Programs.AutonomousProgramRed;
import Autonomous.Programs.IAutonomousProgram;
import Autonomous.Programs.AutonomousProgramRedF4;
import Autonomous.Programs.AutonomousProgramBlueA4;
import Autonomous.Programs.AutonomousProgramRedF2;
import Autonomous.Programs.AutonomousProgramBlueA2;

import Autonomous.Vision.StartingPositionProcessor;
import Common.AllianceColor;
import Common.CalamariRobot;
import Common.SpikeMarkPosition;
import Common.StartingBlock;

@Autonomous(name="Calamari: Autonomous Drive", group="Calamari", preselectTeleOp = "Calamari: TeleOpMode")
public class CalamariAutonomousOpMode extends LinearOpMode {
    CalamariRobot robot = new CalamariRobot(this);


    @Override
    public void runOpMode() throws InterruptedException {
		robot.hasVision = true;
        robot.init();
		StartingBlock startingBlock = StartingBlock.A2;

		IAutonomousProgram program = new AutonomousProgramInitialize(robot);

        waitForStart();

		if (robot.myEyes.getSpikeMark() == SpikeMarkPosition.NONE
			|| robot.myEyes.getAlliance() == AllianceColor.NONE
			|| startingBlock == StartingBlock.NONE)
		{
			program = new AutonomousProgramInitialize(robot);
		}

		if (robot.myEyes.getAlliance() == AllianceColor.RED){
			program = new AutonomousProgramRed(robot, startingBlock);
		}else if (robot.myEyes.getAlliance() == AllianceColor.BLUE){
			program = new AutonomousProgramBlue(robot, startingBlock);
		}

		program.Run();
		robot.myEyes.close();
    }
}
