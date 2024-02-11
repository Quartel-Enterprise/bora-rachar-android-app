package com.quare.blitzplit.component.picture

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter

@Composable
fun Picture(
    url: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    onPhotoClick: (() -> Unit)? = null,
    error: Painter? = null,
    placeholder: Painter? = null,
    onLoading: ((AsyncImagePainter.State.Loading) -> Unit)? = null,
    contentDescription: String
) {
    AsyncImage(
        model = url,
        modifier = modifier.modifyBasedOnClick(onPhotoClick),
        contentDescription = contentDescription,
        contentScale = contentScale,
        error = error,
        placeholder = placeholder,
        onLoading = onLoading
    )
}

private fun Modifier.modifyBasedOnClick(
    onPhotoClick: (() -> Unit)?,
): Modifier = onPhotoClick?.let {
    this.clickable(onClick = onPhotoClick)
} ?: this

