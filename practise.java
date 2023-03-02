package org.firstinspires.ftc.teamcode.drive;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

public class autonomous {
    @Override

    public void waitForStart(){

    }
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Vector2d myVector = new Vector2d(10,-5);
        Vector2d myVector2 = new Vector2d(20,5);

        Pose2d startPose = new Pose2d(10, -8, Math.toRadians(90));
        drive.setPoseEstimate(startPose);

        Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d())
                .splineTo(new Vector2d(20,10),Math.toRadians(90))
                .splineTo(myVector2,Math.toRadians(180))
                .build();

        Trajectory myTrajectory2 = drive.trajectoryBuilder(new Pose2d(), true) //should the bot move in reverse = true
                .splineTo(new Vector2d(30,20),Math.toRadians(90))
                .splineTo(myVector,Math.toRadians(180))
                .build();

        Trajectory myTrajectory3 = drive.trajectoryBuilder(new Pose2d())
                .splineTo(new Vector2d(50,70),Math.toRadians(90))
                .splineTo(myVector2,Math.toRadians(180))
                .build();

        drive.followTrajectory(myTrajectory);
        drive.turn(Math.toRadians(90));
        drive.followTrajectory(myTrajectory2);
        drive.turn(Math.toRadians(20));
        drive.followTrajectory(myTrajectory3);

        Trajectory myTraj = drive.trajectoryBuilder(new Pose2d())
                .forward(40)
                .back(60)
                .strafeLeft(90)
                .strafeRight(30)
                .strafeTo(new Vector2d(20,30)) //keeps orientation the same while moving to the coordinate
                .lineTo(new Vector2d(30,80)) //same as .strafeTo()
                .lineToConstantHeading(new Vector2d(30,30)) //same as .strafeTo
                .lineToLinearHeading(new Pose2d(40,90, Math.toRadians(40))) //moves and turns at the same time
                .lineToSplineHeading(new Pose2d(40, 80, Math.toRadians(20))) //same as .lineToLinearHeading()
                .splineTo(new Vector2d(40,40), Math.toRadians(0)) //bot goes via spline path, smooth corners
                .splineToConstantHeading(new Vector2d(3,9),Math.toRadians(89)) //spline to but keeps the bot facing the same way
                .splineToLinearHeading(new Pose2d(6,8) ,Math.toRadians(40)) //.splineToConstantHeading() but turns the bot ending in the way they are supposed to

                .build();







        drive.followTrajectory(myTrajectory);
    }
}
