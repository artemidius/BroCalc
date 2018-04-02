package com.tomtom.tom.brocalc.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import com.tomtom.tom.brocalc.R
import com.tomtom.tom.brocalc.ui.main.MainContract

class PickCurrencyDialogFragment: DialogFragment() {

    var row = 0
    var presenter:MainContract.Presenter? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context!!)
        builder
                .setItems(R.array.currencies, {
                    dialog, which ->
                    presenter!!.pickCurrency(which, row)
                })
        return builder.create()
    }
}