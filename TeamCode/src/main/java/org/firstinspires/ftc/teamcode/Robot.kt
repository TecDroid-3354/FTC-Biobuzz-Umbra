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
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.IntakePatita.IntakePatita
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.IntakePatita.IntakePatitaConstants
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.ShooterRoller.ShooterRoller
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.Systems.Superstructure

import org.firstinspires.ftc.teamcode.utils.Alliance
import org.firstinspires.ftc.teamcode.utils.AngularVelocity
import org.firstinspires.ftc.teamcode.utils.TecDroidRobot
import org.firstinspires.ftc.teamcode.utils.extensions.onFalse
import org.firstinspires.ftc.teamcode.utils.extensions.onTrue
import org.firstinspires.ftc.teamcode.utils.extensions.rightTrigger
import org.firstinspires.ftc.teamcode.utils.extensions.a
import org.firstinspires.ftc.teamcode.utils.extensions.b
import org.firstinspires.ftc.teamcode.utils.extensions.onFalse
import org.firstinspires.ftc.teamcode.utils.extensions.onTrue
import org.firstinspires.ftc.teamcode.utils.extensions.x
import org.firstinspires.ftc.teamcode.utils.extensions.y


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
    lateinit var intakePatita : IntakePatita
  lateinit var intake: Intake
  val superstructure: Superstructure

    init {
        superstructure = Superstructure(hardwareMap)
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
            .onTrue (InstantCommand({ superstructure.intakePollenSequence() }))
            .onFalse  (InstantCommand( { superstructure.stopIntakePollenSequence() } ))
        controller.rightTrigger()
            .onTrue (InstantCommand({ superstructure.shootSequence()}))
            .onFalse  (InstantCommand( { superstructure.stopShootSequence()}))
        controller.b()
            .onTrue(InstantCommand({superstructure.raisePatitaCMD()}))
            .onFalse(InstantCommand({superstructure.closePatitaCMD()}))
        controller.x()
            .onTrue(InstantCommand({superstructure.enableintakeCMD()}))
            .onFalse(InstantCommand({superstructure.disableintakeCMD()}))
        controller.y()
            .onTrue(InstantCommand({superstructure.enableCatapultCMD()}))
            .onFalse(InstantCommand({superstructure.disableCatapultCMD()}))
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
