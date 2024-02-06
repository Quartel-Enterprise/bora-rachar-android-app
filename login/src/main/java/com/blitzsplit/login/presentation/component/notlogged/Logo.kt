package com.blitzsplit.login.presentation.component.notlogged

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blitzsplit.login.R
import com.blitzsplit.ui.component.HorizontalSpacer
import com.blitzsplit.ui.theme.BlitzSplitTheme
import com.blitzsplit.ui.theme.Blue500
import com.blitzsplit.ui.theme.UbuntuFontFamily

@Composable
internal fun Logo(
    modifier: Modifier = Modifier,
    iconSize: Dp = 60.dp,
    fontSize: TextUnit = 48.sp
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(iconSize),
            painter = painterResource(id = R.drawable.logo_icon),
            contentDescription = "background login",
            colorFilter = ColorFilter.tint(Blue500)
        )
        HorizontalSpacer(8.dp)
        Text(
            text = "Bora Rachar",
            style = TextStyle(
                fontFamily = UbuntuFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                letterSpacing = 0.sp,
                color = Blue500
            ),
        )
    }
}

@Composable
@Preview(showBackground = true)
fun LogoPreview() {
    BlitzSplitTheme {
        Logo()
    }
}
