package Common;

import com.qualcomm.robotcore.hardware.Servo;

public class CoinFlipper {
	Servo _flipper;
	public CoinFlipper(Servo flipper){
		_flipper = flipper;
	}

	public void Secure(){
		_flipper.setPosition(.7);
	}
	public void Drop(){
		_flipper.setPosition(0);
	}
}
