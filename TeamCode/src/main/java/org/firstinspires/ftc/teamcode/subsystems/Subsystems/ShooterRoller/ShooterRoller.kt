package org.firstinspires.ftc.teamcode.subsystems.Subsystems.ShooterRoller

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.motors.MotorEx
import org.firstinspires.ftc.teamcode.utils.AngularVelocity
import org.firstinspires.ftc.teamcode.utils.extensions.setVelocityCoefficients

class ShooterRoller(val hardwareMap: HardwareMap) {

    private val leftMotor: MotorEx
    private val rightMotor: MotorEx

    init {
        leftMotor = MotorEx(hardwareMap, ShooterRollerConstans.Identification.LeftMotorID)
        leftMotor.setInverted(ShooterRollerConstans.Configuration.leftInverted)
        leftMotor. setZeroPowerBehavior(ShooterRollerConstans.Configuration.zeroPowerBehavior)
        leftMotor. setRunMode(ShooterRollerConstans.Configuration.runMode)
        leftMotor.setVelocityCoefficients(ShooterRollerConstans.tunables.pidCoefficients)

        rightMotor = MotorEx(hardwareMap, ShooterRollerConstans.Identification.RightMotorID)
        rightMotor. setInverted(ShooterRollerConstans.Configuration.rightInverted)
        rightMotor. setZeroPowerBehavior(ShooterRollerConstans.Configuration.zeroPowerBehavior)
        rightMotor. setRunMode(ShooterRollerConstans.Configuration.runMode)
        rightMotor.setVelocityCoefficients(ShooterRollerConstans.tunables.pidCoefficients)

    }
    fun setShooterVelocity(subsystemVelocity: AngularVelocity) {
        val motorVelocity: AngularVelocity = subsystemVelocity.times(ShooterRollerConstans.Configuration.reduction)
        leftMotor.setVelocity(motorVelocity.rps / 28.0)
        rightMotor.setVelocity(motorVelocity.rps / 28.0)
    }
    fun stopShooter(){
        leftMotor.stopMotor()
        rightMotor.stopMotor()
    }
    fun setShooterVelocityCMD(subsystemVelocity: AngularVelocity): Command {
        return InstantCommand({setShooterVelocity(subsystemVelocity)})

        }
    fun stopShooterCMD(): Command{
        return InstantCommand( {stopShooter()})
        }
}