package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.BackspaceUseCase
import com.tomtom.tom.domain.boundaries.ClearScreenUseCase
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.model.ScreenViewModel

class BackspaceUseCaseImpl : BackspaceUseCase {

    override fun run(screenViewModel: ScreenViewModel, presentationInteractor: Interactor.Presentation) = presentationInteractor.onScreenCleaned(clearViewModel(screenViewModel))

    fun clearViewModel(screenViewModel: ScreenViewModel):ScreenViewModel {
        screenViewModel.upperRow.currencyValue = "0"
        screenViewModel.lowerRow.currencyValue = "0"
        return screenViewModel
    }
}