package com.quare.blitzsplit.utils

import java.math.BigDecimal
import java.text.DecimalFormat
import javax.inject.Inject

class CurrencyFormatter @Inject constructor() {

    private val decimalFormat = DecimalFormat("###0.00")
    private val integerFormat = DecimalFormat("###0")

    fun format(value: Number): String {
        val bigDecimalValue = value.asBigDecimal()

        return when {
            // For amounts below 1000 with cents
            bigDecimalValue < BigDecimal("1000") && bigDecimalValue.remainder(BigDecimal.ONE) > BigDecimal.ZERO ->
                "R$ ${decimalFormat.format(bigDecimalValue).replace(".", ",")}"

            // For exact values or above 1000 but below 10000
            bigDecimalValue >= BigDecimal("1000") && bigDecimalValue < BigDecimal("10000") ->
                "R$ ${integerFormat.format(bigDecimalValue)}"

            // For values of 10000 or more
            bigDecimalValue >= BigDecimal("10000") -> {
                val thousands = bigDecimalValue.divide(BigDecimal("1000"))
                "R$ ${integerFormat.format(thousands)}K"
            }
            // For all other cases, including amounts below 1000 without cents
            else -> "R$ ${integerFormat.format(bigDecimalValue)}"
        }
    }

    private fun Number.asBigDecimal(): BigDecimal = when (this) {
        is BigDecimal -> this
        is Float -> toBigDecimal()
        is Double -> toBigDecimal()
        is Long -> toBigDecimal()
        is Int -> toBigDecimal()
        else -> throw IllegalArgumentException("Unsupported number type")
    }
}
