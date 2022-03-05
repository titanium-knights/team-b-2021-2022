package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.utils.Arm;
import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

@TeleOp(name="TestOp")
public class TestOp extends LinearOpMode {
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
            if (gamepad1.a)
                arm.bottomPosition();
            if (gamepad1.b)
                arm.middlePosition();
            if (gamepad1.y)
                arm.topPosition();
            if (gamepad1.x)
                arm.downFromTop();
            if (gamepad1.left_trigger > 0) {
                arm.downFromBottom();
            }
            if (gamepad1.right_trigger > 0) {
                arm.downFromMiddle();
            }

            telemetry.addData("Slow Mode", slowMode ? "Yes" : "No");
            telemetry.addData("Arm Position", arm.getEncoderPosition());
            telemetry.update();
        }
    }
}
