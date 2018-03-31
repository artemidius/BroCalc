package com.tomtom.tom.domain

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {


    @Test
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    fun conv() {
        val USD = 1.232735f
        val RUB = 70.409776f
        System.out.println(convertCurrency(USD, RUB))
        assertEquals(57.116714f, convertCurrency(USD, RUB))
    }

    fun convertCurrency(oneUnit:Float, convertTo:Float):Float {
        return convertTo / oneUnit
    }
}