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
}
