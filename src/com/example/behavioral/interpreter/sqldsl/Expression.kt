package com.example.behavioral.interpreter.sqldsl

interface Expression {
    fun interpret(cxt: Context): List<String>
}