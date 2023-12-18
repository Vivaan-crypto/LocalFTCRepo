package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp

public class MainTeleOp extends LinearOpMode {

    private Servo DroneLaunchServo;
    private Servo Claw1;// Left Servo
    //private Servo Claw2;//Right Servo
    private Servo ClawWrist1;//Left Servo Wrist
    //private Servo ClawWrist2;//Right Servo Wrist
    private DcMotorEx LinearClaw1; //, LinearClaw2;


    private Forward drive;

    @Override
    public void runOpMode() {
        drive = new Forward(hardwareMap, gamepad1, telemetry);
        DroneLaunchServo = hardwareMap.get(Servo.class, "DroneLaunchServo");
        Claw1 = hardwareMap.get(Servo.class, "Claw1");
        //    Claw2 = hardwareMap.get(Servo.class, "Claw2");
        ClawWrist1 = hardwareMap.get(Servo.class, "ClawWrist1");
        // ClawWrist2 = hardwareMap.get(Servo.class, "ClawWristR");
          LinearClaw1 = hardwareMap.get(DcMotorEx.class, "LinearClaw1"); //Configure in Expansion Hub
        //LinearClaw2 = hardwareMap.get(DcMotorEx.class, "LinearClawR"); //Configure in Expansion Hub
        waitForStart();
        while (opModeIsActive()) {

            drive.loop();
            ControllLoops();
        }

    }
    // If the if loops start glitchin then change remove the left_trigger and right_trigger if loops, and keep everything else the same. After that for the hanger if loops ONLY put them so that the LEFT trigger and the button/joystick have to be pressed/moved TOGETHER for the hanger if loops to work: For example: if(gameapd1.left_trigger & gamepad1.a) {...}
    public void ControllLoops() {
        if (gamepad1.a) {
            DroneLaunchServo.setPosition(1); /* Set servo to 180 degrees position, which in turn primes it for drone launch. Change the # as needed*/
        }
        if (gamepad1.x) {
            DroneLaunchServo.setPosition(0);
            // Launches the drone, and sets it to initial position. Change the # as needed
        }
        if (gamepad2.a) {
            Claw1.setPosition(1);//Grabs the pixel, change the # as needed-Left
        }
        if (gamepad2.b) {
            Claw1.setPosition(0);//Releases the pixel, change the # as needed-Left
        }
     /*    if (gamepad2.x){
         Claw2.setPosition(1); //Grabs the pixel, change the # as needed-Right
         }
         if (gamepad2.y){
         Claw2.setPosition(0); //Releases the pixel, change the # as needed-Right
         } */
        if (gamepad2.left_stick_y > 0.4 || gamepad2.left_stick_y < -0.4) {
            //This if statement moves the linear slides for the claw
            //Change to -gamepade..... if needed, you probably will need to do it because of how the motors will be place, MAKE SURE TO UPDATE THE -'s based on the placement of the motors.
            LinearClaw1.setPower(gamepad2.left_stick_y);
        }
        if (gamepad2.right_stick_y > 0.4) {
            ClawWrist1.setPosition(1); // This makes the Left claw bend upward , change the #  as needed
            // ClawWrist2.setPosition(1); // This makes the left claw bend upward , change the # as needed
        }
        if (gamepad2.right_stick_y < -0.4) {
            ClawWrist1.setPosition(0); // This makes the Left claw bend upward , change the #  as needed
            // ClawWrist2.setPosition(0); // This makes the left claw bend upward , change the # as needed
        }

    }

}
