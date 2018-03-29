package com.tomtom.tom.brocalc.base


interface Dispatcher {

    fun showLoadigProgress(visible:Boolean)
    fun onConnectionFailed(presenter: ActivityLifeCyclePresenter)

}