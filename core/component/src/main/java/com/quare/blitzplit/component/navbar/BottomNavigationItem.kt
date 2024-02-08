package com.quare.blitzplit.component.navbar

import androidx.annotation.DrawableRes

data class BottomNavigationItem(
    val title: String,
    @DrawableRes val icon: Int,
    val isSelected: Boolean,
    val onClick: () -> Unit
)
