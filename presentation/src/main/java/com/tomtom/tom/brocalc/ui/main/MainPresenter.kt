package com.tomtom.tom.brocalc.ui.main

import android.util.Log
import android.view.View
import android.widget.TextView
import com.tomtom.tom.brocalc.R.id.*
import com.tomtom.tom.brocalc.base.BasePresenter
import com.tomtom.tom.domain.boundaries.*
import com.tomtom.tom.domain.model.CurrencyRow
import com.tomtom.tom.domain.model.ScreenViewModel
import com.tomtom.tom.domain.usecases.BackspaceUseCaseImpl
import com.tomtom.tom.domain.usecases.ClearScreenUseCaseImpl
import com.tomtom.tom.domain.usecases.NumberInputUseCaseImpl
import com.tomtom.tom.domain.usecases.PointInputUseCaseImpl

class MainPresenter(mainActivity: MainActivity): BasePresenter(), MainContract.Presenter, Interactor.Presentation {

    private val tag = this.javaClass.simpleName
    val view:MainContract.View = mainActivity

    val clearScreenUseCase:ClearScreenUseCase = ClearScreenUseCaseImpl()
    val backspaceUseCase:BackspaceUseCase = BackspaceUseCaseImpl()
    val numberInputUseCase:NumberInputUseCase = NumberInputUseCaseImpl()
    val pointInputUseCase:PointInputUseCase = PointInputUseCaseImpl()

    var currentScreen = getInitialScreen()

    fun getInitialScreen():ScreenViewModel = ScreenViewModel(
            CurrencyRow("EUR", "1", true, true),
            CurrencyRow("RUB", "56778992")
        )

    override fun onClick(view: View?) {
        if (view != null) {
            if (view.tag == "number") {
                val button = view as TextView
                Log.i(tag, button.text as String?)
                numberInputUseCase.run(button.text as String, currentScreen, this)
            } else {
                when (view.id) {
                    point -> pointInputUseCase.run(currentScreen, this)
                    ac -> clearScreenUseCase.run(currentScreen, this)
                    back -> backspaceUseCase.run(currentScreen, this)
                    currency_choice_upper -> Log.i(tag, "currency_choice_upper")
                    currency_choice_lower -> Log.i(tag, "currency_choice_lower")
                    currency_value_upper -> changeActiveRow(0)
                    currency_value_lower -> changeActiveRow(1)
                }
            }
        }
    }


    fun changeActiveRow(index:Int) {

        when(index) {
            0 -> currentScreen.upperRow.currencyValue = "1"
            1 -> currentScreen.lowerRow.currencyValue = "1"
        }
        currentScreen.upperRow.isActive = index == 0
        currentScreen.upperRow.showsInitialOne = index == 0
        currentScreen.lowerRow.isActive = index == 1
        currentScreen.lowerRow.showsInitialOne = index == 1

        view.onDataUpdate(currentScreen)
    }

    override fun onScreenCleaned(screenViewModel: ScreenViewModel) {
        currentScreen = screenViewModel
        view.onDataUpdate(currentScreen)
    }

    override fun onCreate()       {
        Log.d(tag, "Activity triggered onCreate()")
        view.onDataUpdate(currentScreen)
    }

    override fun onResume()       {  Log.d(tag, "Activity triggered onResume()")    }
    override fun onPause()        {  Log.d(tag, "Activity triggered onPause()")     }
    override fun onDestroy()      {  Log.d(tag, "Activity triggered onDestroy()")   }
    override fun onStop()         {  Log.d(tag, "Activity triggered onStop()")      }
}

