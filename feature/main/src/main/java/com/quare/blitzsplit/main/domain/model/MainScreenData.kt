package com.quare.blitzsplit.main.domain.model

import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel
import com.quare.blitzplit.component.navbar.BottomNavigationItem

data class MainScreenData(
    val appBarModel: MainAppBarModel,
    val navigationItems: List<BottomNavigationItem>,
)
