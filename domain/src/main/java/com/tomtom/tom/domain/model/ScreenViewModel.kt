package com.tomtom.tom.domain.model

class ScreenViewModel (
   val upperRow:CurrencyRow,
   val lowerRow:CurrencyRow
)

class CurrencyRow (
        var currencyType:String,
        var currencyValue:String,
        var isActive:Boolean = false,
        var showsInitialOne:Boolean = false
)