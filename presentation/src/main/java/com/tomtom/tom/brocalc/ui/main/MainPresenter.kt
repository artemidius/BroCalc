package com.tomtom.tom.brocalc.ui.main

import android.util.Log
import com.tomtom.tom.brocalc.base.BasePresenter

class MainPresenter(mainActivity: MainActivity): BasePresenter(), MainContract.Presenter {

    private val tag = this.javaClass.simpleName

    override fun onCreate()       {  Log.d(tag, "Fragment triggered onResume()")    }
    override fun onResume()       {  Log.d(tag, "Fragment triggered onResume()")    }
    override fun onPause()        {  Log.d(tag, "Fragment triggered onPause()")     }
    override fun onDestroy()      {  Log.d(tag, "Fragment triggered onDestroy()")   }
    override fun onStop()         {  Log.d(tag, "Fragment triggered onStop()")      }
}

