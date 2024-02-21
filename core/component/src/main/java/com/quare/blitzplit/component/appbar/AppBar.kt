package com.quare.blitzplit.component.appbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.quare.blitzsplit.theme.BlitzSplitTheme

@ExperimentalMaterial3Api
@Composable
fun AppBar(
    title: String,
    menuIcon: ImageVector,
    menuDescription: String,
    menuIconClick: () -> Unit,
    backClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                AppBarTitle(title)
            }
        },
        navigationIcon = {
            IconButton(onClick = backClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = menuDescription,
                )
            }
        },
        actions = {
            IconButton(onClick = menuIconClick) {
                Icon(
                    imageVector = menuIcon,
                    contentDescription = menuDescription,
                )
            }
        }
    )
}

@Composable
private fun AppBarTitle(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
        textAlign = TextAlign.Center
    )
}

@ExperimentalMaterial3Api
@Composable
@Preview
fun AppBarPreview() {
    BlitzSplitTheme {
        AppBar(
            title = "Quartel Otaku",
            menuIcon = Icons.Default.MoreVert,
            menuDescription = "Menu",
            menuIconClick = {},
            backClick = { }
        )
    }
}
