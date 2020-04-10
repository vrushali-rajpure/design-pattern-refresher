package com.example.behavioral.interpreter.sqldsl

//non-terminal expression.
class From(private val table: String) : Expression {

    var where: Where? = null

    constructor(table: String, where: Where) : this(table) {
        this.where = where
    }

    override fun interpret(cxt: Context): List<String> {
        cxt.table = table
        return where?.interpret(cxt) ?: cxt.search()
    }

}