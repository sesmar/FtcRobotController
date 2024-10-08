package TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import Common.CalamariRobot;

public class GamePad1  implements IGamePad{
	private static final double fortyFiveRads = -Math.PI/4;
	private static final double cosine45 = Math.cos(fortyFiveRads);
	private static final double sine45 = Math.sin(fortyFiveRads);
	private final CalamariRobot _robot;
	private final Gamepad _gamePad;

	private final Telemetry _telemetry;

	public GamePad1(Gamepad gamePad, CalamariRobot robot, Telemetry telemetry){
		_gamePad = gamePad;
		_robot = robot;
		_telemetry = telemetry;
	}
	public void HandleInput(){
		double x1; //left/right
		double y1; //forward/back
		double x2; //rotated 45 degrees counterclockwise
		double y2; //rotates 45 degrees counterclockwise
		double spin  = _gamePad.right_stick_x;

		if (Math.abs(spin) > 0.1){
			int reduction = 2;

			if (_gamePad.right_bumper){reduction = 1;}

			_robot.driveTrain.setPower(spin/reduction, spin/reduction, -(spin/reduction), -(spin/reduction));

			_telemetry.addData("spin", "%.2f", spin);
		}
		else {
			int reduction = 2;
			if (_gamePad.right_bumper){reduction = 1;}

			x1 = _gamePad.left_stick_x;
			y1 = -_gamePad.left_stick_y;

			x2 = x1 * cosine45 - y1 * sine45;
			y2 = y1 * cosine45 + x1 * sine45;

			_robot.driveTrain.setPower(
				x2/reduction
				, y2/reduction
				, y2/reduction
				, x2/reduction);

			if (_gamePad.right_trigger > 0) {
				_robot.magicRope.Move(-_gamePad.right_trigger);
			}

			if (_gamePad.left_trigger > 0) {
				_robot.magicRope.Move(_gamePad.left_trigger);
			}

			if (_gamePad.right_trigger == 0 && _gamePad.left_trigger == 0)
			{
				_robot.magicRope.Move(0);
			}

			_telemetry.addData("x1", "%.2f", x1);
			_telemetry.addData("y1", "%.2f", y1);
			_telemetry.addData("x2", "%.2f", x2);
			_telemetry.addData("y2", "%.2f", y2);
		}
	}
}
