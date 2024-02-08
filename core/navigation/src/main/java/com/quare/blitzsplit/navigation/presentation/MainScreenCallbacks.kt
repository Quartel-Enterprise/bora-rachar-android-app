package com.quare.blitzsplit.navigation.presentation

data class MainScreenCallbacks(
    val onPhotoClick: () -> Unit,
    val onClickToPay: () -> Unit,
    val onClickToReceive: () -> Unit,
)
