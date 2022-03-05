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

    public void stop() {
        armMotor.setPower(0);
    }


    public int getEncoderPosition(){
        return armMotor.getCurrentPosition();
    }

    // right trigger
    public void up() {
        armMotor.setTargetPosition(90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.3);
    }

    // left trigger
    public void down() {
        armMotor.setTargetPosition(-90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.3);
    }

    // right bumper
    public void topPosition() throws InterruptedException {
        armMotor.setTargetPosition(90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.3);
        Thread.sleep(1700); // 1.7 seconds
        armMotor.setPower(0);
    }

    // left bumper
    public void downFromTop() throws InterruptedException {
        armMotor.setTargetPosition(-90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(.19);
        Thread.sleep(1700); // 1.7 seconds
        armMotor.setPower(0);
    }

    public void middlePosition() throws InterruptedException {
        armMotor.setTargetPosition(90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(.13);
        Thread.sleep(1700); // 1.7 seconds
        armMotor.setPower(0);
    }

    public void downFromMiddle() throws InterruptedException {
        armMotor.setTargetPosition(-90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(.11);
        Thread.sleep(1700); // 1.7 seconds
        armMotor.setPower(0);
    }

    public void bottomPosition() throws InterruptedException {
        armMotor.setTargetPosition(90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(.12);
        Thread.sleep(1700); // 1.7 seconds
        armMotor.setPower(0);
    }

    public void downFromBottom() throws InterruptedException {
        armMotor.setTargetPosition(-90);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(.12);
        Thread.sleep(1700); // 1.7 seconds
        armMotor.setPower(0);
    }

    public void setPower(double pwr){
        armMotor.setPower(pwr);
    }
}

