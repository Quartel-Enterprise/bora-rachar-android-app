package com.quare.blitzsplit.groups.data.datasource

import com.quare.blitzplit.component.pricechip.model.PriceChipsModel
import com.quare.blitzsplit.groups.data.StaticImages
import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem
import com.quare.blitzsplit.groups.domain.model.MoreParticipantsModel
import com.quare.blitzsplit.groups.domain.model.UserDebitsModel
import javax.inject.Inject

class LocalGroupsDataSource @Inject constructor() {
    fun getGroups(): Result<List<GroupsScreenItem.GroupItemModel>> = Result.success(
        listOf(
            GroupsScreenItem.GroupItemModel(
                id = "1",
                name = "Quartel Otaku",
                userDebits = UserDebitsModel(
                    amount = 3,
                    shouldShow = true,
                ),
                moreParticipants = MoreParticipantsModel(
                    amount = 3,
                    shouldShow = true,
                ),
                imageUrl = StaticImages.DOG,
                priceChipsModel = PriceChipsModel(
                    toPay = "R$ 9,90",
                    toReceive = "R$ 250,00",
                ),
                profilePictures = listOf(
                    StaticImages.ARRIGHI,
                    StaticImages.THIAGO,
                    StaticImages.FABIRCIO,
                    StaticImages.PIERRE,
                )
            ),
            GroupsScreenItem.GroupItemModel(
                id = "2",
                name = "Quartel Ancap",
                userDebits = UserDebitsModel(
                    amount = 2,
                    shouldShow = true,
                ),
                moreParticipants = MoreParticipantsModel(
                    amount = 0,
                    shouldShow = false,
                ),
                imageUrl = StaticImages.MILEI,
                priceChipsModel = PriceChipsModel(
                    toPay = null,
                    toReceive = "R$ 250,00",
                ),
                profilePictures = listOf(
                    StaticImages.ARRIGHI,
                    StaticImages.THIAGO,
                    StaticImages.FABIRCIO,
                    StaticImages.PIERRE,
                )
            ),
        )
    )
}
