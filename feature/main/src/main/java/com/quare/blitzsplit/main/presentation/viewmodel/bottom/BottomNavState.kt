package com.quare.blitzsplit.main.presentation.viewmodel.bottom

import com.quare.blitzsplit.main.presentation.component.navbar.model.BottomNavigationItem
import com.quare.blitzsplit.main.presentation.component.navbar.model.BlitzSplitNavType

data class BottomNavState(
    val items: List<BottomNavigationItem>,
    val selectedScreen: BlitzSplitNavType
)
