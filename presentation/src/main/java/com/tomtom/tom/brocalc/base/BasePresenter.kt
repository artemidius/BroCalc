package com.tomtom.tom.brocalc.base

import android.content.Context
import com.tomtom.tom.brocalc.application.BroCalcApplication
import javax.inject.Inject

open class BasePresenter {
    @Inject
    lateinit var context: Context

    @Inject
    lateinit var application: BroCalcApplication

    init {
        BroCalcApplication.appComponent.inject(this)
    }
}