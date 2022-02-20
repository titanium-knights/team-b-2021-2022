package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.utils.Arm;
import org.firstinspires.ftc.teamcode.utils.Claw_L;
import org.firstinspires.ftc.teamcode.utils.Claw_R;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

@TeleOp(name="Feb Tele")
public class FebruaryTele extends LinearOpMode {
    public static DcMotor fl, fr, bl, br;
    public static Arm arm;
    public static Claw_L claw_L;
    public static Claw_R claw_R;

    DcMotor carousel;

    public void initialize() {
        claw_L = new Claw_L(hardwareMap);
        claw_R = new Claw_R(hardwareMap);
        arm = new Arm(hardwareMap);
    }

    @Override public void runOpMode() throws InterruptedException {
        initialize();

        MecanumDrive drive = new MecanumDrive(hardwareMap);
        boolean slowMode = false;

        // Note from Umar: I'm wondering if when we run setTargetPosition(90), it sets the target position 90 degrees relative to the current position
        // However, our current position is always turning when we run arm.up() or arm.down(), which means the target position will continue increasing
        // because the current position continues increasing when we hold one of the triggers down. So, I'm gonna try making a triggerPressed boolean so
        // that pressing the trigger again will do nothing while the arm rotates up or down.
        // IMPORTANT: THIS SOLUTION DOES NOT WORK CURRENTLY - Umar
        // boolean triggerPressed = false;

        carousel = hardwareMap.dcMotor.get("carousel");

        waitForStart();

        while (opModeIsActive()) {
            // #----------Slow Mode---------#
            if (gamepad1.dpad_up) {
                slowMode = !slowMode;
            }

            drive.move(gamepad1.left_stick_x * (slowMode ? 0.3 : .7), -gamepad1.left_stick_y * (slowMode ? 0.3 : .7), gamepad1.right_stick_x * (slowMode ? 0.3 : .7));

            // #----------Arm---------#
            // delegated for gamepad2
//            if (gamepad1.right_bumper) {
//                arm.stop();
//            }
            if (gamepad1.left_trigger > 0) {
                //arm.setPower(-gamepad1.left_trigger);
//                telemetry.addData("triggerPressed", "true");
//                triggerPressed = true;
                arm.down();
//                telemetry.addData("triggerPressed", "false");
//                triggerPressed = false; // my intention is that we set triggerPressed to true until the arm goes down, and then we set triggerPressed to false after
            }
            else if (gamepad1.right_trigger > 0) {
                //arm.setPower(gamepad1.right_trigger);
//                telemetry.addData("triggerPressed", "true");
//                triggerPressed = true;
                arm.up();
//                telemetry.addData("triggerPressed", "false");
//                triggerPressed = false;
            }
            else if (gamepad1.left_bumper) {
                telemetry.addData("Left bumper", "start");
                arm.downToPosition();
                telemetry.addData("Left bumper", "end");
            }
            else if (gamepad1.right_bumper) {
                telemetry.addData("Right bumper", "start");
                arm.upToPosition();
                telemetry.addData("Right bumper", "end");
            }
            else {
                arm.stop();
            }

            // #----------Carousel---------#
            if (gamepad1.a) {
                carousel.setPower(0.3);
            } else if (gamepad1.b) {
                carousel.setPower(-0.3);
            } else {
                carousel.setPower(0);
            }

            // #----------Claw---------#
            if (gamepad1.x) {
                claw_L.close();
                claw_R.close();
            }
            if (gamepad1.y) {
                claw_L.open();
                claw_R.open();
            }

            telemetry.addData("Slow Mode", slowMode ? "Yes" : "No");
            telemetry.addData("Arm Position", arm.getEncoderPosition());
            telemetry.update();
        }
        // to slow down mecanum drive you have to mulitply gamepad_1.stick * a scalar
        // start at 0.5
    }
}