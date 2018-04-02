package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.BackspaceUseCase
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.entities.Entities
import com.tomtom.tom.domain.model.ScreenViewModel

class BackspaceUseCaseImpl : BackspaceUseCase {

    override fun run(screenViewModel: ScreenViewModel, presentationInteractor: Interactor.Presentation, prefs: Interactor.Prefs) =
            presentationInteractor.updateScreen(Entities().convertActive(Entities().handleBackspace(screenViewModel), prefs))

}