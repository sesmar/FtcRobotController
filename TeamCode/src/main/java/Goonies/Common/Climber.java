package Goonies.Common;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Climber {
    public final DcMotor _climberRightMotor;
    public final DcMotor _climberLeftMotor;

    public Climber (DcMotor climberRightMotor, DcMotor climberLeftMotor){
        _climberRightMotor = climberRightMotor;
        _climberLeftMotor = climberLeftMotor;
    }

    public void  poweroffrendship (double power){
        _climberRightMotor.setPower(power);
        _climberLeftMotor.setPower(-power);
    }
}
//If sense aura then sigma