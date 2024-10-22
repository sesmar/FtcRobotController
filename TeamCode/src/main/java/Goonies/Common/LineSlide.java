package Goonies.Common;

import com.qualcomm.robotcore.hardware.DcMotor;

public class LineSlide {
    private final DcMotor _motorcycle;

     public LineSlide(DcMotor motorcycle){
         _motorcycle = motorcycle;

     }

     public void Movercycle(double power){
         _motorcycle.setPower(-power);
     }
}
