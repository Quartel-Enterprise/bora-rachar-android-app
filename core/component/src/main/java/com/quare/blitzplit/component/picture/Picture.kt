package com.quare.blitzplit.component.picture

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.quare.blitzplit.component.utils.onNullableClick
import com.quare.blitzsplit.component.R

@Composable
fun Picture(
    url: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    onPhotoClick: (() -> Unit)? = null,
    error: Painter? = painterResource(id = R.drawable.quare_logo),
    placeholder: Painter? = null,
    onLoading: ((AsyncImagePainter.State.Loading) -> Unit)? = null,
    onError: ((AsyncImagePainter.State.Error) -> Unit)? = null,
    contentDescription: String?,
) {
    AsyncImage(
        model = url,
        modifier = modifier.onNullableClick(onPhotoClick),
        contentDescription = contentDescription,
        contentScale = contentScale,
        error = error,
        placeholder = placeholder,
        onLoading = onLoading,
        onError = onError,
    )
}
