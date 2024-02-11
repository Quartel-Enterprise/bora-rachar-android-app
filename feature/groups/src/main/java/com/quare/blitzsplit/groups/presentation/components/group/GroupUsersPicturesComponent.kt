package com.quare.blitzsplit.groups.presentation.components.group

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.ball.BallComponent
import com.quare.blitzplit.component.ball.model.BallModel
import com.quare.blitzplit.component.picture.profile.UserProfilePicture
import com.quare.blitzplit.component.spacer.HorizontalSpacer
import com.quare.blitzsplit.groups.domain.model.MoreParticipantsModel
import com.quare.blitzsplit.theme.Black200
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun GroupUsersPicturesComponent(
    profilePictures: List<String?>,
    moreParticipants: MoreParticipantsModel,
    modifier: Modifier = Modifier,
    ballSize: Dp = 20.dp,
    ballAmountColor: Color = Black200,
) {
    Row(modifier) {
        profilePictures.forEach { picture ->
            UserProfilePicture(
                photoUrl = picture,
                size = ballSize
            )
            HorizontalSpacer(4.dp)
        }
        if (moreParticipants.shouldShow) {
            BallComponent(
                ballModel = BallModel.WithBorder(ballAmountColor),
                size = ballSize,
                text = "+${moreParticipants.amount}",
                textColor = ballAmountColor,
                textSize = 12.sp
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun GroupUsersPicturesComponentPreview() {
    BlitzSplitTheme {
        GroupUsersPicturesComponent(
            profilePictures = listOf(
                null,
                null,
                null
            ),
            moreParticipants = MoreParticipantsModel(
                shouldShow = true,
                amount = 3
            )
        )
    }
}
