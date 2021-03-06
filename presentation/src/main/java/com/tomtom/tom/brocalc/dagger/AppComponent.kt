package com.tomtom.tom.brocalc.dagger

import com.tomtom.tom.brocalc.base.BasePresenter
import com.tomtom.tom.tvshowslist.dagger.AppModule
import com.tomtom.tom.tvshowslist.dagger.PresenterModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        AppModule::class
        )
)

interface AppComponent {
    fun inject(basePresenter: BasePresenter)
}