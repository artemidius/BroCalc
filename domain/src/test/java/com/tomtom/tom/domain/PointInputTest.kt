package com.tomtom.tom.domain

import com.tomtom.tom.domain.model.CurrencyRow
import com.tomtom.tom.domain.model.ScreenViewModel
import com.tomtom.tom.domain.usecases.BackspaceUseCaseImpl
import com.tomtom.tom.domain.usecases.ClearScreenUseCaseImpl
import com.tomtom.tom.domain.usecases.NumberInputUseCaseImpl
import com.tomtom.tom.domain.usecases.PointInputUseCaseImpl
import org.junit.Test

import org.junit.Assert.*

class PointInputTest {

    @Test
    fun backspaseWorks() {

        val clearModelOne = PointInputUseCaseImpl().handlePoint(
                ScreenViewModel(
                    CurrencyRow("USD", "12345", true),
                    CurrencyRow("RUB", "52")
        ))

        val clearModelTwo = PointInputUseCaseImpl().handlePoint(
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