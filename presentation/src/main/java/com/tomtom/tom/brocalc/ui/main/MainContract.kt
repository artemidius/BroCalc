package com.tomtom.tom.brocalc.ui.main

import com.tomtom.tom.brocalc.base.ActivityLifeCyclePresenter
import com.tomtom.tom.domain.model.ScreenViewModel


interface MainContract {
    interface View {
        fun onDataUpdate(model: ScreenViewModel)
        fun onBootstrap()
        fun showPickerDialog(row:Int)
        fun onDownloadFailed()
        fun showProgressSnack(state:Boolean)
    }

    interface Presenter : ActivityLifeCyclePresenter {
        fun onClick(view: android.view.View?)
        fun pickCurrency(index:Int, row:Int)
        fun setActivity(mainActivity: MainActivity)
    }

}