package com.tomtom.tom.domain.usecases

import com.tomtom.tom.domain.boundaries.DownloadRatesUseCase
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.model.ApiResponse
import java.util.*
import java.util.concurrent.TimeUnit

class DownloadRatesUseCaseImpl : DownloadRatesUseCase {

    override fun run(api_key: String, backendInteractor: Interactor.Backend, presentationInteractor: Interactor.Presentation) {
//        backendInteractor.downloadRates(api_key)
//                .timeout(10000, TimeUnit.MILLISECONDS)
//                .retry (3)
//                .subscribe { response: ApiResponse?, error: Throwable? ->
//                    when {
////                        error != null -> presentationInteractor.onMoviesPageDownloadFailed(error)
////                        response == null -> presentationInteractor.onMoviesPageDownloadFailed(Throwable("Response was null"))
////                        else -> presentationInteractor.onMoviesPageDownloaded(response)
//                    }
//                }
    }
}