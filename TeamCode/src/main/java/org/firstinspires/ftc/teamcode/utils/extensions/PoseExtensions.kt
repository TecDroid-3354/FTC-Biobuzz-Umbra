package org.firstinspires.ftc.teamcode.utils.extensions

import com.pedropathing.ftc.FTCCoordinates
import com.pedropathing.ftc.InvertedFTCCoordinates
import com.pedropathing.ftc.PoseConverter
import com.pedropathing.geometry.PedroCoordinates
import com.pedropathing.geometry.Pose
import com.seattlesolvers.solverslib.geometry.Pose2d
import com.seattlesolvers.solverslib.geometry.Rotation2d
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D

/**
 * Converts the [Pose] to Qualcomm's [Pose2D] in standard FTC Coordinates for square  or diamond fields like Into The Deep (2025).
 * Uses the [PoseConverter] in order to perform it.
 * @return a new [Pose2D] in inverted FTC Coordinates based of the receiver [Pose]
 */
fun Pose.toPose2D(): Pose2D {
    return PoseConverter.poseToPose2D(this, FTCCoordinates.INSTANCE)
}

/**
 * Converts the [Pose] to Qualcomm's [Pose2D] in inverted FTC Coordinates for square fields with swapped alliance areas and wall like Decode(2026).
 * Uses the [PoseConverter] in order to perform it.
 * @return a new [Pose2D] in inverted FTC Coordinates based of the receiver [Pose]
 */
fun Pose.toPose2DInverted(): Pose2D {
    return PoseConverter.poseToPose2D(this, InvertedFTCCoordinates.INSTANCE)
}

/**
 * Converts the [Pose2D] to Pedro Pathing's [Pose].
 * Uses the [PoseConverter] in order to perform it.
 * @return a new [Pose] based of the receiver [Pose2D]
 */
fun Pose2D.toPose(): Pose {
    return PoseConverter.pose2DToPose(this, PedroCoordinates.INSTANCE)
}

/**
 * Converts the [Pose2D] to a Solverslib [Pose2d]. Linear components will be passed in inches and angular components
 * in radians.
 * @return a new [Pose2d] based of the receiver [Pose2D]
 */
fun Pose2D.toPose2d(): Pose2d {
    return Pose2d(this.x, this.y, Rotation2d(this.h))
}

/**
 * Converts the given [Pose2d] from Solverslib to Qualcomm's [Pose2D].
 * The linear components will be passed in inches and the angular component will be passed in radians.
 * @return a new [Pose2D] based of the receiver [Pose2d]
 */
fun Pose2d.toPose2D(): Pose2D {
    return Pose2D(
        DistanceUnit.INCH,
        this.x,
        this.y,
        AngleUnit.RADIANS,
        this.rotation.radians
    )
}

/**
 * Gets the x component of the [Pose2D] in inches.
 */
val Pose2D.x : Double; get() = this.getX(DistanceUnit.INCH)
/**
 * Gets the y component of the [Pose2D] in inches.
 */
val Pose2D.y : Double; get() = this.getY(DistanceUnit.INCH)

/**
 * Gets the rotation component of the [Pose2D] in radians
 */
val Pose2D.h : Double ; get() = this.getHeading(AngleUnit.RADIANS)