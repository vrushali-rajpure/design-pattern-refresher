package com.example.behavioral.chainofresponsibility.approver

fun main() {
    val director = Director()
    val vp = VP()
    val ceo = CEO()

    director.nextSuccessor(vp)
    vp.nextSuccessor(ceo)

    val conference = Request(
        RequestType.CONFERENCE,
        500
    )
    val purchaseOf1K = Request(
        RequestType.PURCHASE,
        1000
    )
    val purchaseOf2K = Request(
        RequestType.PURCHASE,
        2000
    )

    director.handleRequest(conference)
    director.handleRequest(purchaseOf1K)
    director.handleRequest(purchaseOf2K)
}