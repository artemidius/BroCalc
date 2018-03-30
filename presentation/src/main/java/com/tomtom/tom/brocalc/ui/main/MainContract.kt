package com.tomtom.tom.brocalc.ui.main

import com.tomtom.tom.brocalc.base.ActivityLifeCyclePresenter
import com.tomtom.tom.domain.model.ScreenViewModel


interface MainContract {
    interface View {
        fun onDataUpdate(model: ScreenViewModel)
    }

    interface Presenter : ActivityLifeCyclePresenter {
        fun onClick(view: android.view.View?)
    }

}