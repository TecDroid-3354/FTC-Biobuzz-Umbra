package org.firstinspires.ftc.teamcode.subsystems.Subsystems.IntakePatita

import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.robocol.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.util.MathUtils
import org.firstinspires.ftc.teamcode.utils.Angle
import org.firstinspires.ftc.teamcode.utils.devices.OpServoEx

class IntakePatita (hardwareMap: HardwareMap){

    private val servopatita: OpServoEx
    private var intakeDeployTargetAngle: Angle = Angle (0.0)

    init {
        servopatita = OpServoEx(hardwareMap, IntakePatitaConstants.Identification.servoId)
        servopatita.applyConfiguration(IntakePatitaConstants.Configuration.leadServoConfiguration)
    }
    private fun setIntakeDeployAngle(angle: Angle) {
        intakeDeployTargetAngle = angle.coerceIn(IntakePatitaConstants.Mechanical.INTAKE_PATITA_LIMITS)

        servopatita.setServoPosition(angle)
    }

    fun IntakeDeployAngle(angle: Angle): Angle {
        val intakeDeployTargetAngleDeg = MathUtils.clamp(angle.degrees, IntakePatitaConstants.Mechanical.INTAKE_PATITA_LIMITS.start.degrees,
            IntakePatitaConstants.Mechanical.INTAKE_PATITA_LIMITS.endInclusive.degrees)
        intakeDeployTargetAngle = Angle.fromDegrees(intakeDeployTargetAngleDeg)

        servopatita.setServoPosition(intakeDeployTargetAngle)

        return intakeDeployTargetAngle
    }

    }




