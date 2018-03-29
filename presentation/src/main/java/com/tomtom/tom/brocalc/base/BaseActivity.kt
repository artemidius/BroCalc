package com.tomtom.tom.brocalc.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(), Dispatcher {

    override fun onConnectionFailed(presenter: ActivityLifeCyclePresenter) { }

    override fun showLoadigProgress(visible: Boolean) { }

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }
}