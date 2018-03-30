package com.tomtom.tom.brocalc.ui.main

import android.util.Log
import android.view.View
import android.widget.TextView
import com.tomtom.tom.brocalc.R.id.*
import com.tomtom.tom.brocalc.base.BasePresenter
import com.tomtom.tom.domain.model.ScreenViewModel

class MainPresenter(mainActivity: MainActivity): BasePresenter(), MainContract.Presenter {

    private val tag = this.javaClass.simpleName
    val view:MainContract.View = mainActivity

    var currentScreen = ScreenViewModel(
            "USD",
            "RUB",
            "0",
            "0")

    override fun onClick(view: View?) {
        if (view != null) {
            if (view.tag == "number") {
                val button = view as TextView
                Log.i(tag, button.text as String?)
            } else {
                when (view.id) {
                    point -> Log.i(tag, "point")
                    ac -> Log.i(tag, "AC")
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

    override fun onCreate()       {
        Log.d(tag, "Fragment triggered onCreate()")
        currentScreen.currencyTypeLower = "JJJ"
        view.onDataUpdate(currentScreen)
    }
    override fun onResume()       {  Log.d(tag, "Fragment triggered onResume()")    }
    override fun onPause()        {  Log.d(tag, "Fragment triggered onPause()")     }
    override fun onDestroy()      {  Log.d(tag, "Fragment triggered onDestroy()")   }
    override fun onStop()         {  Log.d(tag, "Fragment triggered onStop()")      }
}

