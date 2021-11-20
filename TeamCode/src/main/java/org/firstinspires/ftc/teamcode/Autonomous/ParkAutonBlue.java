package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

@Autonomous(name = "ParkAutonRed")
public class ParkAutonBlue extends LinearOpMode {
    public void runOpMode() {
        MecanumDrive mecDrive = new MecanumDrive(hardwareMap);

        waitForStart();
          
        mecDrive.move(1,0, Math.toRadians(-90));
        sleep(250);
        mecDrive.move(0,0, 0);
    }
}
