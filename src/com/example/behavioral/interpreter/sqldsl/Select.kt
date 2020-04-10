package com.example.behavioral.interpreter.sqldsl

class Select(private val column: String, private val from: From) : Expression {

    override fun interpret(cxt: Context): List<String> {
        cxt.column = column
        return from.interpret(cxt);
    }


}