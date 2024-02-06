package com.quare.blitzplit.component.mainappbar.presentaiton

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
internal fun ProfilePicture(
    photoUrl: String?,
    onPhotoClick: () -> Unit,
) {
    AsyncImage(
        model = photoUrl,
        modifier = Modifier
            .clickable(onClick = onPhotoClick)
            .size(32.dp)
            .clip(CircleShape),
        contentDescription = "User profile",
        contentScale = ContentScale.Crop,
    )
}
