package com.quare.blitzsplit.groups.data.datasource

import com.quare.blitzplit.component.chip.price.model.PriceChipsModel
import com.quare.blitzplit.component.utils.StaticImages
import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem
import com.quare.blitzsplit.groups.domain.model.MoreParticipantsModel
import com.quare.blitzsplit.groups.domain.model.UserDebitsModel
import com.quare.blitzsplit.utils.CurrencyFormatter
import javax.inject.Inject

class LocalGroupsDataSource @Inject constructor(
    private val currencyFormatter: CurrencyFormatter
) {
    fun getGroups(): Result<List<GroupsScreenItem.GroupItem>> = Result.success(
        listOf(
            GroupsScreenItem.GroupItem.WithDebits(
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
                    toPay = currencyFormatter.format(9.90),
                    toReceive = currencyFormatter.format(250)
                ),
                profilePictures = listOf(
                    StaticImages.ARRIGHI,
                    StaticImages.THIAGO,
                    StaticImages.FABIRCIO,
                    StaticImages.PIERRE,
                )
            ),
            GroupsScreenItem.GroupItem.WithDebits(
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
                    toReceive = currencyFormatter.format(250)
                ),
                profilePictures = listOf(
                    StaticImages.ARRIGHI,
                    StaticImages.THIAGO,
                    StaticImages.FABIRCIO,
                    StaticImages.PIERRE,
                )
            ),
            GroupsScreenItem.GroupItem.PaidOff(
                id = "3",
                name = "Quartel Escalada",
                moreParticipants = MoreParticipantsModel(
                    amount = 0,
                    shouldShow = false,
                ),
                imageUrl = StaticImages.ESCALADA,
                profilePictures = listOf(
                    StaticImages.THIAGO,
                    StaticImages.FABIRCIO,
                    StaticImages.PIERRE,
                )
            ),
        )
    )
}
