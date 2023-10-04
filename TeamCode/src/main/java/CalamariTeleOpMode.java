import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Common.CalamariRobot;

@TeleOp(name="Calamari: TeleOpMode", group="Linear OpMode")
public class CalamariTeleOpMode extends LinearOpMode {

	CalamariRobot robot = new CalamariRobot(this);

	@Override
	public void runOpMode() {
		telemetry.addData("Status", "Initialized");
		telemetry.update();
		// Wait for the game to start (driver presses PLAY)
		waitForStart();

		// run until the end of the match (driver presses STOP)
		while (opModeIsActive()) {
			telemetry.addData("Status", "Running");
			telemetry.update();

			//robot.driveRobot();
		}
	}
}