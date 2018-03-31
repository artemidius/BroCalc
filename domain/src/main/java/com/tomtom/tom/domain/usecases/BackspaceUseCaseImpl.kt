package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.BackspaceUseCase
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.model.ScreenViewModel

class BackspaceUseCaseImpl : BackspaceUseCase {

    override fun run(screenViewModel: ScreenViewModel, presentationInteractor: Interactor.Presentation) = presentationInteractor.onScreenCleaned(handleBackspace(screenViewModel))

    fun handleBackspace(screenViewModel: ScreenViewModel):ScreenViewModel {
        val row = if (screenViewModel.upperRow.isActive) screenViewModel.upperRow else screenViewModel.lowerRow
        if(row.currencyValue.length > 1) row.currencyValue = row.currencyValue.dropLast(1)
        else {
            row.showsInitialOne = false
            row.currencyValue = "0"
        }
        return screenViewModel
    }
}