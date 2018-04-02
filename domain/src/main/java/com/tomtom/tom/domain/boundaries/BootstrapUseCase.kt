package com.tomtom.tom.domain.boundaries

interface BootstrapUseCase {
    fun run(
            api_key: String,
            backendInteractor: Interactor.Backend,
            presentationInteractor: Interactor.Presentation,
            prefsInteractor: Interactor.Prefs
    )
}