package com.quare.blitzsplit.groups.domain.model

import com.quare.blitzplit.component.chip.price.model.PriceChipsModel

sealed interface GroupsScreenItem {

    data class CreateGroupButtonModel(val padding: Int) : GroupsScreenItem

    data object PaidOffGroupsTitle: GroupsScreenItem

    sealed class GroupItem(
        val id: String,
        val name: String,
        val imageUrl: String?,
        val profilePictures: List<String?>,
        val moreParticipants: MoreParticipantsModel,
        val userDebits: UserDebitsModel,
    ) : GroupsScreenItem {
        class WithDebits(
            id: String,
            name: String,
            imageUrl: String?,
            profilePictures: List<String?>,
            moreParticipants: MoreParticipantsModel,
            userDebits: UserDebitsModel,
            val priceChipsModel: PriceChipsModel
        ): GroupItem(id, name, imageUrl, profilePictures, moreParticipants, userDebits)

        class PaidOff(
            id: String,
            name: String,
            imageUrl: String?,
            profilePictures: List<String?>,
            moreParticipants: MoreParticipantsModel,
        ): GroupItem(
            id = id,
            name = name,
            imageUrl = imageUrl,
            profilePictures = profilePictures,
            moreParticipants = moreParticipants,
            userDebits = UserDebitsModel(0, false),
        )
    }
}
