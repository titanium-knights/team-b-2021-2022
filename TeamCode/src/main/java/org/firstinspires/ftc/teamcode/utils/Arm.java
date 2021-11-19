package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {

    DcMotor armMotor;

    public Arm(HardwareMap hmap) {
        this.armMotor = hmap.dcMotor.get(CONFIG.ARMMOTOR);
    }

    public void spin(double dx) {
        armMotor.setPower(dx);
    }

    public void stop() {
        spin(0);
    }

    public void reverse() {
        spin(armMotor.getPower() * -1);
    }

    public void up() {
        spin(1);
    }

    public void down() {
        spin(-1);
    }
}
