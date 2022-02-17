package org.firstinspires.ftc.teamcode.Autonomous.Archived;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.utils.Arm;
import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

//blue block side
@Autonomous(name = "ParkAutonBlueNoCarousel")
public class ParkAutonBlue extends LinearOpMode {
    public void runOpMode() {
        int armnum = 1;
        //Grab freight
        Claw claw = new Claw(hardwareMap);
        claw.close();

        //lift
        //determine how high arm has to go to reach the top
        Arm arm = new Arm(hardwareMap);
//        arm.up(armnum);

        //approach and drop into top level of the station
        MecanumDrive robot = new MecanumDrive(hardwareMap);

        //start - turn to middle
        robot.move(0, 0, 0.25);
        //one tile, middle
        robot.move(1, 0, 0);
        //turn, face hub
        robot.move(0, 0, -0.25);
        //move to hub
        robot.move(0, 1, 0);
        //release, close, move away, lower
        claw.open();
        claw.close();
        robot.move(0, -1.5, 0);
//        arm.down(armnum);
        //turn towards warehouse
        robot.move(0, 0, -0.25);
        //move into warehouse instead of parking space
        robot.move(0, 3, 0);








    }
}
