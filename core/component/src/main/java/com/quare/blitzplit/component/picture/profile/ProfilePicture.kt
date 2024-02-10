package com.quare.blitzplit.component.picture.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.quare.blitzsplit.component.R

@Composable
fun ProfilePicture(
    photoUrl: String?,
    modifier: Modifier = Modifier,
    onPhotoClick: (() -> Unit)? = null,
    size: Dp = 40.dp,
) {
    val profileResource = painterResource(id = R.drawable.profile_icon)
    AsyncImage(
        model = photoUrl,
        modifier = modifier.updateWithClick(
            size = size,
            onPhotoClick = onPhotoClick
        ),
        contentDescription = "User profile",
        contentScale = ContentScale.Crop,
        error = profileResource,
        placeholder = profileResource
    )
}

private fun Modifier.updateWithClick(
    size: Dp,
    onPhotoClick: (() -> Unit)?,
): Modifier = onPhotoClick?.let {
    getBaseModifier(size).clickable(onClick = onPhotoClick)
} ?: getBaseModifier(size)

private fun Modifier.getBaseModifier(size: Dp) = this
    .clip(CircleShape)
    .size(size)
