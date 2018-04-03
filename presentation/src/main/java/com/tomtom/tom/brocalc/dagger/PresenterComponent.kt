package com.tomtom.tom.brocalc.dagger

import com.tomtom.tom.brocalc.ui.main.MainActivity
import com.tomtom.tom.tvshowslist.dagger.PresenterModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        PresenterModule::class
        )
)

interface PresenterComponent {
    fun inject(mainActivity: MainActivity)
}