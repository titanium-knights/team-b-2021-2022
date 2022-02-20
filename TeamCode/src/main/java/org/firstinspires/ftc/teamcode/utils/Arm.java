package org.firstinspires.ftc.teamcode.utils;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.lang.Thread;

public class Arm {


    DcMotor armMotor;

    public Arm(HardwareMap hmap) {
        this.armMotor = hmap.dcMotor.get(CONFIG.ARMMOTOR);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setZeroPowerBehavior(BRAKE);
    }

    public void spin(double dx) {
        armMotor.setPower(dx);
    }

    /*
    public void stop() {
        spin(1/(double) 100);
    }
    */

    public void stop() {
        armMotor.setPower(0);
    }

//    public void reverse() {
//        spin(armMotor.getPower() * -1);
//    }w
    public int getEncoderPosition(){
        return armMotor.getCurrentPosition();
    }

    public void up() {
        armMotor.setTargetPosition(90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.3);
    }

    public void down() {
        armMotor.setTargetPosition(-90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.3);
    }

    public void upToPosition() throws InterruptedException {
        armMotor.setTargetPosition(90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.3);
        Thread.sleep(1700); // 1.7 seconds
        armMotor.setPower(0);
    }

    public void downToPosition() throws InterruptedException {
        armMotor.setTargetPosition(-90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.3);
        Thread.sleep(1700); // 1.7 seconds
        armMotor.setPower(0);
    }

    public void setPower(double pwr){
        armMotor.setPower(pwr);
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

