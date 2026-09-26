package org.firstinspires.ftc.teamcode.subsystems.Subsystems.Intake

import com.qualcomm.robotcore.hardware.DcMotor
import com.seattlesolvers.solverslib.hardware.motors.Motor

object IntakeConstants {
    object Identification {
        val intakeMotorID = "intakemotor"
    }

    object Configuration{
         val isMotorInverted: Boolean = true
        val zeroPowerBehavior: Motor.ZeroPowerBehavior = Motor.ZeroPowerBehavior.FLOAT
        val runMode: Motor.RunMode = Motor.RunMode.RawPower
        }
    }
