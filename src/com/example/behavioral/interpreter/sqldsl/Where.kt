package com.example.behavioral.interpreter.sqldsl

//terminal expression
class Where(private val filter: (String)-> Boolean): Expression {
    override fun interpret(cxt: Context): List<String> {
        cxt.filter = filter
        return cxt.search()
    }
}

