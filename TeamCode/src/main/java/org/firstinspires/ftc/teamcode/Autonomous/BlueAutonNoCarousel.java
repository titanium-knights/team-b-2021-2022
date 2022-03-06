package org.firstinspires.ftc.teamcode.Autonomous;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.teamcode.utils.Arm;
//import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.Claw;
import org.firstinspires.ftc.teamcode.utils.MecanumDrive;

import java.util.List;

@Autonomous(name = "BlueAutonNoCarousel")
public class BlueAutonNoCarousel extends LinearOpMode {

    // cv
//    private static final String TFOD_MODEL_ASSET = "FreightFrenzy_BCDM.tflite";
//    private static final String[] LABELS = {
//            "Ball",
//            "Cube",
//            "Duck",
//            "Marker"
//    };

    //private static double leftXCoord = -1;

    //private static String VUFORIA_KEY = "AekBV2P/////AAABmavTjMKllUm0mQej0m+pKLg+rEi6r41OqZtvQzjSdxX3p6BmCBq0b+VDf+p0bmOsiagf5onjXXOFX2s8LWH7/L8rO/5ITpgkFecW48UX8fcWKjpTf/1p7NaAv1IBD2sKHx1kUcfC6NUDT0RjdmqEIAdGoLG1xnJDiQkHDVsO0Ec0uRFO08a6rDh8QsU4x2cz3cTptLekui2n3WclZvKpL3epvfgsolnOGWmdPT6CNYBmvMhKm8hId8MRCGUBTXQUsv74XVok2iiAiYgrwWQ80uW6xizTtxml17bQwJ8KQ250WXipdxp7IqJaHb1Le7yyv8Nl33XiQ4kORZSjcx46aAxYP3e0IV3OHsos4Ef9SjDi";

//    private VuforiaLocalizer vuforia;

//    private TFObjectDetector tfod;

    public void runOpMode() throws InterruptedException {

        // cv
//        initVuforia();
//        initTfod();

//        if (tfod != null) {
//            tfod.activate();
//
//            tfod.setZoom(2.5, 16.0/9.0);
//        }
//
        /** Wait for the game to begin */
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.update();
        waitForStart();

//        if (opModeIsActive()) {
//            int iterations = 0;
//            while (opModeIsActive()) {
//                if (iterations > 100000) // increase this number if it keeps going for the bottom freight
//                    break;
//                if (tfod != null) {
//                    // getUpdatedRecognitions() will return null if no new information is available since
//                    // the last time that call was made.
//                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
//                    if (updatedRecognitions != null) {
//                        telemetry.addData("# Object Detected", updatedRecognitions.size());
//
//                        // step through the list of recognitions and display boundary info.
//                        int i = 0;
//                        for (Recognition recognition : updatedRecognitions) {
//                            telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
//                            telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
//                                    recognition.getLeft(), recognition.getTop());
//                            telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
//                                    recognition.getRight(), recognition.getBottom());
//                            i++;
//
//                            // updates label pertaining to duck detection
//                            updateLabels(recognition);
//
//                        }
//                        telemetry.update();
//                        if (updatedRecognitions.size() > 0) {
//                            leftXCoord = updatedRecognitions.get(0).getLeft();
//                            break; // breaks when a marker is detected
//                        }
//                    }
//                }
//                iterations++;
//            }
//        }

        final int DETERMINANT = 400;
        boolean top = true; // if something goes wrong set this to true
        boolean middle = false;
        boolean bottom = false;

//        double markerPos = getCoords();
//        if (markerPos > DETERMINANT)
//            top = true;
//        else if (markerPos < DETERMINANT)
//            middle = true;
//        else
//            bottom = true;

        waitForStart();

        //Grab freight

        Claw claw = new Claw(hardwareMap);
        claw.close();
        sleep(500);

        //lift
        Arm arm = new Arm(hardwareMap);
        if (top)
            arm.topPosition();
        else if (middle)
            arm.middlePosition();
        else
            arm.bottomPosition();
        sleep(500);

        //approach and drop into top level of the station
        MecanumDrive robot = new MecanumDrive(hardwareMap);

        //start - turn to middle

        robot.move(0, .2, 0);
        sleep(500);

        robot.move(0, 0, 0);

        robot.move(0, 0, .22);
        sleep(500);

        //approach hub and deliver freight
        if (top)
            robot.move(0, .25, 0);
        else if (middle)
            robot.move(0, .22, 0);
        else
            robot.move(0, .20, 0);
        sleep(1400);
        robot.move(0,0,0);

        //turn, face hub
        claw.open();
        sleep(1000);
        claw.close();
        sleep(1000);

        robot.move(0,-.2,0);
        sleep(500);

        robot.move(0,0,0);

        robot.move(0, 0, -.22);
        sleep(500);
        robot.move(0,0,0);

        // return to the starting position
        if (top)
            robot.move(0, -.25, 0);
        else if (middle)
            robot.move(0, -.22, 0);
        else
            robot.move(0, -.20, 0);
        sleep(1200);
        robot.move(0,0,0);

//        if (top)
//            arm.downFromTop();
//        else if (middle)
//            arm.downFromMiddle();
//        else
//            arm.downFromBottom();
//        sleep(2000);
        //release, close, move away, lower
        //move into warehouse instead of parking space
        robot.move(-.5, 0, 0);
        sleep(2500);
        robot.move(0,0,0);
    }

//    public double getCoords() {
        // return left x coord
//        return leftXCoord;
//    }
    /**
     * Update labels based on detection
     */
//    private void updateLabels(Recognition rec) {
//        if (rec.getLabel().equals("Duck")) {
//            telemetry.addData("Object Detected", "Duck");
//        }
//        else if (rec.getLabel().equals("Ball")) {
//            telemetry.addData("Object Detected", "Ball");
//        }
//        else if (rec.getLabel().equals("Marker")) {
//            telemetry.addData("Object Detected", "Marker");
//        }
//        else if (rec.getLabel().equals("Cube")) {
//            telemetry.addData("Object Detected", "Cube");
//        }
//    }

    /**
     * Initialize the Vuforia localization engine.
     */
//    private void initVuforia() {
//        /*
//         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
//         */
//        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
//
//        parameters.vuforiaLicenseKey = VUFORIA_KEY;
//        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");
//        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
//
//        //  Instantiate the Vuforia engine
//        vuforia = ClassFactory.getInstance().createVuforia(parameters);
//
//        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
//        FtcDashboard.getInstance().startCameraStream(vuforia, 0);
//
//    }
//
//    /**
//     * Initialize the TensorFlow Object Detection engine.
//     */
//    private void initTfod() {
//        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
//                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
//        tfodParameters.minResultConfidence = 0.8f;
//        tfodParameters.isModelTensorFlow2 = true;
//        tfodParameters.inputSize = 320;
//        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
//        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
//    }

}