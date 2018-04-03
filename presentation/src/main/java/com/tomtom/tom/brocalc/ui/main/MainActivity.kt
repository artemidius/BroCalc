package com.tomtom.tom.brocalc.ui.main

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.android.databinding.library.baseAdapters.BR
import com.tomtom.tom.brocalc.R
import com.tomtom.tom.brocalc.application.BroCalcApplication
import com.tomtom.tom.brocalc.base.BaseActivity
import com.tomtom.tom.brocalc.ui.dialogs.PickCurrencyDialogFragment
import com.tomtom.tom.domain.model.ScreenViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainContract.View, View.OnClickListener {

    @Inject
    lateinit var presenter: MainPresenter

    lateinit var binding: ViewDataBinding
    lateinit var progressSnackBar:Snackbar

    lateinit var presenterInterface: MainContract.Presenter

    val dialog = PickCurrencyDialogFragment()
    val fragmentManager = this@MainActivity.supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BroCalcApplication.presenterComponent.inject(this)
        presenterInterface = presenter

        setContentView(R.layout.activity_main)
        presenterInterface.setActivity(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        progressSnackBar = getProgressSnack()
        dialog.presenter = presenterInterface
        presenterInterface.onCreate()
    }

    override fun onDataUpdate(model: ScreenViewModel) {
        binding.setVariable(BR.model, model)
    }

    override fun onClick(view: View?) = presenterInterface.onClick(view)

    override fun onBootstrap() = setListeners()

    override fun onDownloadFailed() = Snackbar.make(main_container, getString(R.string.network_issue), Snackbar.LENGTH_INDEFINITE).setAction(getString(R.string.retry)) { presenterInterface.onCreate() }.show()

    override fun showPickerDialog(row: Int) {
        dialog.row = row
        dialog.show(fragmentManager, null)
    }

    override fun showProgressSnack(state: Boolean) = if (state) progressSnackBar.show() else progressSnackBar.dismiss()

    fun getProgressSnack():Snackbar {
        val bar = Snackbar.make(main_container, "", Snackbar.LENGTH_INDEFINITE)
        val snack_view = bar.view as ViewGroup
        snack_view.addView(ProgressBar(this))
        return bar
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
}
