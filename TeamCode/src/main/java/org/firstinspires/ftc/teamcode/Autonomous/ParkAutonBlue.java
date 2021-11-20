package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

@Autonomous(name = "ParkAutonBlue")
public class ParkAutonBlue extends LinearOpMode {
    public void runOpMode() {
        MecanumDrive mecDrive = new MecanumDrive(hardwareMap);

        waitForStart();
          
        mecDrive.move(0,0.3, 0);
        sleep(4000);
        mecDrive.move(0,0, 0);
    }
}
