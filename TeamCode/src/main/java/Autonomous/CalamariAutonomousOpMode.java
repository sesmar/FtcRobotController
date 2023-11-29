package Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.PtzControl;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;

import Autonomous.Programs.AutonomousProgramInitialize;
import Autonomous.Programs.IAutonomousProgram;
import Autonomous.Programs.AutonomousProgramRedF4;
import Autonomous.Programs.AutonomousProgramBlueA4;
import Autonomous.Programs.AutonomousProgramRedF2;
import Autonomous.Programs.AutonomousProgramBlueA2;

import Common.CalamariRobot;

@Autonomous(name="Calamari: Autonomous Drive", group="Calamari", preselectTeleOp = "Calamari: TeleOpMode")
public class CalamariAutonomousOpMode extends LinearOpMode {

    private static final boolean USE_WEBCAM = true;  // true for webcam, false for phone camera

    /**
     * The variable to store our instance of the AprilTag processor.
     */
    private TfodProcessor tfod;

    /**
     * The variable to store our instance of the vision portal.
     */
    private VisionPortal visionPortal;

    CalamariRobot robot = new CalamariRobot(this);


    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();
        IAutonomousProgram program1 = new AutonomousProgramRedF4(robot);
		IAutonomousProgram program2 = new AutonomousProgramRedF2(robot);

		IAutonomousProgram program3 = new AutonomousProgramBlueA4(robot);
		IAutonomousProgram program4 = new AutonomousProgramBlueA2(robot);

        IAutonomousProgram program5 = new AutonomousProgramInitialize(robot);

        tfod = TfodProcessor.easyCreateWithDefaults();

        // Create the vision portal the easy way.
        if (USE_WEBCAM) {
            visionPortal = VisionPortal.easyCreateWithDefaults(
                    hardwareMap.get(WebcamName.class, "ItHasEYES"), tfod);
        } else {
            visionPortal = VisionPortal.easyCreateWithDefaults(
                    BuiltinCameraDirection.FRONT, tfod);
        }

        //PtzControl zoomControl = visionPortal.getCameraControl(PtzControl.class);
        //zoomControl.setZoom(zoomControl.getMinZoom());

        waitForStart();

        //program4.Run();
        //robot.driveTrain.driveSidewaysForInches(12, .50);

        visionPortal.close();
    }

}
