package Common;

import com.qualcomm.robotcore.hardware.DcMotor;

public class MagicRope {
    private final DcMotor _magicRope;

    public MagicRope (DcMotor magicRope)
    {
        _magicRope = magicRope;
    }

    public void Move(double power){
        _magicRope.setPower(power);
    }
}
