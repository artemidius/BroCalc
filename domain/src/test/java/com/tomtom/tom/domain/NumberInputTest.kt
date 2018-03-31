package com.tomtom.tom.domain

import com.tomtom.tom.domain.model.CurrencyRow
import com.tomtom.tom.domain.model.ScreenViewModel
import com.tomtom.tom.domain.usecases.BackspaceUseCaseImpl
import com.tomtom.tom.domain.usecases.ClearScreenUseCaseImpl
import com.tomtom.tom.domain.usecases.NumberInputUseCaseImpl
import org.junit.Test

import org.junit.Assert.*

class NumberInputTest {

    @Test
    fun backspaseWorks() {

        val clearModelOne = NumberInputUseCaseImpl().handleInput("1",
                ScreenViewModel(
                    CurrencyRow("USD", "12345", true),
                    CurrencyRow("RUB", "52")
        ))

        val clearModelTwo = NumberInputUseCaseImpl().handleInput("5",
                ScreenViewModel(
                    CurrencyRow("USD", "11"),
                    CurrencyRow("RUB", "1", true, true)
        ))

        assertEquals("123451", clearModelOne.upperRow.currencyValue)
        assertEquals(false, clearModelOne.upperRow.showsInitialOne)

        assertEquals("5", clearModelTwo.lowerRow.currencyValue)
        assertEquals(false, clearModelTwo.upperRow.showsInitialOne)

    }
}