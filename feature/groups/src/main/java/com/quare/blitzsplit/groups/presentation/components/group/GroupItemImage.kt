package com.quare.blitzsplit.groups.presentation.components.group

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.blitzplit.component.picture.Picture

@Composable
fun GroupItemImage(
    name: String,
    imageUrl: String?,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Picture(
            url = imageUrl,
            contentDescription = name
        )
    }
}
