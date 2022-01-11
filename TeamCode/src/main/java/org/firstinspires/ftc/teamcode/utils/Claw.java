package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    DcMotor armMotor;

    public Claw(HardwareMap hmap) {
        this.armMotor = hmap.dcMotor.get(CONFIG.ARMMOTOR);
    }

    public void spin(double dx) {
        armMotor.setPower(dx);
    }

    public void close() {
        spin(1);
    }

    public void stop() {
        spin(0);
    }

    public void open() {
        spin(-1);
    }

    public void reverse() {
        spin(armMotor.getPower() * -1);
    }
}