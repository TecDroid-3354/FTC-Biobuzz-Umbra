package org.firstinspires.ftc.teamcode.subsystems.Subsystems.Intake

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.motors.MotorEx

class Intake(val hardwareMap: HardwareMap) {
    private val motor: MotorEx

    init {
        motor = MotorEx(hardwareMap, IntakeConstants.Identification.intakeMotorID)
        motor.setZeroPowerBehavior(IntakeConstants.Configuration.zeroPowerBehavior)
        motor.setRunMode(IntakeConstants.Configuration.runMode)
        motor.setInverted(IntakeConstants.Configuration.isMotorInverted)
    }
    fun enableintake(){
        motor.set(1.0)
    }

    fun disableintake(){
        motor.set(0.0)
    }
   fun enableintakeCMD(): Command{
       return InstantCommand({enableintake()})
   }
    fun disableintakeCMD(): Command{
        return InstantCommand({disableintake()})
}

}
