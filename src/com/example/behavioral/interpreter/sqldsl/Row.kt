package com.example.behavioral.interpreter.sqldsl

class Row(private val name: String, private val surname: String) {
    override fun toString(): String {
        return "$name $surname"
    }
}