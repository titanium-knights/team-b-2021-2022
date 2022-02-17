package org.firstinspires.ftc.teamcode.utils;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {


    DcMotor armMotor;

    public Arm(HardwareMap hmap) {
        this.armMotor = hmap.dcMotor.get(CONFIG.ARMMOTOR);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setZeroPowerBehavior(BRAKE);
    }

    public void spin(double dx) {
        armMotor.setPower(dx);
    }

    public void stop() {
        spin(1/(double) 100);
    }

//    public void reverse() {
//        spin(armMotor.getPower() * -1);
//    }
    public void up() {
        armMotor.setTargetPosition(90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.3);
    }

    public void down() {
        armMotor.setTargetPosition(0);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.3);
    }

    /*
    public void up(double dx) {
        spin(dx/5.0);
    }

    public void down(double dx) {
        spin(-(dx/10.0));
    }
     */
}

