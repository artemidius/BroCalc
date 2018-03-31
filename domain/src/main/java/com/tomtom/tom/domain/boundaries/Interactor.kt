package com.tomtom.tom.domain.boundaries

import com.tomtom.tom.domain.model.ApiResponse
import com.tomtom.tom.domain.model.ScreenViewModel
import io.reactivex.Single

interface Interactor {

    interface Presentation {
        fun onScreenCleaned(screenViewModel: ScreenViewModel)
    }

    interface Backend {
        fun downloadRates(api_key:String):Single<ApiResponse>
    }

}