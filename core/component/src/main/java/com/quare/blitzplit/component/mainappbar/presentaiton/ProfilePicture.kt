package com.quare.blitzplit.component.mainappbar.presentaiton

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
internal fun ProfilePicture(
    photoUrl: String?,
    onPhotoClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
) {
    val profileResource = painterResource(id = R.drawable.profile_icon)
    AsyncImage(
        model = photoUrl,
        modifier = modifier
            .clip(CircleShape)
            .size(size)
            .clickable(onClick = onPhotoClick),
        contentDescription = "User profile",
        contentScale = ContentScale.Crop,
        error = profileResource,
        placeholder = profileResource
    )
}
