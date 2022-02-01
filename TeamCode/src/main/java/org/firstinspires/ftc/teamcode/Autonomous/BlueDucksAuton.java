package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.utils.Arm;
import org.firstinspires.ftc.teamcode.utils.Claw;

@Autonomous(name = "BlueDucksAuton")
public class BlueDucksAuton extends LinearOpMode {
    public void runOpMode() {
        // grabs the freight in the claw
        Claw claw = new Claw(hardwareMap);
        claw.close();

        // lifts the freight

        Arm arm = new Arm(hardwareMap);
        // determine how high the arm needs to go to reach the top

        arm.up(1); // change this depending on how we test it during test period

        // approach and drop into the top level of the station



        // carsoul + warehouse left for next week
    }
}