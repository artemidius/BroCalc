package com.tomtom.tom.brocalc.ui.main

import com.tomtom.tom.brocalc.base.ActivityLifeCyclePresenter


interface MainContract {
    interface View {
        fun onDataUpdate()
    }

    interface Presenter : ActivityLifeCyclePresenter {
        fun onClick(view: android.view.View?)
    }

}