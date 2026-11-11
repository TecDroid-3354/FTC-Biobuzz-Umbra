package org.firstinspires.ftc.teamcode.Autonomous

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.geometry.Pose2d
import com.seattlesolvers.solverslib.geometry.Rotation2d
import com.seattlesolvers.solverslib.geometry.Translation2d
import com.seattlesolvers.solverslib.trajectory.Trajectory
import com.seattlesolvers.solverslib.trajectory.TrajectoryGenerator
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.Chasis.TankDriveConstants

object AutoFirstOption {

    val trajectoryStartPoints = mutableListOf<Pose2d>()
    val secondTrajectoryPoints = mutableListOf<Pose2d>()
    val thirtdTrajectoryPoints = mutableListOf<Pose2d>()
    val trajectoryEndPoints = mutableListOf<Pose2d>()
    init {
        trajectoryStartPoints. add(Pose2d(Translation2d(4.21,69.98 ), Rotation2d(0.0)))
        trajectoryStartPoints.add(Pose2d(Translation2d(33.64,70.34),Rotation2d(0.0)))

        secondTrajectoryPoints.add(Pose2d(Translation2d(33.64,70.34), Rotation2d(90.0)))
        secondTrajectoryPoints.add(Pose2d(Translation2d(35.09,102.47), Rotation2d(90.0)))

        thirtdTrajectoryPoints.add(Pose2d(Translation2d(35.09,102.47), Rotation2d(0.0)))
        thirtdTrajectoryPoints.add(Pose2d(Translation2d(58.49,103.45), Rotation2d(0.0)))

        trajectoryEndPoints.add(Pose2d(Translation2d(58.49,103.45),Rotation2d(180.0)))
        trajectoryEndPoints.add(Pose2d(Translation2d(7.62,103.31),Rotation2d(180.0)))
    }
    object Trajectory{

        val trajectoryStart = TrajectoryGenerator.generateTrajectory(trajectoryStartPoints,
            TankDriveConstants.Autonomous.trajectoryConfig
        )
        val trajectorySecond = TrajectoryGenerator.generateTrajectory(
            secondTrajectoryPoints,
            TankDriveConstants.Autonomous.trajectoryConfig
        )

        val trajectoryThird = TrajectoryGenerator.generateTrajectory(
            thirtdTrajectoryPoints,
            TankDriveConstants.Autonomous.trajectoryConfig
        )
        val trajectoryEnd = TrajectoryGenerator.generateTrajectory(trajectoryEndPoints,
            TankDriveConstants.Autonomous.trajectoryConfig)
    }

}