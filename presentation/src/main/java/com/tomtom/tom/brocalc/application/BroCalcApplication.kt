package com.tomtom.tom.brocalc.application

import android.app.Application
import com.tomtom.tom.brocalc.R
import com.tomtom.tom.brocalc.dagger.AppComponent
import com.tomtom.tom.brocalc.dagger.DaggerAppComponent
import com.tomtom.tom.tvshowslist.dagger.AppModule


class BroCalcApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var baseUrl: String
        lateinit var apiKey: String
    }

    override fun onCreate() {
        super.onCreate()

        baseUrl = resources.getString(R.string.base_url)

        /*
            Oкей,
            Хардкодить ключ в XML, конечно же неправильно.
            Делаю это здесь в порядке исключения, так как задание
            носит тестовый характер.
        */

        apiKey = resources.getString(R.string.api_key)

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}