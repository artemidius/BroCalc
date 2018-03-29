package com.tomtom.tom.tvshowslist.dagger

import android.content.Context
import com.tomtom.tom.brocalc.application.BroCalcApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: BroCalcApplication) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): BroCalcApplication = app
}