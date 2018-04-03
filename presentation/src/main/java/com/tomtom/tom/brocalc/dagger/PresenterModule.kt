package com.tomtom.tom.tvshowslist.dagger

import com.tomtom.tom.brocalc.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule(val pres: MainPresenter) {
    @Provides
    @Singleton
    fun providePresenter(): MainPresenter = pres
}