package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.utils.Arm;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

@TeleOp(name="Mecanum Drive")
public class NovemberTele extends LinearOpMode{
    public static DcMotor fl, fr, bl, br;
    public static Arm arm;

    DcMotor armMotor;
    DcMotor carousel;

//    public void initialize() {
//        arm = new Arm(hardwareMap);
//    }

    @Override public void runOpMode() {

//        initialize();

        new MecanumDrive(hardwareMap);
        MecanumDrive.init();

        carousel = hardwareMap.dcMotor.get("carousel");

        waitForStart();

        while (opModeIsActive()) {
            MecanumDrive.move(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);

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
                carousel.setPower(1);
            } else if (gamepad1.b) {
                carousel.setPower(-1);
            } else {
                carousel.setPower(0);
            }
        }
    }
}

