package com.quare.blitzsplit.groups.domain.model

import com.quare.blitzplit.component.pricechip.model.PriceChipsModel

sealed interface GroupsScreenItem {

    data object CreateGroupButtonModel : GroupsScreenItem

    data class GroupItemModel(
        val id: String,
        val name: String,
        val imageUrl: String?,
        val priceChipsModel: PriceChipsModel,
        val profilePictures: List<String?>,
        val moreParticipants: MoreParticipantsModel,
        val userDebits: UserDebitsModel,
    ): GroupsScreenItem
}
