package Common;

import com.qualcomm.robotcore.hardware.DcMotor;

public class FunnelCake {
    private final DcMotor _motorcd;

    public FunnelCake (DcMotor motordc){
        _motorcd = motordc;
    }

    public void Move(double power) {

        _motorcd.setPower(power/3);
    }

    public int getPosition()
    {
        return _motorcd.getCurrentPosition();
    }

    public void AutoCake(String direction){
        _motorcd.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int targetPosition = -88;
        if(direction == "down"){ targetPosition = 88;}
        _motorcd.setTargetPosition(targetPosition);

        _motorcd.setPower(.5);

        _motorcd.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(_motorcd.isBusy()){
            //
        }

        _motorcd.setPower(0);
        _motorcd.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
