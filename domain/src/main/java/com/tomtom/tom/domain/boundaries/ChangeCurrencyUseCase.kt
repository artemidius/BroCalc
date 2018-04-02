package com.tomtom.tom.domain.boundaries

import com.tomtom.tom.domain.model.ScreenViewModel

interface ChangeCurrencyUseCase {
    fun run(
            row: Int,
            index: Int,
            currencies: Array<String>,
            screenViewModel: ScreenViewModel,
            presentationInteractor: Interactor.Presentation,
            prefs: Interactor.Prefs
    )
}