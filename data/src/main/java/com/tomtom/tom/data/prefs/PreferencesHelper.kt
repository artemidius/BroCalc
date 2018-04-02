package com.tomtom.tom.data.prefs

import android.content.Context
import com.tomtom.tom.domain.boundaries.Interactor


class PreferencesHelper(context:Context):Interactor.Prefs  {



    enum class Currency {
        USD , RUB, GBP, JPY
    }

    val sharedPrefs = context.getSharedPreferences("shared", Context.MODE_PRIVATE)

    val valuesInitialized = "valuesInitialized"

    override fun writeString(key: String, value: String) {
        with(sharedPrefs.edit()){
            putString(key, value)
                    commit()
        }
    }

    override fun writeBoolean(key: String, value: Boolean) {
        with(sharedPrefs.edit()){
            putBoolean(key, value)
            commit()
        }
    }

    override fun writeInt(key: String, value: Int) {
        with(sharedPrefs.edit()){
            putInt(key, value)
            commit()
        }
    }

    override fun localStorageHasSomeRates(): Boolean = readBoolean(valuesInitialized)

    override fun readString(key: String): String =  sharedPrefs.getString(key, "")

    override fun readBoolean(key: String): Boolean = sharedPrefs.getBoolean(key, false)

    override fun readInt(key: String): Int = sharedPrefs.getInt(key, 0)

}
