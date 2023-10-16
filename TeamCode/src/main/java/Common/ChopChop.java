package Common;

import com.qualcomm.robotcore.hardware.DcMotor;

public class ChopChop {
    private final DcMotor _motorcd;

    public ChopChop (DcMotor motorcd){
        _motorcd = motorcd;
    }

    public void Move(double power) {

        _motorcd.setPower(power);
    }
}
