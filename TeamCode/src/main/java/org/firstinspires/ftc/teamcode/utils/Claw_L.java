package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw_L {
    Servo clawServo;

    public Claw_L(HardwareMap hmap) {
        this.clawServo = hmap.servo.get(CONFIG.CLAW_L);
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