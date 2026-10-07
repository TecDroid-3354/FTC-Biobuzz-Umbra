package org.firstinspires.ftc.teamcode.subsystems.Subsystems.Catapult


import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.SubsystemBase
import com.seattlesolvers.solverslib.hardware.motors.MotorEx
import org.firstinspires.ftc.robotcore.external.navigation.Velocity
import org.firstinspires.ftc.teamcode.utils.AngularVelocity


abstract class Catapult(hardwareMap: HardwareMap): SubsystemBase() {

    private val rightMotor: MotorEx
    private val leftMotor: MotorEx


    init {
        leftMotor=  MotorEx(hardwareMap, CatapultConstants.Identification.leftMotorID)
        leftMotor.setInverted(CatapultConstants.Configuration.leftInverted)
        leftMotor.setRunMode(CatapultConstants.Configuration.runMode)
        leftMotor.setZeroPowerBehavior(CatapultConstants.Configuration.zeroPowerBehavior)


        rightMotor = MotorEx(hardwareMap, CatapultConstants.Identification.rightMotorID)
        rightMotor.setInverted(CatapultConstants.Configuration.rightInverted)
        rightMotor.setRunMode(CatapultConstants.Configuration.runMode)
        rightMotor.setZeroPowerBehavior(CatapultConstants.Configuration.zeroPowerBehavior)
    }


    private fun setVelocity (velocity: AngularVelocity){
        val limitedVelocity=velocity.rps.coerceIn(-100.00,100.00)
        val velocityInTicks=limitedVelocity * 28.0
        rightMotor.velocity= velocityInTicks
        leftMotor.velocity= velocityInTicks


        }

    fun getVelocity(): AngularVelocity{
        return AngularVelocity(leftMotor.velocity/28.0)
    }

    fun returnToOrigin(){
        rightMotor.setTargetPosition(CatapultConstants.Positions.returnPosition)
        rightMotor.setTargetPosition(CatapultConstants.Positions.returnPosition)
        leftMotor.setTargetPosition(CatapultConstants.Positions.returnPosition)
        leftMotor.setTargetPosition(CatapultConstants.Positions.returnPosition)
    }
    fun shoot(){
setVelocity(AngularVelocity(15.0))//la velocidad no esta definida
        rightMotor.setTargetPosition(CatapultConstants.Positions.shootPosition)
        leftMotor.setTargetPosition(CatapultConstants.Positions.shootPosition)

    }
}




