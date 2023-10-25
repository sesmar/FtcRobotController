package Common;

import com.qualcomm.robotcore.hardware.DcMotor;

public class FunnelCake {
    private final DcMotor _motorcd;

    public FunnelCake (DcMotor motordc){
        _motorcd = motordc;
    }

    public void Move(double power) {

        _motorcd.setPower(power/10);
    }
}
