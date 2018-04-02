package com.tomtom.tom.data

import com.tomtom.tom.data.backend.retrofit.RetrofitHelper
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.model.ApiResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BackendHelper:Interactor.Backend {

    lateinit var apiResponse:ApiResponse


    override fun downloadRates(api_key: String):Single<ApiResponse> =
        RetrofitHelper().getRates(api_key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

}