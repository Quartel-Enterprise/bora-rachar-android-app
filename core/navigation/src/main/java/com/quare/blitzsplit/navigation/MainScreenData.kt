package com.quare.blitzsplit.navigation

import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel
import com.quare.blitzplit.component.navbar.BottomNavigationItem
import com.quare.blitzsplit.navigation.presentation.MainScreenCallbacks

data class MainScreenData(
    val appBarModel: MainAppBarModel,
    val navigationItems: List<BottomNavigationItem>,
    val callbacks: MainScreenCallbacks,
)
