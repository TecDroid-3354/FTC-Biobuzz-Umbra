package org.firstinspires.ftc.teamcode.subsystems.Subsystems.Systems

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.command.SequentialCommandGroup
import com.seattlesolvers.solverslib.gamepad.GamepadEx
import com.seattlesolvers.solverslib.hardware.motors.MotorEx
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.Catapult.Catapult
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.Catapult.CatapultConstants
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.Intake.Intake
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.Intake.IntakeConstants
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.IntakePatita.IntakePatita
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.IntakePatita.IntakePatitaConstants
import org.firstinspires.ftc.teamcode.subsystems.Subsystems.ShooterRoller.ShooterRoller
import org.firstinspires.ftc.teamcode.utils.AngularVelocity
import org.firstinspires.ftc.teamcode.utils.devices.OpServoEx
import org.firstinspires.ftc.teamcode.utils.extensions.a
import org.firstinspires.ftc.teamcode.utils.extensions.b
import org.firstinspires.ftc.teamcode.utils.extensions.onFalse
import org.firstinspires.ftc.teamcode.utils.extensions.onTrue

class Superstructure (val hardwareMap: HardwareMap) {

    lateinit var catapult: Catapult
    lateinit var intakePatita: IntakePatita
    lateinit var intake: Intake

    init {

        catapult = Catapult(hardwareMap)
        intakePatita = IntakePatita(hardwareMap)
        intake = Intake(hardwareMap)
    }

    fun enableintakeCMD(): Command {
        return InstantCommand({ intake.enableintake() })
    }
    fun disableintakeCMD(): Command {
        return InstantCommand({ intake.disableintake() })

    }
    fun raisePatitaCMD(): Command {
        return InstantCommand({ intakePatita.IntakeDeployAngle(IntakePatitaConstants.Mechanical.DEPLOY_ANGLE) })
    }

    fun closePatitaCMD(): Command {
        return InstantCommand({ intakePatita.IntakeDeployAngle(IntakePatitaConstants.Mechanical.UNLOADED_ANGLE) })
    }

    fun intakePollenSequence(): SequentialCommandGroup {
        return SequentialCommandGroup(
            raisePatitaCMD(),
            enableintakeCMD()
        )
    }
    fun stopIntakePollenSequence(): SequentialCommandGroup {
        return SequentialCommandGroup(closePatitaCMD(), disableintakeCMD())
    }
    fun setVelocity(velocity: AngularVelocity){
    }
    fun enableCatapultCMD() : Command {
        return InstantCommand({ catapult.setVelocity(AngularVelocity.fromRps(33.0))})
    }
    fun disableCatapultCMD() : Command {
        return InstantCommand({ catapult.setVelocity(AngularVelocity.fromRps(0.0))})
    }
    fun shootSequence (): SequentialCommandGroup{
        return SequentialCommandGroup(enableintakeCMD(),enableCatapultCMD())
    }
    fun stopShootSequence(): SequentialCommandGroup{
        return SequentialCommandGroup(disableintakeCMD(),disableCatapultCMD())
    }

}






