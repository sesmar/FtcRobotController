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

		if(_gamePad.b){
			_robot.driveTrain.driveForInches(9, 1);
		}

		if(_gamePad.y){
			_robot.driveTrain.turn(9, 1);
		}

		if(_gamePad.x){
			_robot.driveTrain.turn(9, -1);
		}
	}
}
