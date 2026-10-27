package org.firstinspires.ftc.teamcode.subsystems.Subsystems.IntakePatita

import com.pedropathing.ftc.drivetrains.SwerveConstants
import com.qualcomm.robotcore.hardware.DcMotor
import com.seattlesolvers.solverslib.hardware.motors.Motor
import org.firstinspires.ftc.teamcode.utils.Angle
import org.firstinspires.ftc.teamcode.utils.Voltage
import org.firstinspires.ftc.teamcode.utils.configurations.servoControlModeConfiguration.ServoPositionModeConfiguration
import org.firstinspires.ftc.teamcode.utils.configurations.servoControlModeConfiguration.ServoRunToPositionModeConfiguration

object IntakePatitaConstants {

    object Identification{
        val servoId: String = "ServoPatita"
    }

    object Mechanical {
        const val GEAR_RATIO = 1.0
        val TARGET_ANGLE_THRESHOLD = Angle.fromDegrees(20.0)
        val SERVO_RANGE = Angle.fromDegrees(270.0)
        val INTAKE_PATITA_LIMITS = Angle.fromDegrees(0.0) ..Angle(90.0)
    }

    object Configuration{
        private const val LEAD_SERVO_INVERTED: Boolean = false

        val leadServoConfiguration = ServoPositionModeConfiguration()
            .withRange(Mechanical.SERVO_RANGE)
            .withInverted(LEAD_SERVO_INVERTED)
    }
}