package com.tomtom.tom.brocalc.base

interface ActivityLifeCyclePresenter {
    fun onCreate()
    fun onResume()
    fun onPause()
    fun onStart()
    fun onStop()
    fun onDestroy()
}