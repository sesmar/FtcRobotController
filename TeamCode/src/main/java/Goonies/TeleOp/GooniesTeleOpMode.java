package Goonies.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Goonies.Common.IRobot;
import Goonies.Common.GooniesRobot;

@TeleOp(name="Goonies: TeleOpMode", group="Goonies")
public class GooniesTeleOpMode extends LinearOpMode {
	GooniesRobot _robot;
	IGamePad _gamePad1;
	IGamePad _gamePad2;

	@Override
	public void runOpMode() {
		_robot = new GooniesRobot();
		_gamePad1 = new GamePad1(this.gamepad1, _robot);
		_gamePad2 = new GamePad2(this.gamepad2 ,_robot);

		if (_robot != null) {
			_robot.Initialize(this.hardwareMap);
		}else {
			telemetry.addData("Robot", "Robot was not Instantiated");
			telemetry.update();
		}

		telemetry.addData("Status", "Operator Controlled Initialized");
		telemetry.update();

		// Wait for the game to start (driver presses PLAY)
		waitForStart();

		if ((_gamePad1 != null || _gamePad2 != null)) {
			// run until the end of the match (driver presses STOP)
			while (opModeIsActive()) {
				if (_gamePad1 != null) {
					_gamePad1.HandleInput();
				}

				if (_gamePad2 != null) {
					_gamePad2.HandleInput();
				}

				telemetry.update();
			}
		} else {
			telemetry.addData("GamePads", "No GamePads Instantiated");
			telemetry.update();
		}
	}
}