package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
@Autonomous(name = "LeftAuto2_DriveToBackBoard")
//Where in the driver program this will be found ^
public class LeftAuto2_DriveToBackBoard extends LinearOpMode

{
    DcMotor fr, fl, br, bl;
    private Servo Claw1;
  //  private Servo Claw2;
    @Override
    public void runOpMode()
    {

        fr = hardwareMap.get(DcMotor.class, "fl");
        //motor0
        fl = hardwareMap.get(DcMotor.class, "bl");
        //motor1
        br = hardwareMap.get(DcMotor.class, "fr");
        //motor2
        bl = hardwareMap.get(DcMotor.class, "br");
        //motor3
        Claw1 = hardwareMap.get(Servo.class, "Claw1");
        //Left Claw
     //   Claw2 = hardwareMap.get(Servo.class, "Claw2");
        //Right Claw
        fr.setDirection(DcMotor.Direction.FORWARD);//Motor with ISSUES!!! Ultu
        fl.setDirection(DcMotor.Direction.FORWARD);
        br.setDirection(DcMotor.Direction.FORWARD);
        bl.setDirection(DcMotor.Direction.FORWARD);
        waitForStart();
        while(opModeIsActive()) {
            //1000 = 1 sec
            //IF YOU CHANGE SPEED THEN CHANGE TIME OR IT WILL OVER/UNDER TRAVEL
            //Change when mech team adds 425's(motors)
            sleep(3000);
            //Moves Forward
            fr.setPower(-0.5);
            fl.setPower(0.5);
            br.setPower(0.5);
            bl.setPower(0.5);
            sleep(500);
            //Robot turns into position.
            fr.setPower(-0.5);
            fl.setPower(-0.5);
            br.setPower(0.5);
            bl.setPower(-0.5);
            sleep (500);
            //Robot Moves FORWARD
            fr.setPower(-0.5);
            fl.setPower(0.5);
            br.setPower(0.5);
            bl.setPower(0.5);
            sleep (1000);
            Claw1.setPosition(0);
        //    Claw2.setPosition(1);
            fl.setPower(0);
            fr.setPower(0);
            bl.setPower(0);
            br.setPower(0);
            sleep (1000);
            fl.setPower(0.3);
            fr.setPower(0.3);
            bl.setPower(0.3);
            br.setPower(-0.3);
            sleep (500);
            fr.setPower(-0.3);
            fl.setPower(0.3);
            bl.setPower(0.3);
            br.setPower(0.3);
            sleep (500);
            fr.setPower(0);
            fl.setPower(0);
            bl.setPower(0);
            br.setPower(0);
            sleep (23000);
        }
    }
}
