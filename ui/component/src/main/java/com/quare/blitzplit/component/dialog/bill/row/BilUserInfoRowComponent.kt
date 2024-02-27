package com.quare.blitzplit.component.dialog.bill.row

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.picture.profile.UserProfilePicture
import com.quare.blitzplit.component.spacer.HorizontalSpacer
import com.quare.blitzsplit.theme.Black300
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun BilUserInfoRowComponent(
    userName: String,
    userPicture: String?,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        UserProfilePicture(
            photoUrl = userPicture,
            size = 40.dp
        )
        HorizontalSpacer()
        Text(
            text = userName,
            style = TextStyle(
                color = Black300,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                letterSpacing = 0.5.sp,
                lineHeight = 24.sp
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BilUserInfoRowComponentPreview() {
    BlitzSplitTheme {
        BilUserInfoRowComponent(
            userName = "Gabriel A.",
            userPicture = null
        )
    }
}
