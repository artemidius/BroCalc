package com.tomtom.tom.domain.boundaries

import com.tomtom.tom.domain.model.ScreenViewModel

interface NumberInputUseCase {
    fun run(
            symbol:String,
            screenViewModel: ScreenViewModel,
            presentationInteractor: Interactor.Presentation
    )
}