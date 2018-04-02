package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.ClearScreenUseCase
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.entities.Entities
import com.tomtom.tom.domain.model.ScreenViewModel

class ClearScreenUseCaseImpl : ClearScreenUseCase {

    override fun run(screenViewModel: ScreenViewModel, presentationInteractor: Interactor.Presentation) = presentationInteractor.updateScreen(Entities().clearViewModel(screenViewModel))

}