package org.firstinspires.ftc.teamcode.subsystems.vision

import com.pedropathing.math.Matrix
import org.firstinspires.ftc.teamcode.subsystems.vision.VisionConstants.AprilTagUtilities.aprilTagFieldLayoutDecode
import org.firstinspires.ftc.teamcode.subsystems.vision.VisionConstants.AprilTagUtilities.ambiguity
import org.firstinspires.ftc.teamcode.subsystems.vision.VisionConstants.AprilTagUtilities.maxZError
import org.firstinspires.ftc.teamcode.constants.FieldConstants.FIELD_LENGTH
import org.firstinspires.ftc.teamcode.constants.FieldConstants.FIELD_WIDTH
import com.seattlesolvers.solverslib.command.SubsystemBase
import com.seattlesolvers.solverslib.geometry.Pose2d
import org.firstinspires.ftc.teamcode.utils.extensions.toPose3d
import org.psilynx.psikit.core.AutoLogOutputManager
import org.psilynx.psikit.core.wpi.math.Pose3d
import java.util.LinkedList
import kotlin.math.abs


class VisionSubsystem(private val visionConsumer: VisionConsumer, private vararg var io: VisionIO): SubsystemBase() {

    private var inputs = mutableListOf<VisionIO.VisionIOInputs>()

    init {
        for (index in io.indices) {
            inputs[index] = VisionIO.VisionIOInputs()
        }

        for (index in inputs.indices) {
            AutoLogOutputManager.addObject(inputs[index])
        }
    }

    override fun periodic() {
        for (cameraIndex in io.indices) {
            io[cameraIndex].updateInputs(inputs[cameraIndex])
        }

        val allTagPoses                     = LinkedList<Pose3d>()
        val allRobotPoses                   = LinkedList<Pose3d>()
        val allRobotPosesAccepted           = LinkedList<Pose3d>()
        val allRobotPosesRejected           = LinkedList<Pose3d>()

        for (cameraIndex in io.indices) {
            val tagPoses                    = LinkedList<Pose3d>()
            val robotPoses                  = LinkedList<Pose3d>()
            val robotPosesAccepted          = LinkedList<Pose3d>()
            val robotPosesRejected          = LinkedList<Pose3d>()

            for (tagId in inputs[cameraIndex].tagIds) {
                val tagPose = aprilTagFieldLayoutDecode.lookupTag(tagId).toPose3d()
                if (tagPose.isPresent) {
                    tagPoses.add(tagPose.get())
                }
            }

            for (observation in inputs[cameraIndex].poseObservations) {
                val rejectPose = observation.tagCount() == 0 // Must have at least one tag
                        || (observation.tagCount == 1 && observation.ambiguity() > ambiguity) // Cannot be to ambiguous
                        || abs(observation.pose.translation.z) > maxZError // Must have realistic z coordinates
                        // Must be within field boundaries
                        || observation.pose.translation.x < 0.0
                        || observation.pose.translation.x > FIELD_LENGTH.meters
                        || observation.pose.translation.y < 0.0
                        || observation.pose.translation.y > FIELD_WIDTH.meters


            }
        }
    }


    fun interface VisionConsumer {
        fun accept(
            visionRobotPoseMeters: Pose2d,
            timestampSeconds: Double,
            visionMeasurementStdDevs: Matrix
        )
    }
}