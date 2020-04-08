package com.example.behavioral.chainofresponsibility.approver

interface Handler {
    fun nextSuccessor(handler: Handler)
    fun handleRequest(request: Request)
}

// TODO : how this can be fixed
object  WithSuccessorHandler : Handler {
    private lateinit var nextHandler: Handler
    override fun nextSuccessor(handler: Handler) {
        nextHandler = handler
    }

    override fun handleRequest(request: Request) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

object  WithoutSuccessorHandler : Handler {
    override fun nextSuccessor(handler: Handler) {
    }

    override fun handleRequest(request: Request) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}