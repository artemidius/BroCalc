package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.ChangeRowUseCase
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.entities.Entities
import com.tomtom.tom.domain.model.ScreenViewModel

class ChangeRowUseCaseImpl : ChangeRowUseCase {

    override fun run(index:Int, screenViewModel: ScreenViewModel, presentationInteractor: Interactor.Presentation, prefs: Interactor.Prefs) =
            presentationInteractor.onScreenUpdated(
                    Entities().convertActive(Entities().changeActiveRow(index, screenViewModel), prefs)
            )

}