package com.example.behavioral.chainofresponsibility.approver

class Request(val requestType: RequestType, val amount: Int)

enum class RequestType {
    CONFERENCE,
    PURCHASE,
}
