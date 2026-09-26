package org.firstinspires.ftc.teamcode.subsystems.Subsystems.Catapult


import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.PIDCoefficients
import com.seattlesolvers.solverslib.controller.wpilibcontroller.SimpleMotorFeedforward
import com.seattlesolvers.solverslib.hardware.motors.Motor


object CatapultConstants {


    object Identification {
        val rightMotorID = "Motor1"
        val leftMotorID = "Motor2"
    }


    object Configuration {
        val runMode = Motor.RunMode.PositionControl
        val zeroPowerBehavior = Motor.ZeroPowerBehavior.FLOAT
        val rightInverted = true
        val leftInverted = false
    }
}
