package com.example.behavioral.command.remotecontrol

import java.awt.SystemColor.control


fun main() {
    val remoteControl = RemoteControl()
    val light = Light(false)
    val lightsOn: Command = LightOnCommand(light)
    val lightsOff: Command = LightOffCommand(light)
    //switch on

    remoteControl.setCommand(lightsOn)
    remoteControl.pressButton()
    //switch off

    remoteControl.setCommand(lightsOff)
    remoteControl.pressButton()
}