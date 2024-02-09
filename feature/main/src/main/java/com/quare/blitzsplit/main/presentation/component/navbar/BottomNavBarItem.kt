package com.quare.blitzsplit.main.presentation.component.navbar

import com.quare.blitzsplit.component.R

sealed class BottomNavBarItem(
    val title: String,
    val icon: Int,
    val screen: BottomNavScreen,
) {

    abstract val isSelected: Boolean

    data class Groups(override val isSelected: Boolean) : BottomNavBarItem(
        title = "Grupos",
        screen = BottomNavScreen.GROUPS,
        icon = R.drawable.groups_icon,
    )

    data class Contacts(override val isSelected: Boolean) : BottomNavBarItem(
        title = "Contatos",
        screen = BottomNavScreen.CONTACTS,
        icon = R.drawable.contacts_icon,
    )

    data class Activity(override val isSelected: Boolean) : BottomNavBarItem(
        title = "Atividade",
        screen = BottomNavScreen.ACTIVITY,
        icon = R.drawable.activity_icon,
    )
}
