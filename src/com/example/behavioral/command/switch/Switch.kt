package com.example.behavioral.command.switch

import com.example.behavioral.command.remotecontrol.Command

//Invoker
class Switch {
    fun storeAndExecute(command: Command) {
        command.execute()
    }
}