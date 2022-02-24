package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.utils.Carousel;
//import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;


//blue block side
@Autonomous(name = "BlueDucksAuton")
public class BlueDucksAuton extends LinearOpMode {
    public void runOpMode() {

        Carousel carousel = new Carousel(hardwareMap);

        //approach and drop into top level of the station
        MecanumDrive robot = new MecanumDrive(hardwareMap);

        //start - turn to carousel
        robot.move(0, 0, -0.557);
        //move to carousel
        robot.move(0, -1.2, 0);
        //spin carousel


        carousel.spin(4);
        sleep(2000);

        //move diagonally into parking space
        robot.move(0.1, 0.02, 0);
    }
}