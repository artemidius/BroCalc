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
    }

    override fun onCreate() {
        super.onCreate()

        baseUrl = resources.getString(R.string.base_url)

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}