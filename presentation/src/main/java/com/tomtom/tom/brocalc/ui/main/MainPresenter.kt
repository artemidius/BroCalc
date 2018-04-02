package com.tomtom.tom.brocalc.ui.main

import android.util.Log
import android.view.View
import android.widget.TextView
import com.tomtom.tom.brocalc.R.id.*
import com.tomtom.tom.brocalc.application.BroCalcApplication.Companion.apiKey
import com.tomtom.tom.brocalc.base.BasePresenter
import com.tomtom.tom.data.BackendHelper
import com.tomtom.tom.data.prefs.PreferencesHelper
import com.tomtom.tom.domain.boundaries.*
import com.tomtom.tom.domain.model.CurrencyRow
import com.tomtom.tom.domain.model.ScreenViewModel
import com.tomtom.tom.domain.usecases.*

class MainPresenter(mainActivity: MainActivity): BasePresenter(), MainContract.Presenter, Interactor.Presentation {

    private val tag = this.javaClass.simpleName
    val view:MainContract.View = mainActivity

    val prefsInteractor:Interactor.Prefs = PreferencesHelper(context)
    val backendInteractor:Interactor.Backend = BackendHelper()

    val clearScreenUseCase:ClearScreenUseCase = ClearScreenUseCaseImpl()
    val backspaceUseCase:BackspaceUseCase = BackspaceUseCaseImpl()
    val numberInputUseCase:NumberInputUseCase = NumberInputUseCaseImpl()
    val pointInputUseCase:PointInputUseCase = PointInputUseCaseImpl()
    val bootstrapUseCase:BootstrapUseCase = BootstrapUseCaseImpl()
    val changeRowUseCase:ChangeRowUseCase = ChangeRowUseCaseImpl()

    var currentScreen = getInitialScreen()

    fun getInitialScreen():ScreenViewModel = ScreenViewModel(
            CurrencyRow("EUR", "0", true, true),
            CurrencyRow("RUB", "0")
        )

    override fun activate() {
        view.onBootstrap()
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
                    currency_choice_upper -> Log.i(tag, "currency_choice_upper")
                    currency_choice_lower -> Log.i(tag, "currency_choice_lower")
                    currency_value_upper -> changeRowUseCase.run(0, currentScreen, this,prefsInteractor)
                    currency_value_lower -> changeRowUseCase.run(1, currentScreen, this,prefsInteractor)
                }
            }
        }
    }

    override fun onScreenUpdated(screenViewModel: ScreenViewModel) {
        currentScreen = screenViewModel
        view.onDataUpdate(currentScreen)
    }

    override fun onCreate()       {
        Log.d(tag, "Activity triggered onCreate()")
        view.onDataUpdate(currentScreen)
        bootstrapUseCase.run(apiKey, backendInteractor, this, prefsInteractor)
    }

    override fun onResume()       {  Log.d(tag, "Activity triggered onResume()")    }
    override fun onPause()        {  Log.d(tag, "Activity triggered onPause()")     }
    override fun onDestroy()      {  Log.d(tag, "Activity triggered onDestroy()")   }
    override fun onStop()         {  Log.d(tag, "Activity triggered onStop()")      }
}

