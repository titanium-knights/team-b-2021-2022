package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Carousel {

    DcMotor carousel;

    public Carousel(HardwareMap hmap) {
        this.carousel = hmap.dcMotor.get(CONFIG.CAROUSEL);
    }

    public void spin(double dx) {
        carousel.setPower(dx);
    }
}
