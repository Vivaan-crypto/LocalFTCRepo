package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous
//READ ALL THE COMMENTS FOR CLEARANCE!!!!!!!!- SOME MAYBE A LITTLE CONFUSING, just ask Namya if you're confused!!
public class Autonomous1TopLeft1 extends OpMode {
    private DistanceSensor dsensor;
    private DcMotor fl, bl, fr, br;
    private Servo Claw1;// Left Servo
    private Servo Claw2;//Right Servo

    @Override
    public void init() {
        dsensor = hardwareMap.get(DistanceSensor.class, "dsensor");
        fl = hardwareMap.get(DcMotor.class, "fl");
        bl = hardwareMap.get(DcMotor.class, "bl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        br = hardwareMap.get(DcMotor.class, "br");
        Claw1 = hardwareMap.get(Servo.class, "Claw1");
        Claw2 = hardwareMap.get(Servo.class, "Claw2");
        fl.setPower(0);
        bl.setPower(0);
        fr.setPower(0);
        br.setPower(0);
    }


    //WHEN YOU MEASURE THE DISTANCE OF FOR SENSOR MEASURE FROM THE END OF OUR ROBOT WHEN IT IS PLACED ON THE FIELD TO THE START OF THE OPPOSITIONS ROBOT!!! DON'T USE WHOLE FIELD MEASUREMENTS!!!!!!!!!!!!!!!!
    //Autonomous 2(Top Right) Top= near backboard
    //Change the values of the variable "value" after measuring!!!!!

    @Override
    public void loop() {
        double value = dsensor.getDistance(DistanceUnit.CM); //Put this in the first void loop if an error about it comes up
        //If the code glitches out and the if loops inside the first one don't work, try  loops inside the if loops
        if (value >= 2 && value <= 20) {
            fl.setPower(0.1);
            bl.setPower(-0.1);
            fr.setPower(0.1);
            br.setPower(-0.1);
            if (value >= 10 && value <= 20) {  // For this put the range of the amount of the distance from the wanted position of the robot to the the place where the oppositions ROBOT IS GOING TO BE PLACED and the amount of distance from the wanted position of the robot to the other wall
                fl.setPower(-0.1);
                bl.setPower(0.1);
                fr.setPower(0.1);
                br.setPower(-0.1);
                /*Ask Vivaan why code is showing error about else if loop*/
                if (value == 15) { /* For this put the # of inches the back board is away from the robot when it is 90 degrees turned to the right, Remember the robot is right now in the top right. */
                    fl.setPower(0.1);
                    bl.setPower(-0.1);
                    fr.setPower(0.1);
                    br.setPower(-0.1);
                    /*Ask Vivaan why code is showing error about else if loop*/
                    if (value == 5) { /* For this put the # of inches you want the robot to be from the backboard before it stops and drops the 2 pixels */
                        fl.setPower(0);
                        bl.setPower(0);
                        fr.setPower(0);
                        br.setPower(0);
                        Claw1.setPosition(1); /*Put the # in based upon placement of servo, and based upon how what the servo # will be when it is in a certain position, you get the point. The Claws should just drop the pixels! */
                        Claw2.setPosition(0); /* Put the # in based upon placement of servo, and based upon how what the servo # will be when it is in a certain position, you get the point. The Claws should just drop the pixels! */
                    }
                }
            }
        }
     }
    }