package com.tomtom.tom.brocalc.ui.main

import android.util.Log
import android.view.View
import android.widget.TextView
import com.tomtom.tom.brocalc.R
import com.tomtom.tom.brocalc.R.id.*
import com.tomtom.tom.brocalc.application.BroCalcApplication.Companion.apiKey
import com.tomtom.tom.brocalc.base.BasePresenter
import com.tomtom.tom.data.BackendHelper
import com.tomtom.tom.data.prefs.PreferencesHelper
import com.tomtom.tom.domain.boundaries.*
import com.tomtom.tom.domain.model.CurrencyRow
import com.tomtom.tom.domain.model.ScreenViewModel
import com.tomtom.tom.domain.usecases.*

class MainPresenter: BasePresenter(), MainContract.Presenter, Interactor.Presentation {

    private val tag = this.javaClass.simpleName
    lateinit var mainView:MainContract.View

    var currencies = context.resources.getStringArray(R.array.currencies)

    val prefsInteractor:Interactor.Prefs = PreferencesHelper(context)
    val backendInteractor:Interactor.Backend = BackendHelper()

    val clearScreenUseCase:ClearScreenUseCase = ClearScreenUseCaseImpl()
    val backspaceUseCase:BackspaceUseCase = BackspaceUseCaseImpl()
    val numberInputUseCase:NumberInputUseCase = NumberInputUseCaseImpl()
    val pointInputUseCase:PointInputUseCase = PointInputUseCaseImpl()
    val bootstrapUseCase:BootstrapUseCase = BootstrapUseCaseImpl()
    val changeRowUseCase:ChangeRowUseCase = ChangeRowUseCaseImpl()
    val changeCurrencyUseCase:ChangeCurrencyUseCase = ChangeCurrencyUseCaseImpl()

    var currentScreen = getInitialScreen()

    override fun setActivity(mainActivity: MainActivity) {
        mainView = mainActivity
    }

    override fun onCreate() {
        bootstrapUseCase.run(apiKey, backendInteractor, this, prefsInteractor)
        mainView.onDataUpdate(currentScreen)
    }

    override fun activate() {
        mainView.showProgressSnack(false)
        mainView.onBootstrap()
    }

    override fun onClick(view: View?) {
        if (view != null) {
            if (view.tag == "number") {
                val button = view as TextView
                Log.i(tag, button.text as String?)
                numberInputUseCase.run(button.text as String, currentScreen, this, prefsInteractor)
            } else {
                when (view.id) {
                    point -> pointInputUseCase.run(currentScreen, this)
                    ac -> clearScreenUseCase.run(currentScreen, this)
                    back -> backspaceUseCase.run(currentScreen, this, prefsInteractor)
                    currency_choice_upper -> mainView.showPickerDialog(0)
                    currency_choice_lower -> mainView.showPickerDialog(1)
                    currency_value_upper -> changeRowUseCase.run(0, currentScreen, this,prefsInteractor)
                    currency_value_lower -> changeRowUseCase.run(1, currentScreen, this,prefsInteractor)
                }
            }
        }
    }

    override fun updateScreen(screenViewModel: ScreenViewModel) {
        currentScreen = screenViewModel
        mainView.onDataUpdate(currentScreen)
    }

    override fun pickCurrency(index: Int, row: Int) = changeCurrencyUseCase.run(row, index, context.resources.getStringArray(R.array.currencies), currentScreen, this, prefsInteractor)

    override fun onDownloadFail() = mainView.onDownloadFailed()

    override fun showProgressIndicator() = mainView.showProgressSnack(true)

    fun getInitialScreen():ScreenViewModel = ScreenViewModel(
            CurrencyRow(currencies[0], "0", true),
            CurrencyRow(currencies[2], "0")
    )

    override fun onStart()        {  Log.d(tag, "Activity triggered onStart()")     }
    override fun onResume()       {  Log.d(tag, "Activity triggered onResume()")    }
    override fun onPause()        {  Log.d(tag, "Activity triggered onPause()")     }
    override fun onDestroy()      {  Log.d(tag, "Activity triggered onDestroy()")   }
    override fun onStop()         {  Log.d(tag, "Activity triggered onStop()")      }
}