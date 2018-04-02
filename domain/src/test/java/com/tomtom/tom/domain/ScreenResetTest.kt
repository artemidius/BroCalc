package com.tomtom.tom.domain

import com.tomtom.tom.domain.entities.Entities
import com.tomtom.tom.domain.model.CurrencyRow
import com.tomtom.tom.domain.model.ScreenViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class ScreenResetTest {

    @Test
    fun screenModelGetsClean() {
        val mockModel = ScreenViewModel(
                CurrencyRow("USD", "1"),
                CurrencyRow("RUB", "52")
        )

        val clearModel = Entities().clearViewModel(mockModel)

        assertEquals("0", clearModel.lowerRow.currencyValue)
        assertEquals("0", clearModel.upperRow.currencyValue)
        assertEquals("USD", clearModel.upperRow.currencyType)
        assertEquals("RUB", clearModel.lowerRow.currencyType)
    }
}