package com.quare.blitzsplit.groups.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.quare.blitzsplit.groups.domain.MainAppBarModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    data: MainAppBarModel,
    onPhotoClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Row {
                data.balanceToPay?.let {
                    Text(text = it)
                }
                data.balanceReceivable?.let {
                    Text(text = it)
                }
            }
        },
        actions = {
            ProfilePicture(
                photoUrl = data.photoUrl,
                onPhotoClick = onPhotoClick
            )
        }
    )
}

@Composable
private fun ProfilePicture(
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
