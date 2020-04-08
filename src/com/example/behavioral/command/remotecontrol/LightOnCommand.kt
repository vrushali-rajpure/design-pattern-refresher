package com.example.behavioral.command.remotecontrol

class LightOnCommand(private val light: Light) : Command {

    override fun execute() {
        light.switchOn()
    }

}