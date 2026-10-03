package org.firstinspires.ftc.teamcode.subsystems.Subsystems.ShooterRoller

import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.PIDCoefficients
import com.seattlesolvers.solverslib.hardware.motors.Motor
import org.firstinspires.ftc.teamcode.utils.AngularVelocity

object ShooterRollerConstans{
    object Identification {
        // Motorcito.exe
        const val RightMotorID = "rightMotor"
        const val LeftMotorID= "leftMotor"
    }

    object Velocity {
        //valores de potencia
        val shooter: AngularVelocity = AngularVelocity.fromRpm(3000.0)

    }
    object Configuration{
        val reduction: Double = 1.0
        val zeroPowerBehavior: Motor.ZeroPowerBehavior = Motor.ZeroPowerBehavior.FLOAT
        val runMode: Motor.RunMode = Motor.RunMode.VelocityControl
        val rightInverted = true
        val leftInverted = false
    }
    @Configurable
    object tunables{
        var pidCoefficients = PIDCoefficients(0.0,0.0,0.0)
    }
}