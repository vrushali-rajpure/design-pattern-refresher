package com.example.behavioral.command.switch

import com.example.behavioral.command.remotecontrol.Command

//Concrete Command
class ToggleCommand(private val light: Light) : Command {
    override fun execute() {
        light.toggle()
    }
}