package com.example.behavioral.command.remotecontrol

class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.switchOff()
    }
}