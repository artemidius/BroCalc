package com.tomtom.tom.brocalc.ui.main

import android.util.Log
import android.view.View
import android.widget.TextView
import com.tomtom.tom.brocalc.R.id.*
import com.tomtom.tom.brocalc.base.BasePresenter

class MainPresenter(mainActivity: MainActivity): BasePresenter(), MainContract.Presenter {

    val view:MainContract.View = mainActivity

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

    private val tag = this.javaClass.simpleName

    override fun onCreate()       {  Log.d(tag, "Fragment triggered onResume()")    }
    override fun onResume()       {  Log.d(tag, "Fragment triggered onResume()")    }
    override fun onPause()        {  Log.d(tag, "Fragment triggered onPause()")     }
    override fun onDestroy()      {  Log.d(tag, "Fragment triggered onDestroy()")   }
    override fun onStop()         {  Log.d(tag, "Fragment triggered onStop()")      }
}

