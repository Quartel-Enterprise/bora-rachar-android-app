package com.quare.blitzsplit.main.presentation.component.navbar.model

import com.quare.blitzsplit.main.R

sealed class BlitzSplitNavBarItem(
    val title: String,
    val icon: Int,
    val screen: BlitzSplitNavType,
) {

    abstract val isSelected: Boolean

    data class Groups(override val isSelected: Boolean) : BlitzSplitNavBarItem(
        title = "Grupos",
        screen = BlitzSplitNavType.GROUPS,
        icon = R.drawable.groups_icon,
    )

    data class Contacts(override val isSelected: Boolean) : BlitzSplitNavBarItem(
        title = "Contatos",
        screen = BlitzSplitNavType.CONTACTS,
        icon = R.drawable.contacts_icon,
    )

    data class Activity(override val isSelected: Boolean) : BlitzSplitNavBarItem(
        title = "Atividade",
        screen = BlitzSplitNavType.ACTIVITY,
        icon = R.drawable.activity_icon,
    )
}
