package com.tomtom.tom.domain.boundaries

import com.tomtom.tom.domain.model.ScreenViewModel

interface BackspaceUseCase {
    fun run(
            screenViewModel: ScreenViewModel,
            presentationInteractor: Interactor.Presentation,
            prefs: Interactor.Prefs
    )
}