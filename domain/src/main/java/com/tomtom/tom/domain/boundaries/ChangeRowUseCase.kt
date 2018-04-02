package com.tomtom.tom.domain.boundaries

import com.tomtom.tom.domain.model.ScreenViewModel

interface ChangeRowUseCase {
    fun run(
            index:Int,
            screenViewModel: ScreenViewModel,
            presentationInteractor: Interactor.Presentation,
            prefs: Interactor.Prefs
    )
}