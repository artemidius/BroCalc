package com.tomtom.tom.domain

import com.tomtom.tom.domain.entities.Entities
import com.tomtom.tom.domain.model.CurrencyRow
import com.tomtom.tom.domain.model.ScreenViewModel
import com.tomtom.tom.domain.usecases.BackspaceUseCaseImpl
import com.tomtom.tom.domain.usecases.ClearScreenUseCaseImpl
import org.junit.Test

import org.junit.Assert.*

class BackspaseTest {

    @Test
    fun backspaseWorks() {

        val clearModelOne = Entities().handleBackspace(
                ScreenViewModel(
                    CurrencyRow("USD", "12345", true),
                    CurrencyRow("RUB", "52")
        ))

        val clearModelTwo = Entities().handleBackspace(
                ScreenViewModel(
                    CurrencyRow("USD", "11"),
                    CurrencyRow("RUB", "1", true, true)
        ))

        assertEquals("1234", clearModelOne.upperRow.currencyValue)
        assertEquals(false, clearModelOne.upperRow.showsInitialOne)

        assertEquals("0", clearModelTwo.lowerRow.currencyValue)
        assertEquals(false, clearModelTwo.upperRow.showsInitialOne)

    }
}