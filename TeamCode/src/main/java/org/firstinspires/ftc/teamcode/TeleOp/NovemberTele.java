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

//    public void initialize() {
//        arm = new Arm(hardwareMap);
//    }

    @Override public void runOpMode() {

//        initialize();

        MecanumDrive.init();
        MecanumDrive mecanumDrive = new MecanumDrive(hardwareMap);

        DcMotor fl = hardwareMap.dcMotor.get("fl");
        DcMotor fr = hardwareMap.dcMotor.get("fr");
        DcMotor bl = hardwareMap.dcMotor.get("bl");
        DcMotor br = hardwareMap.dcMotor.get("br");

        fl.setDirection(DcMotorSimple.Direction.FORWARD);
        bl.setDirection(DcMotorSimple.Direction.FORWARD);
        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        br.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            MecanumDrive.move(gamepad1.left_stick_x, -gamepad1.left_stick_y);

//            if (gamepad1.a) {
//                arm.stop();
//            }
//            if (gamepad1.left_trigger > 0) {
//                arm.up();
//            }
//            if (gamepad1.right_trigger > 0) {
//                arm.down();
//            }
        }
    }
}

