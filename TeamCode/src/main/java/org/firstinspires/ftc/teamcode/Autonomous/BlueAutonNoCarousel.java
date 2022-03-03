package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.utils.Arm;
//import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

@Autonomous(name = "BlueAutonNoCarousel")
public class BlueAutonNoCarousel extends LinearOpMode {
    public void runOpMode() throws InterruptedException {

        // sleep for 10 seconds so the other team can go into the warehouse
        sleep(10000);

        waitForStart();

        //Grab freight
//        Claw claw = new Claw(hardwareMap);
//        claw.close();
        Claw claw = new Claw(hardwareMap);
        claw.close();
        sleep(500);

        //lift
        //determine how high arm has to go to reach the top
        Arm arm = new Arm(hardwareMap);
        arm.upToPosition();
        sleep(500);

        //approach and drop into top level of the station
        MecanumDrive robot = new MecanumDrive(hardwareMap);

        //start - turn to middle
        robot.move(0, 0, .25);
        sleep(500);
        //one tile, middle
        robot.move(0, .25, 0);
        sleep(1900);
        robot.move(0,0,0);

        //turn, face hub
        claw.open();
        sleep(1000);
        claw.close();
        sleep(1000);

        robot.move(0, 0, -.25);
        sleep(500);

        //move to hub
        robot.move(0, -.25, 0);
        sleep(1000);
        arm.downToPosition();
        sleep(2000);
        //release, close, move away, lower
//        claw.open();
//        claw.close();

        //turn towards warehouse
        robot.move(0, 0, -.37);
        sleep(1000);
        //move into warehouse instead of parking space
        robot.move(0, .5, 0);
        sleep(2500);
        robot.move(0,0,0);
    }
}