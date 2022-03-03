package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.utils.Arm;
import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

@TeleOp(name="Feb Tele")
public class FebruaryTele extends LinearOpMode {
    public static DcMotor fl, fr, bl, br;
    public static Arm arm;
    public static Claw claw;
    DcMotor carousel;

    public void initialize() {
        claw = new Claw(hardwareMap);
        arm = new Arm(hardwareMap);
    }

    @Override public void runOpMode() throws InterruptedException {
        initialize();

        MecanumDrive drive = new MecanumDrive(hardwareMap);
        boolean slowMode = false;

        carousel = hardwareMap.dcMotor.get("carousel");

        waitForStart();

        while (opModeIsActive()) {
            // #----------Slow Mode---------#
            if (gamepad1.dpad_up) {
                slowMode = !slowMode;
            }

            drive.move(gamepad1.left_stick_x * (slowMode ? 0.3 : .7), -gamepad1.left_stick_y * (slowMode ? 0.3 : .7), gamepad1.right_stick_x * (slowMode ? 0.3 : .7));

            // #----------Arm---------#

            if (gamepad1.left_trigger > 0) {
                arm.down();
            }
            else if (gamepad1.right_trigger > 0) {
                arm.up();

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
                carousel.setPower(0.55);
            } else if (gamepad1.b) {
                carousel.setPower(-0.55);
            } else {
                carousel.setPower(0);
            }

            // #----------Claw---------#
            if (gamepad1.x) {
                claw.close();
            }
            if (gamepad1.y) {
                claw.open();
            }

            telemetry.addData("Slow Mode", slowMode ? "Yes" : "No");
            telemetry.addData("Arm Position", arm.getEncoderPosition());
            telemetry.update();
        }
        // to slow down mecanum drive you have to mulitply gamepad_1.stick * a scalar
        // start at 0.5
    }
}