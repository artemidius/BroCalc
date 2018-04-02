package com.tomtom.tom.domain

import com.tomtom.tom.domain.entities.Entities
import com.tomtom.tom.domain.model.CurrencyRow
import com.tomtom.tom.domain.model.ScreenViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class PointInputTest {

    @Test
    fun backspaseWorks() {

        val clearModelOne = Entities().handlePoint(
                ScreenViewModel(
                    CurrencyRow("USD", "12345", true),
                    CurrencyRow("RUB", "52")
        ))

        val clearModelTwo = Entities().handlePoint(
                ScreenViewModel(
                    CurrencyRow("USD", "11"),
                    CurrencyRow("RUB", "1", true, true)
        ))

        assertEquals("12345.", clearModelOne.upperRow.currencyValue)
        assertEquals(false, clearModelOne.upperRow.showsInitialOne)

        assertEquals("0.", clearModelTwo.lowerRow.currencyValue)
        assertEquals(false, clearModelTwo.lowerRow.showsInitialOne)

    }
}