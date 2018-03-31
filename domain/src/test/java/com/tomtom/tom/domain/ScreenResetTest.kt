package com.tomtom.tom.domain

import com.tomtom.tom.domain.model.CurrencyRow
import com.tomtom.tom.domain.model.ScreenViewModel
import com.tomtom.tom.domain.usecases.ClearScreenUseCaseImpl
import org.junit.Test

import org.junit.Assert.*

class ScreenResetTest {

    @Test
    fun screenModelGetsClean() {
        val mockModel = ScreenViewModel(
                CurrencyRow("USD", "1"),
                CurrencyRow("RUB", "52")
        )

        val clearModel = ClearScreenUseCaseImpl().clearViewModel(mockModel)

        assertEquals("0", clearModel.lowerRow.currencyValue)
        assertEquals("0", clearModel.upperRow.currencyValue)
        assertEquals("USD", clearModel.upperRow.currencyType)
        assertEquals("RUB", clearModel.lowerRow.currencyType)
    }
}