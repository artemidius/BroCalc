package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.boundaries.NumberInputUseCase
import com.tomtom.tom.domain.entities.Entities
import com.tomtom.tom.domain.model.ScreenViewModel

class NumberInputUseCaseImpl : NumberInputUseCase {

    override fun run(symbol:String, screenViewModel: ScreenViewModel, presentationInteractor: Interactor.Presentation, prefs: Interactor.Prefs) =
            presentationInteractor.onScreenUpdated(Entities().convertActive(Entities().handleInput(symbol, screenViewModel), prefs)
    )

}