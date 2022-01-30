package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

@Autonomous(name = "ParkAutonRed")
public class ParkAutonRed extends LinearOpMode {
    public void runOpMode() {
        MecanumDrive mecDrive = new MecanumDrive(hardwareMap);

        // fly wheel
        DcMotor carousel = hardwareMap.dcMotor.get("carousel");

        waitForStart();

        // robot will start facing the warehouse

        mecDrive.move(0, -0.3, 0);
        sleep(2000);
        carousel.setPower(.3);

        sleep(2000);
        carousel.setPower(0);

        mecDrive.move(0,0.3, 0);
//        sleep(4000);
//        mecDrive.move(0,0, 0);
    }
}
