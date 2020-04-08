package com.example.behavioral.command.remotecontrol

//Receiver
class Light(private var on: Boolean) {

    fun switchOn() {
        on = true;
    }

    fun switchOff() {
        on = false;
    }
}
