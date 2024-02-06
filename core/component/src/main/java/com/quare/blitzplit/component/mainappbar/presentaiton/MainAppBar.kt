package com.quare.blitzplit.component.mainappbar.presentaiton

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel

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
