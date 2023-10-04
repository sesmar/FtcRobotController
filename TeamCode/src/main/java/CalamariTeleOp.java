import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Common.CalamariRobot;

@TeleOp
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

			robot.driveRobot();
		}
	}
}