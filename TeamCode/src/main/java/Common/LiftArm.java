package Common;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LiftArm {
	private final DcMotor _lift;

	private final TouchSensor _tsDown;
	private final TouchSensor _tsUp;

	private final Telemetry _telemetry;

	public LiftArm(DcMotor lift, TouchSensor tsDown, TouchSensor tsUp, Telemetry telemetry){
		_lift = lift;
		_tsDown = tsDown;
		_tsUp = tsUp;
		_telemetry = telemetry;
	}

	public void stop(){
		_lift.setPower(0);
	}

	public void Move(double power){
		if((power>0 && !_tsDown.isPressed())
				|| power==0
				|| (power<0 && !_tsUp.isPressed())) {
			_lift.setPower(power);
		}
		else{
			_lift.setPower(0);
		}
	}

	public int getPosition(){
		return _lift.getCurrentPosition();
	}

	public void AutoArm(String direction){
		_lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

		int targetPosition = -15000;
		if(direction == "down"){
			targetPosition = -targetPosition;
		}else {
			targetPosition = (targetPosition/2);
		}

		_lift.setTargetPosition(targetPosition);

		_lift.setPower(1);

		_lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

		while(_lift.isBusy()){
			//
		}

		_lift.setPower(0);
		_lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
	}
}
