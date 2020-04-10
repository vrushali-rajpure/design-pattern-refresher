package com.example.behavioral.interpreter.sqldsl

fun main() {
    val query = Select("name", From("people"))
    val ctx = Context()
    val result = query.interpret(ctx)
    println("----------------------------")
    println(result)

    val query2 = Select("*", From("people"))
    val result2 = query2.interpret(ctx)
    println("----------------------------")
    println(result2)

    val query3 = Select(
        "name",
        From("people",
            Where { name: String ->
                name.toLowerCase().startsWith("d")
            }
        )
    )
    val result3 = query3.interpret(ctx)
    println("----------------------------")
    println(result3)
}