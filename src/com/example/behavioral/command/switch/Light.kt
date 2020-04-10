package com.example.behavioral.command.switch

//Receiver
class Light(var isOn: Boolean) {
    fun toggle() {
        when (isOn) {
            true -> off()
            else -> on()
        }
    }

    private fun on() {
        isOn = true;
        println("Light on")
    }

    private fun off() {
        isOn = false;
        println("Light off")
    }
}