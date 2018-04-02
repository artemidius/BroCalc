package com.tomtom.tom.domain.boundaries

import com.tomtom.tom.domain.model.ApiResponse
import com.tomtom.tom.domain.model.ScreenViewModel
import io.reactivex.Single

interface Interactor {

    interface Presentation {
        fun updateScreen(screenViewModel: ScreenViewModel)
        fun activate()
        fun onDownloadFail()
        fun showProgressIndicator()

    }

    interface Prefs {
        fun readString(key:String):String
        fun readBoolean(key:String):Boolean
        fun readInt(key:String):Int

        fun writeString (key:String, value:String)
        fun writeBoolean (key:String, value:Boolean)
        fun writeInt (key:String, value:Int)
        fun localStorageHasSomeRates ():Boolean
    }

    interface Backend {
        fun downloadRates(api_key:String): Single<ApiResponse>
    }
}