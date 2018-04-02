package com.tomtom.tom.domain.model

class ScreenViewModel (
   val upperRow:CurrencyRow,
   val lowerRow:CurrencyRow,
   var showProgress:Boolean = false
)

class CurrencyRow (
        var currencyType:String,
        var currencyValue:String,
        var isActive:Boolean = false,
        var showsInitialOne:Boolean = false
)