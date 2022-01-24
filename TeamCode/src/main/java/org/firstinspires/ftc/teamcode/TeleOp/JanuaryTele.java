package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.utils.Arm;
import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

@TeleOp(name="Mecanum Drive")
public class JanuaryTele extends LinearOpMode{
    public static DcMotor fl, fr, bl, br;
    public static Arm arm;
    public static Claw claw;

    DcMotor armMotor;
    DcMotor carousel;

    public void initialize() {
        claw = new Claw(hardwareMap);
    }

    @Override public void runOpMode() {

        initialize();

        MecanumDrive drive = new MecanumDrive(hardwareMap);
        boolean buttonPressed = false;
        boolean slowMode = false;

        carousel = hardwareMap.dcMotor.get("carousel");

        waitForStart();

        while (opModeIsActive()) {
            drive.move(gamepad1.left_stick_x * (slowMode ? 0.3 : 1), -gamepad1.left_stick_y * (slowMode ? 0.3 : 1), gamepad1.right_stick_x * (slowMode ? 0.3 : 1));

//            if (gamepad1.a) {
//                arm.stop();
//            }
//            if (gamepad1.left_trigger > 0) {
//                arm.up();
//            }
//            if (gamepad1.right_trigger > 0) {
//                arm.down();
//            }

            if (gamepad1.a) {
                carousel.setPower(0.3);
            } else if (gamepad1.b) {
                carousel.setPower(-0.3);
            } else {
                carousel.setPower(0);
            }

            if (gamepad1.left_bumper && !buttonPressed) {
                slowMode = !slowMode;
            }

            // #----------Claw---------#
            if (gamepad1.x) {
                claw.close();
            }

            if (gamepad1.y) {
                claw.open();
            }

            telemetry.addData("Slow Mode", slowMode ? "Yes" : "No");
            telemetry.update();

            buttonPressed = gamepad1.x;
        }
    }
}

