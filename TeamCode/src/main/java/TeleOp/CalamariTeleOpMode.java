package TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Common.CalamariRobot;

@TeleOp(name="Calamari: TeleOpMode", group="Calamari")
public class CalamariTeleOpMode extends LinearOpMode {
	CalamariRobot robot = new CalamariRobot(this);
	IGamePad gamePad1;
	IGamePad gamePad2;

	@Override
	public void runOpMode() {

		robot.init();
		gamePad1 = new GamePad1(gamepad1, robot, telemetry);
		gamePad2 = new GamePad2(gamepad2, robot, telemetry);

		telemetry.addData("Status", "Initialized");
		telemetry.update();

		// Wait for the game to start (driver presses PLAY)
		waitForStart();

		// run until the end of the match (driver presses STOP)
		while (opModeIsActive()) {
			gamePad1.HandleInput();
			gamePad2.HandleInput();

			telemetry.update();
		}
	}
}