package com.quare.blitzplit.component.picture.profile

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.quare.blitzplit.component.picture.Picture
import com.quare.blitzsplit.component.R

@Composable
fun UserProfilePicture(
    photoUrl: String?,
    size: Dp,
    modifier: Modifier = Modifier,
    onPhotoClick: (() -> Unit)? = null,
) {
    val profileResource = painterResource(id = R.drawable.profile_icon)
    Picture(
        modifier = modifier
            .clip(CircleShape)
            .size(size),
        url = photoUrl,
        contentDescription = "User profile",
        onPhotoClick = onPhotoClick,
        error = profileResource,
        placeholder = profileResource
    )
}

