package TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

@TeleOp(name="Mecanum Drive")
public class NovemberTele extends LinearOpMode{
    public static DcMotor fl, fr, bl, br;

    @Override public void runOpMode() {

        MecanumDrive.init();
        MecanumDrive mecanumDrive = new MecanumDrive();

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
            MecanumDrive.move(gamepad1.left_stick_x, gamepad1.left_stick_y);
        }
    }
}

class MecanumDrive {
    public static DcMotor fl, fr, bl, br;

    public static HashMap<DcMotor, double[]> directions;

    public static void init() {
        // Direction Vectors
        directions.put(fl, new double[]{1,1});
        directions.put(fr, new double[]{-1,1});
        directions.put(bl, new double[]{-1,1});
        directions.put(fl, new double[]{1,1});
    }

    public static void move(double x, double y) {
        // dot of fl and br
        double dot_fl = dot(Objects.requireNonNull(directions.get(fl)), new double[]{x,y});
        double dot_fr = dot(Objects.requireNonNull(directions.get(fr)), new double[]{x,y});

        double max = Math.max(Math.abs(dot_fl), Math.abs(dot_fr));
        fl.setPower(dot_fl/max);
        br.setPower(dot_fl/max);

        fr.setPower(dot_fr/max);
        bl.setPower(dot_fr/max);
    }

    // Each double[] will be a direction vector of length two
    public static double dot(double[] a, double[] b) {
        return a[0]*b[0] + a[1]*b[1];
    }

    public void rotate(double r) {

    }


}