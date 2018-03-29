package com.tomtom.tom.brocalc.ui.main

import android.os.Bundle
import com.tomtom.tom.brocalc.R
import com.tomtom.tom.brocalc.base.BaseActivity

class MainActivity : BaseActivity(), MainContract.View {

    val presenter:MainContract.Presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onCreate()

    }


    override fun onDataUpdate() {

    }
}
