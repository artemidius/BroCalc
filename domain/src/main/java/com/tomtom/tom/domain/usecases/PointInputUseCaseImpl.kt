package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.boundaries.PointInputUseCase
import com.tomtom.tom.domain.model.ScreenViewModel

class PointInputUseCaseImpl : PointInputUseCase {

    override fun run(screenViewModel: ScreenViewModel, presentationInteractor: Interactor.Presentation) = presentationInteractor.onScreenCleaned(handlePoint(screenViewModel))

    fun handlePoint(screenViewModel: ScreenViewModel):ScreenViewModel {
        val row = if (screenViewModel.upperRow.isActive) screenViewModel.upperRow else screenViewModel.lowerRow
        if (!row.currencyValue.contains(".")){
           if (row.showsInitialOne || row.currencyValue == "0") {
               row.showsInitialOne = false
               row.currencyValue = "0."
           }
           else if (row.currencyValue.length < 11) row.currencyValue = "${row.currencyValue}."
        }
        return screenViewModel
    }
}