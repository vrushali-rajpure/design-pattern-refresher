package com.example.behavioral.command.remotecontrol

//Invoker
class RemoteControl() {
    private lateinit var command: Command

    fun pressButton() {
        command.execute()
    }

    fun setCommand(command: Command) {
        this.command = command
    }
}