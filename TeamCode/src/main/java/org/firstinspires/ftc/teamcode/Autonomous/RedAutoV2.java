package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous
public class RedAutoV2 extends LinearOpMode {

    private DcMotor fr, fl, br, bl; //fr is the wonky one
    private DcMotor LinearClaw;
    private Servo ClawL;
    private Servo ClawR;
    private Servo ClawWrist;

    @Override
    public void runOpMode() {
        fr = hardwareMap.get(DcMotor.class, "fr"); //The wonky One
        fl = hardwareMap.get(DcMotor.class, "fl");
        br = hardwareMap.get(DcMotor.class, "br");
        bl = hardwareMap.get(DcMotor.class, "bl");
        LinearClaw = hardwareMap.get(DcMotor.class, "LinearClaw");
        ClawR = hardwareMap.get(Servo.class, "ClawR");
        ClawL = hardwareMap.get(Servo.class, "ClawL");
        ClawWrist = hardwareMap.get(Servo.class,"ClawWrist");
        fr.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.FORWARD);
        br.setDirection(DcMotor.Direction.REVERSE);
        bl.setDirection(DcMotor.Direction.REVERSE);
        fl.setPower(0);
        bl.setPower(0);
        fr.setPower(0);
        br.setPower(0); 
        ClawL.setPosition(1);//Change the numbers for this and the line below but make sure claw clamps onto pixel(s).
        ClawR.setPosition(0);
        telemetry.addData("Status", "Initialized, Pixel is grabbed onto tightly & All systems are at 0");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            sleep(3000);
            fr.setPower(0.5);
            fl.setPower(0.5);
            br.setPower(0.5);
            bl.setPower(0.5);
            //Robot moves forward so side of robot is aligned with truss 2.
            sleep(1500);
            fr.setPower(-0.5);
            fl.setPower(0.5);
            br.setPower(-0.5);
            bl.setPower(0.5);
            //Robot turns to the right to face truss 2
            sleep(800);
                    fr.setPower(0.5);
                    fl.setPower(0.5);
                    br.setPower(0.5);
                    bl.setPower(0.5);
//Robot moves to the EDGE of starting line of backstage.
                    sleep(1500);//Change time as needed
                  ClawWrist.setPosition(1); //Change #, but make sure that the claw wrist bends upwards and becomes somewhat vertical
                     sleep(1000); 
                    fr.setPower(-0.5);
                    fl.setPower(0.5);
                    br.setPower(0.5);
                    bl.setPower(-0.5); 
          //Robot strafes to the right so the claw is lined up in the middle between the center and left side of backboard.   
                    sleep(500); //Change time as needed
                       fr.setPower(0.3);
                       fl.setPower(0.3);
                       br.setPower(0.3);
                       bl.setPower(0.3);
                       sleep(800);
                     LinearClaw.setPower(0.5);
                     sleep(1500); //Change time & #’s so that there is enough space for viper kit to extend
                       ClawL.setPosition(1);
                       ClawR.setPosition(0);
                       sleep(500);
                    ClawWrist.setPosition(0); //Change #, but make sure that the claw wrist bends downwards and becomes 180 degree horizontal.
                    sleep(500);
                    LinearClaw.setPower(-0.5);
                    sleep(1500);
                    fr.setPower(0);
                    fl.setPower(0);
                    br.setPower(0);
                    bl.setPower(0);
                    sleep(25000);
                       telemetry.addData("Status", "Program Over, everything at 0");
                       telemetry.update();

        }
    }
}
