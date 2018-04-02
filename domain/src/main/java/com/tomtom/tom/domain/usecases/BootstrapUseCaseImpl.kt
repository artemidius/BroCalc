package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.BootstrapUseCase
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.model.ApiResponse
import java.util.concurrent.TimeUnit

class BootstrapUseCaseImpl : BootstrapUseCase {

    override fun run(api_key: String, backendInteractor: Interactor.Backend, presentationInteractor: Interactor.Presentation, prefsInteractor: Interactor.Prefs) {

        if (prefsInteractor.localStorageHasSomeRates()) presentationInteractor.activate()
        else presentationInteractor.showProgressIndicator()

        backendInteractor.downloadRates(api_key)
                .subscribe { response: ApiResponse?, error: Throwable? ->
                    when {
                        error != null -> {
                            if(prefsInteractor.localStorageHasSomeRates()) error.printStackTrace()
                            else presentationInteractor.onDownloadFail()
                        }
                        response != null -> {
                            System.out.println(response.base)
                            prefsInteractor.writeString("EUR", "1")
                            prefsInteractor.writeString("USD", response.rates.USD)
                            prefsInteractor.writeString("RUB", response.rates.RUB)
                            prefsInteractor.writeString("GBP", response.rates.GBP)
                            prefsInteractor.writeString("JPY", response.rates.JPY)
                            prefsInteractor.writeBoolean("valuesInitialized", true)
                            presentationInteractor.activate()
                        }
                    }
                }
    }
}