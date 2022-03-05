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

        final int DETERMINANT = 400;
        boolean top = false;
        boolean middle = false;
        boolean bottom = true;

        waitForStart();

        //Grab freight

        Claw claw = new Claw(hardwareMap);
        claw.close();
        sleep(500);

        //lift
        Arm arm = new Arm(hardwareMap);
        if (top)
            arm.topPosition();
        else if (middle)
            arm.middlePosition();
        else
            arm.bottomPosition();
        sleep(500);

        //approach and drop into top level of the station
        MecanumDrive robot = new MecanumDrive(hardwareMap);

        /**
         * ADDED SUGGESTION:
         * make the robot move forward and then turn to avoid variability
         * coming from turning against an edge (traction/sticks)
         * angles will be changed when we implement CV,
         * otherwise, movement may remain
         *
         * OPEN CV:
         *
         */



        //start - turn to middle

        robot.move(0, .2, 0);
        sleep(500);

        robot.move(0, 0, 0);

        robot.move(0, 0, .22);
        sleep(500);

        //approach hub and deliver freight
        if (top)
            robot.move(0, .25, 0);
        else if (middle)
            robot.move(0, .22, 0);
        else
            robot.move(0, .20, 0);
        sleep(1400);
        robot.move(0,0,0);

        //turn, face hub
        claw.open();
        sleep(1000);
        claw.close();
        sleep(1000);

        robot.move(0,-.2,0);
        sleep(500);

        robot.move(0,0,0);

        robot.move(0, 0, -.22);
        sleep(500);
        robot.move(0,0,0);

        // return to the starting position
        if (top)
            robot.move(0, -.25, 0);
        else if (middle)
            robot.move(0, -.22, 0);
        else
            robot.move(0, -.20, 0);
        sleep(1200);
        robot.move(0,0,0);

//        if (top)
//            arm.downFromTop();
//        else if (middle)
//            arm.downFromMiddle();
//        else
//            arm.downFromBottom();
//        sleep(2000);
        //release, close, move away, lower
        //move into warehouse instead of parking space
        robot.move(.5, 0, 0);
        sleep(2500);
        robot.move(0,0,0);
    }
}