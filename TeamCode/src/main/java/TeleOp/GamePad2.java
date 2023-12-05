package TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import Common.CalamariRobot;

public class GamePad2 implements IGamePad {
	private final CalamariRobot _robot;
	private final Gamepad _gamePad;

	private final Telemetry _telemetry;

	public GamePad2(Gamepad gamePad, CalamariRobot robot, Telemetry telemetry){
		_gamePad = gamePad;
		_robot = robot;
		_telemetry = telemetry;
	}

	public void HandleInput(){
		_robot.liftArm.Move(_gamePad.right_stick_y);

		_robot.chopChop.Move(_gamePad.left_stick_y);

		_robot.funnelCake.Move(_gamePad.left_stick_x);


		if(_gamePad.y){
			_robot.chopChop.Open();
		}

		if(_gamePad.x){
			_robot.chopChop.Close();
		}

		if (_gamePad.b) {
			_robot.airForceLaunch.Launch();
		}

		if (_gamePad.a){
			_robot.airForceLaunch.Reset();
		}

		if (_gamePad.right_bumper){
			_robot.eggDropper.Drop(2);
		}

		if (_gamePad.left_bumper){
			_robot.eggDropper.Secure(2);
		}

		_telemetry.addData("GamePad2", "Handle Input");
		_telemetry.addData("X", "%b", _gamePad.x);
		_telemetry.addData("Y", "%b", _gamePad.y);
		_telemetry.addData("Funnel:", "%d", _robot.funnelCake.getPosition());
		_telemetry.addData("Arm:", "%d", _robot.liftArm.getPosition());
	}
}
