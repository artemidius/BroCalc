package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.BackspaceUseCase
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.boundaries.NumberInputUseCase
import com.tomtom.tom.domain.model.ScreenViewModel

class NumberInputUseCaseImpl : NumberInputUseCase {

    override fun run(symbol:String, screenViewModel: ScreenViewModel, presentationInteractor: Interactor.Presentation) = presentationInteractor.onScreenCleaned(handleInput(symbol, screenViewModel))

    fun handleInput(symbol:String, screenViewModel: ScreenViewModel):ScreenViewModel {
        val row = if (screenViewModel.upperRow.isActive) screenViewModel.upperRow else screenViewModel.lowerRow

        if(row.currencyValue.length < 12) {
            if (row.showsInitialOne || row.currencyValue == "0") {
                row.currencyValue = symbol
                row.showsInitialOne = false
            } else row.currencyValue = "${row.currencyValue}$symbol"
        }

        return screenViewModel
    }
}