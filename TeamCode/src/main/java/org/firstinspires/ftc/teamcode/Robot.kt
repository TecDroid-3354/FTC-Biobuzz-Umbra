package org.firstinspires.ftc.teamcode

import com.pedropathing.follower.Follower
import com.pedropathing.geometry.Pose
import com.pedropathing.paths.PathChain
import com.pedropathing.paths.PathPoint
import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.gamepad.GamepadEx
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.Intake.Intake
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.ShooterRoller.ShooterRoller

import org.firstinspires.ftc.teamcode.utils.Alliance
import org.firstinspires.ftc.teamcode.utils.AngularVelocity
import org.firstinspires.ftc.teamcode.utils.TecDroidRobot
import org.firstinspires.ftc.teamcode.utils.extensions.onFalse
import org.firstinspires.ftc.teamcode.utils.extensions.onTrue
import org.firstinspires.ftc.teamcode.utils.extensions.rightTrigger
import org.firstinspires.ftc.teamcode.utils.extensions.a
import org.firstinspires.ftc.teamcode.utils.extensions.onFalse
import org.firstinspires.ftc.teamcode.utils.extensions.onTrue


class Robot(
    private val alliance: Alliance,
    private val hardwareMap: HardwareMap,
    private val controller: GamepadEx,
    telemetry: Telemetry
): TecDroidRobot(telemetry, hardwareMap) {

    /* Declare your Pedro Pathing's Follower here */
    private lateinit var follower: Follower
    /* Declare your subsystems here */
    lateinit var shooterRoller: ShooterRoller

  lateinit var intake: Intake
    init {

        subsystemInitialization()
    }

    /* Initialize your subsystems and follower here */
    override fun subsystemInitialization() {
        // Follower initialization

        // Subsystem initialization
    }

    /* Runs indefinitely after the init button on the DS is pressed. Stops when play button is pressed */
    override fun initLoop() {}

    /* Initialize your teleop controller commands here */
    override fun initTeleOp() {
        // Chassis default command

        // Build Commands:
        // controller.button().onTrue(Command)
        controller.a()
            .onTrue (InstantCommand({ intake.enableintake() }))
            .onFalse  (InstantCommand( { intake.disableintake() } ))
        controller.rightTrigger()
            .onTrue (shooterRoller.setShooterVelocityCMD(AngularVelocity.fromRps(33.0)))
            .onFalse (shooterRoller.setShooterVelocityCMD(AngularVelocity.fromRps(0.0)))
    // ese valor no ah sido probado
    }

    /* Initialize your auto commands here, set chassis alliance and starting pose */
    override fun initAuto(startingPose: Pose) {

    }

    /* When the teleop ends, declare what to do */
    override fun onEnd() {

    }

    /* Print telemetry using the pTelemetry object on RobotConstants.Telemetry. It will be printed on both Panels and Driver Hub */
    override fun printTelemetry() {

    }

    /**
     * @return the Pedro's Follower
     */
    override fun getFollower(): Follower { return follower }

    /* Common method to follow any path */
    override fun followPathCMD(path: PathChain, holdEnd: Boolean, maxPower: Double): Command {
        return TODO() //Yet to be implemented
    }




}
