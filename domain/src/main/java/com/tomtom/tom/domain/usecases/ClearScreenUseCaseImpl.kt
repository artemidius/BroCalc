package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.ClearScreenUseCase
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.model.ScreenViewModel

class ClearScreenUseCaseImpl : ClearScreenUseCase {

    override fun run(screenViewModel: ScreenViewModel, presentationInteractor: Interactor.Presentation) = presentationInteractor.onScreenCleaned(clearViewModel(screenViewModel))

    fun clearViewModel(screenViewModel: ScreenViewModel):ScreenViewModel {
        screenViewModel.currencyValueUpper = "0"
        screenViewModel.currencyValueLower = "0"
        return screenViewModel
    }
}