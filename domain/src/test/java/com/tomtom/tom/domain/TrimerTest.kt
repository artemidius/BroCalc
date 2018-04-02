package com.tomtom.tom.domain

import com.tomtom.tom.domain.entities.Entities
import org.junit.Assert.assertEquals
import org.junit.Test

class TrimerTest {

    @Test
    fun trimFloatTest() {

        val mockFloat1 = "3.30"
        val mockFloat2 = "3.00"
        assertEquals("3.3", Entities().trimFloat(mockFloat1))
        assertEquals("3", Entities().trimFloat(mockFloat2))

    }
}