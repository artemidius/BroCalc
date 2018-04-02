package com.tomtom.tom.domain

import com.tomtom.tom.domain.entities.Entities
import com.tomtom.tom.domain.model.CurrencyRow
import com.tomtom.tom.domain.model.ScreenViewModel
import com.tomtom.tom.domain.usecases.BackspaceUseCaseImpl
import com.tomtom.tom.domain.usecases.ClearScreenUseCaseImpl
import com.tomtom.tom.domain.usecases.NumberInputUseCaseImpl
import org.junit.Test

import org.junit.Assert.*

class ChangeCurrencyTest {

    @Test
    fun changeCurrencyWorks() {

        val clearModelOne = Entities().changeCurrency(
                1,
                1,
                arrayOf("EUR", "USD", "RUB", "GBP", "JPY"),
                ScreenViewModel(
                    CurrencyRow("USD", "12345", true),
                    CurrencyRow("RUB", "52")
        ))

        val clearModelTwo = Entities().changeCurrency(
                1,
                0,
                arrayOf("EUR", "USD", "RUB", "GBP", "JPY"),
                ScreenViewModel(
                    CurrencyRow("USD", "12345", true),
                    CurrencyRow("RUB", "52")
        ))


        assertEquals(true, clearModelOne.lowerRow.isActive)
        assertEquals(false, clearModelOne.upperRow.isActive)

        assertEquals("RUB", clearModelOne.upperRow.currencyType)
        assertEquals("USD", clearModelOne.lowerRow.currencyType)

        assertEquals("USD", clearModelTwo.upperRow.currencyType)
        assertEquals("EUR", clearModelTwo.lowerRow.currencyType)

    }
}