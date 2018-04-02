package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.ChangeCurrencyUseCase
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.entities.Entities
import com.tomtom.tom.domain.model.ScreenViewModel

class ChangeCurrencyUseCaseImpl : ChangeCurrencyUseCase {

    override fun run(
            row:Int,
            index: Int,
            currencies: Array<String>,
            screenViewModel: ScreenViewModel,
            presentationInteractor: Interactor.Presentation,
            prefs: Interactor.Prefs) =
            presentationInteractor.updateScreen(Entities().convertActive(Entities().changeCurrency(row, index, currencies, screenViewModel), prefs)
            )
}