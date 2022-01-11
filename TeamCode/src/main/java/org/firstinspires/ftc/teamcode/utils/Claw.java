package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    DcMotor clawMotor;

    public Claw(HardwareMap hmap) {
        this.clawMotor = hmap.dcMotor.get(CONFIG.ARMMOTOR);
    }

    public void spin(double dx) {
        clawMotor.setPower(dx);
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
        spin(clawMotor.getPower() * -1);
    }
}