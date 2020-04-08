package com.example.behavioral.chainofresponsibility.approver

class Director() : Handler {
    private lateinit var nextHandler: Handler
    override fun nextSuccessor(handler: Handler) {
        nextHandler = handler
    }

    override fun handleRequest(request: Request) {
        when (request.requestType) {
            RequestType.CONFERENCE -> println("Directors can approve conference")
            else -> nextHandler.handleRequest(request)

        }
    }
}

class VP() : Handler {
    private lateinit var nextHandler: Handler
    override fun nextSuccessor(handler: Handler) {
        nextHandler = handler
    }


    override fun handleRequest(request: Request) {
        when {
            request.requestType == RequestType.PURCHASE
                    && request.amount < 1500 -> println("VP can approve purchases below 1500")
            else -> nextHandler.handleRequest(request)
        }
    }
}

class CEO() : Handler {

    override fun nextSuccessor(handler: Handler) {
    }

    override fun handleRequest(request: Request) {
        println("CEOs can approve anything")
    }
}