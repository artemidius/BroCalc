package com.tomtom.tom.domain.model

class ApiResponse (
        val base:String,
        val timestamp:Long,
        val rates:Rates
)

class Rates (
    val USD:String,
    val RUB:String,
    val GBP:String,
    val JPY:String
)
