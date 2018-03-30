package com.tomtom.tom.brocalc.ui.main

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.View
import com.android.databinding.library.baseAdapters.BR
import com.tomtom.tom.brocalc.R
import com.tomtom.tom.brocalc.base.BaseActivity
import com.tomtom.tom.domain.model.ScreenViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View, View.OnClickListener {

    override fun onClick(view: View?) = presenter.onClick(view)

    lateinit var binding:ViewDataBinding



    val presenter:MainContract.Presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
        presenter.onCreate()

    }

    fun setListeners() {
        currency_choice_upper.setOnClickListener(this)
        currency_choice_lower.setOnClickListener(this)
        currency_value_upper.setOnClickListener(this)
        currency_value_lower.setOnClickListener(this)

        b0.setOnClickListener(this)
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        b4.setOnClickListener(this)
        b5.setOnClickListener(this)
        b6.setOnClickListener(this)
        b7.setOnClickListener(this)
        b8.setOnClickListener(this)
        b9.setOnClickListener(this)
        ac.setOnClickListener(this)
        back.setOnClickListener(this)
        point.setOnClickListener(this)
    }


    override fun onDataUpdate(model:ScreenViewModel) {
        binding.setVariable(BR.model, model)
    }
}
