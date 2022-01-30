package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

@Autonomous(name = "ParkAutonBlue")
public class ParkAutonBlue extends LinearOpMode {
    public void runOpMode() {
        MecanumDrive mecDrive = new MecanumDrive(hardwareMap);

        // fly wheel
        DcMotor carousel = hardwareMap.dcMotor.get("carousel");

        waitForStart();

        // robot will start facing the warehouse

        mecDrive.move(0, -0.3, 0);
        sleep(2000);
        mecDrive.move(0,0,0);
        carousel.setPower(.3);

        /*

            if the top moves too far:
            mecDrive.move(0, -0.15, 0);
            sleep(2000);
            mecDrive.mpove(0,0,0);
            carousel.setPower(.3);

         */

        sleep(2000);
        carousel.setPower(0);

        sleep(2000);
        mecDrive.move(0,.6,0);
        sleep(4000);
        mecDrive.move(0,0, 0);

        /*

        if this moves too far forward:

        sleep(2000);
        mecDrive.move(0,.3,0);
        sleep(4000);
        mecDrive.move(0,0, 0);

         */
    }
}
