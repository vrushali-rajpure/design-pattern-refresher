package com.example.behavioral.command.switch

fun main() {
    val light = Light(false)
    val command = ToggleCommand(light)
    val switch = Switch()

    switch.storeAndExecute(command)
    switch.storeAndExecute(command)
    switch.storeAndExecute(command)
}