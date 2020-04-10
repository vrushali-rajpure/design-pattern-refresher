package com.example.behavioral.command

fun main() {


    val task1 = Task(2, 3);

    val thread = Thread(task1)
    thread.start()  // invoker

    val originalMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)

    val predicate: (Map.Entry<String, Int>) -> Boolean = { it.value < 2 }
    val filteredMap = originalMap.filter(predicate)
}

// Runnable : Command Interface, Task : Concrete Command
class Task(private val num1: Int, private val num2: Int) : Runnable {

    override fun run() { // execute method of command
        println("run method ${num1 * num2}") // receiver object
    }

}