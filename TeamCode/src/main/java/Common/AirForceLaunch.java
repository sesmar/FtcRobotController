package Common;

import com.qualcomm.robotcore.hardware.Servo;

public class AirForceLaunch {
    private final Servo _launcher;

    public AirForceLaunch (Servo launcher)
    {
        _launcher = launcher;
    }

    public void Launch()
    {
        _launcher.setPosition(1);
    }

    public void Reset()
    {
        _launcher.setPosition(0);
    }
}
