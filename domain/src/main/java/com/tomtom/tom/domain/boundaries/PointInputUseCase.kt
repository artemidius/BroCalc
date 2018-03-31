package com.tomtom.tom.domain.boundaries

import com.tomtom.tom.domain.model.ScreenViewModel

interface PointInputUseCase {
    fun run(
            screenViewModel: ScreenViewModel,
            presentationInteractor: Interactor.Presentation
    )
}