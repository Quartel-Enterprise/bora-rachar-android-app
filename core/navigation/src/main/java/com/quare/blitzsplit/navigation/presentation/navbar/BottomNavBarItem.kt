package com.quare.blitzsplit.navigation.presentation.navbar

import com.quare.blitzsplit.component.R
import com.quare.blitzsplit.navigation.presentation.Route

sealed class BottomNavBarItem(
    val route: String,
    val title: String,
    val icon: Int,
    open var isSelected: Boolean,
) {

    fun select(): BottomNavBarItem = apply {
        isSelected = true
    }

    fun unSelect(): BottomNavBarItem = apply {
        isSelected = false
    }

    data class Groups(override var isSelected: Boolean) : BottomNavBarItem(
        route = Route.GROUPS,
        title = "Grupos",
        icon = R.drawable.groups_icon,
        isSelected = isSelected
    )

    data class Contacts(override var isSelected: Boolean) : BottomNavBarItem(
        route = Route.CONTACTS,
        title = "Contatos",
        icon = R.drawable.contacts_icon,
        isSelected = isSelected
    )

    data class Activity(override var isSelected: Boolean) : BottomNavBarItem(
        route = Route.ACTIVITY,
        title = "Atividade",
        icon = R.drawable.activity_icon,
        isSelected = isSelected
    )
}
