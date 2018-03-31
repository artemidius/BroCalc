package com.tomtom.tom.domain.boundaries

interface DownloadRatesUseCase {
    fun run(
            api_key: String,
            backendInteractor: Interactor.Backend,
            presentationInteractor: Interactor.Presentation
    )
}