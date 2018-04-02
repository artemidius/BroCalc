package com.tomtom.tom.domain.entities

import com.tomtom.tom.domain.boundaries.Interactor
import com.tomtom.tom.domain.model.ScreenViewModel


class Entities {

    fun convertActive(screenViewModel: ScreenViewModel, prefs: Interactor.Prefs):ScreenViewModel {
        val (activeType, activeValue, currencyToConvert) = extractData(screenViewModel)

        val otherRow = if (screenViewModel.upperRow.isActive) screenViewModel.lowerRow else screenViewModel.upperRow

        if (activeValue == 0f) otherRow.currencyValue = "0"
        else {
            val activeRate: Float = prefs.readString(activeType).toFloat()
            val otherRate: Float = prefs.readString(currencyToConvert).toFloat()
            val conversionRate = otherRate / activeRate
            val conversionResult = conversionRate * activeValue
            val formattedRes = trimFloat(String.format("%.2f", conversionResult))
            otherRow.currencyValue = formattedRes
        }

        return screenViewModel

    }

    data class Result(
            val activeType: String,
            val activeValue: Float,
            val currencyToConvert: String
    )

    fun extractData(screenViewModel: ScreenViewModel): Result {
        val activeRow = if (screenViewModel.upperRow.isActive) screenViewModel.upperRow else screenViewModel.lowerRow
        val otherRow = if (screenViewModel.upperRow.isActive) screenViewModel.lowerRow else screenViewModel.upperRow
        return Result(activeRow.currencyType, activeRow.currencyValue.toFloat(), otherRow.currencyType)
    }

    fun trimFloat(value:String):String {
        if(value.takeLast(1) == "0" || value.takeLast(1) == ".") return trimFloat(value.dropLast(1))
        return value
    }

    fun handleBackspace(screenViewModel: ScreenViewModel):ScreenViewModel {
        val row = if (screenViewModel.upperRow.isActive) screenViewModel.upperRow else screenViewModel.lowerRow
        if(row.currencyValue.length > 1) row.currencyValue = row.currencyValue.dropLast(1)
        else {
            row.showsInitialOne = false
            row.currencyValue = "0"
        }
        return screenViewModel
    }

    fun handleInput(symbol:String, screenViewModel: ScreenViewModel):ScreenViewModel {
        val row = if (screenViewModel.upperRow.isActive) screenViewModel.upperRow else screenViewModel.lowerRow

        if(row.currencyValue.length < 12) {
            if (row.showsInitialOne || row.currencyValue == "0") {
                row.currencyValue = symbol
                row.showsInitialOne = false
            } else row.currencyValue = "${row.currencyValue}$symbol"
        }

        return screenViewModel
    }

    fun handlePoint(screenViewModel: ScreenViewModel):ScreenViewModel {
        val row = if (screenViewModel.upperRow.isActive) screenViewModel.upperRow else screenViewModel.lowerRow
        if (!row.currencyValue.contains(".")){
            if (row.showsInitialOne || row.currencyValue == "0") {
                row.showsInitialOne = false
                row.currencyValue = "0."
            }
            else if (row.currencyValue.length < 11) row.currencyValue = "${row.currencyValue}."
        }
        return screenViewModel
    }

    fun clearViewModel(screenViewModel: ScreenViewModel):ScreenViewModel {
        screenViewModel.upperRow.currencyValue = "0"
        screenViewModel.lowerRow.currencyValue = "0"
        return screenViewModel
    }

    fun changeActiveRow(index:Int, screenViewModel: ScreenViewModel):ScreenViewModel {
        when(index) {
            0 -> screenViewModel.upperRow.currencyValue = "1"
            1 -> screenViewModel.lowerRow.currencyValue = "1"
        }

        screenViewModel.upperRow.isActive = index == 0
        screenViewModel.upperRow.showsInitialOne = index == 0
        screenViewModel.lowerRow.isActive = index == 1
        screenViewModel.lowerRow.showsInitialOne = index == 1

        return screenViewModel
    }

}