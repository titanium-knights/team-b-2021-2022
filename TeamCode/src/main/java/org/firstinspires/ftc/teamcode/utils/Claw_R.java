package org.firstinspires.ftc.teamcode.utils;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw_R {
    Servo clawServo;

    public Claw_R(HardwareMap hmap) {
        this.clawServo = hmap.servo.get(CONFIG.CLAW_R);
    }

    public void spin(double dx) {
        clawServo.setPosition(dx);
    }

    public void close() {
        spin(.5);
    }

    public void open() {
        spin(1);
    }
}
