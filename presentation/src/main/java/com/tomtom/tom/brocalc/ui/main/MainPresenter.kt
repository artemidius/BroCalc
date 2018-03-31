package com.tomtom.tom.brocalc.ui.main

import android.util.Log
import android.view.View
import android.widget.TextView
import com.tomtom.tom.brocalc.R.id.*
import com.tomtom.tom.brocalc.base.BasePresenter
import com.tomtom.tom.domain.boundaries.ClearScreenUseCase
import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.model.CurrencyRow
import com.tomtom.tom.domain.model.ScreenViewModel
import com.tomtom.tom.domain.usecases.ClearScreenUseCaseImpl

class MainPresenter(mainActivity: MainActivity): BasePresenter(), MainContract.Presenter, Interactor.Presentation {


    private val tag = this.javaClass.simpleName
    val view:MainContract.View = mainActivity

    val clearScreenUseCase:ClearScreenUseCase = ClearScreenUseCaseImpl()

    var currentScreen = getInitialScreen()

    fun getInitialScreen():ScreenViewModel =
        ScreenViewModel(
            CurrencyRow("USD", "1"),
            CurrencyRow("RUB", "52")
        )

    override fun onClick(view: View?) {
        if (view != null) {
            if (view.tag == "number") {
                val button = view as TextView
                Log.i(tag, button.text as String?)
            } else {
                when (view.id) {
                    point -> Log.i(tag, "point")
                    ac -> clearScreenUseCase.run(currentScreen, this)
                    back -> Log.i(tag, "back")
                    currency_choice_upper -> Log.i(tag, "currency_choice_upper")
                    currency_choice_lower -> Log.i(tag, "currency_choice_lower")
                    currency_value_upper -> {
                        Log.i(tag, "currency_value_upper")
                    }
                    currency_value_lower -> Log.i(tag, "currency_value_lower")
                }
            }
        }
    }

    override fun onScreenCleaned(screenViewModel: ScreenViewModel) {
        currentScreen = screenViewModel
        view.onDataUpdate(currentScreen)
    }

    override fun onCreate()       {
        Log.d(tag, "Fragment triggered onCreate()")
        currentScreen.lowerRow.currencyValue = "666"
        view.onDataUpdate(currentScreen)
    }

    override fun onResume()       {  Log.d(tag, "Fragment triggered onResume()")    }
    override fun onPause()        {  Log.d(tag, "Fragment triggered onPause()")     }
    override fun onDestroy()      {  Log.d(tag, "Fragment triggered onDestroy()")   }
    override fun onStop()         {  Log.d(tag, "Fragment triggered onStop()")      }
}

