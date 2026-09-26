package org.firstinspires.ftc.teamcode.subsystems.Subsystems.Catapult


import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.SubsystemBase
import com.seattlesolvers.solverslib.hardware.motors.MotorEx
import org.firstinspires.ftc.robotcore.external.navigation.Velocity
import org.firstinspires.ftc.teamcode.utils.AngularVelocity


abstract class Catapult(hardwareMap: HardwareMap): SubsystemBase() {
    private val rightMotor: MotorEx
    private val leftMotor: MotorEx = MotorEx(hardwareMap, CatapultConstants.Identification.leftMotorID)


    init {
        leftMotor.setInverted(CatapultConstants.Configuration.leftInverted)
        leftMotor.setRunMode(CatapultConstants.Configuration.runMode)
        leftMotor.setZeroPowerBehavior(CatapultConstants.Configuration.zeroPowerBehavior)




        rightMotor = MotorEx(hardwareMap, CatapultConstants.Identification.rightMotorID)
        rightMotor.setInverted(CatapultConstants.Configuration.rightInverted)
        rightMotor.setRunMode(CatapultConstants.Configuration.runMode)
        rightMotor.setZeroPowerBehavior(CatapultConstants.Configuration.zeroPowerBehavior)
    }


    private fun setVelocity(velocity: AngularVelocity){
        val limitedVelocity=velocity.rps.coerceIn(-100.00,100.00)
        val velocityInTicks=limitedVelocity * 28.0
        rightMotor.velocity= velocityInTicks
        leftMotor.velocity= velocityInTicks
    }
    fun getVelocity(): AngularVelocity{
        return AngularVelocity(rightMotor.velocity/28.0)
    }


    abstract fun angulos (angulos: Double): Unit
}
