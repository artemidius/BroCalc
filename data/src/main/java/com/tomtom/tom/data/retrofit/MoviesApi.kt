package com.tomtom.tom.data.backend.retrofit

import com.tomtom.tom.domain.model.ApiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    //http://data.fixer.io/api/latest?access_key=d62291a4630a6b7f1a8a488659b1285d

    @GET("/latest")
    fun getRates(
            @Query("access_key") api_key: String
    ): Single<ApiResponse>

}