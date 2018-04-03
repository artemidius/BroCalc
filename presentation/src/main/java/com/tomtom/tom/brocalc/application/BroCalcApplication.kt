package com.tomtom.tom.brocalc.application

import android.app.Application
import com.tomtom.tom.brocalc.R
import com.tomtom.tom.brocalc.dagger.AppComponent
import com.tomtom.tom.brocalc.dagger.DaggerAppComponent
import com.tomtom.tom.brocalc.dagger.DaggerPresenterComponent
import com.tomtom.tom.brocalc.dagger.PresenterComponent
import com.tomtom.tom.brocalc.ui.main.MainPresenter
import com.tomtom.tom.tvshowslist.dagger.AppModule
import com.tomtom.tom.tvshowslist.dagger.PresenterModule


class BroCalcApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var presenterComponent: PresenterComponent
        lateinit var baseUrl: String
        lateinit var apiKey: String
    }

    override fun onCreate() {
        super.onCreate()

        baseUrl = resources.getString(R.string.base_url)

        /*
            Okay, hardcoding the key here is wrong, I know. I do it here as an exception for the sake of test assignment
        */

        apiKey = resources.getString(R.string.api_key)


        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        presenterComponent = DaggerPresenterComponent.builder()
                .presenterModule(PresenterModule(MainPresenter()))
                .build()
    }
}