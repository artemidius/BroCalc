package com.tomtom.tom.data.backend.retrofit

import com.tomtom.tom.domain.model.ApiResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    private var moviesApi: MoviesApi
    private val baseUrl = "http://data.fixer.io/api/"

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        moviesApi = retrofit.create(MoviesApi::class.java)
    }

    fun getRates(api_key: String, page: String): Single<ApiResponse> = moviesApi.getRates(api_key)
}