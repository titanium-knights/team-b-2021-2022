package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.HashMap;
import java.util.Objects;

public class MecanumDrive {

    public MecanumDrive(HardwareMap hmap) {
        fl = hmap.get(DcMotor.class, CONFIG.FRONTLEFT);
        fr = hmap.get(DcMotor.class, CONFIG.FRONTRIGHT);
        bl = hmap.get(DcMotor.class, CONFIG.BACKLEFT);
        br = hmap.get(DcMotor.class, CONFIG.BACKRIGHT);
    }

    public static DcMotor fl, fr, bl, br;

    public static HashMap<DcMotor, double[]> directions;

    public static void init() {
        // Direction Vectors
        directions.put(fl, new double[]{1, 1});
        directions.put(fr, new double[]{-1, 1});
        directions.put(bl, new double[]{-1, 1});
        directions.put(fl, new double[]{1, 1});
    }

    public static void move(double x, double y) {
        // dot of fl and br
        double dot_fl = dot(Objects.requireNonNull(directions.get(fl)), new double[]{x, y});
        double dot_fr = dot(Objects.requireNonNull(directions.get(fr)), new double[]{x, y});

        double max = Math.max(Math.abs(dot_fl), Math.abs(dot_fr));
        fl.setPower(dot_fl / max);
        br.setPower(dot_fl / max);

        fr.setPower(dot_fr / max);
        bl.setPower(dot_fr / max);
    }

    // Each double[] will be a direction vector of length two
    public static double dot(double[] a, double[] b) {
        return a[0] * b[0] + a[1] * b[1];
    }

    public void rotate(double r) {

    }
}
