package com.tomtom.tom.domain

import com.tomtom.tom.domain.model.ScreenViewModel
import com.tomtom.tom.domain.usecases.ClearScreenUseCaseImpl
import org.junit.Test

import org.junit.Assert.*

class ScreenResetTest {


    @Test
    fun screenModelGetsClean() {
        val mockModel = ScreenViewModel(
                "USD",
                "RUB",
                "1",
                "52")

        val clearModel = ClearScreenUseCaseImpl().clearViewModel(mockModel)

        assertEquals("0", clearModel.currencyValueUpper)
        assertEquals("0", clearModel.currencyValueLower)
        assertEquals("USD", clearModel.currencyTypeUpper)
        assertEquals("RUB", clearModel.currencyTypeLower)
    }


}