package com.quare.blitzsplit.main.presentation.component.dialog

import androidx.compose.runtime.Composable
import com.quare.blitzplit.component.dialog.bill.BillBottomSheet
import com.quare.blitzplit.component.dialog.bill.list.BillDialogListComponent
import com.quare.blitzsplit.main.domain.model.MainModalType

@Composable
fun MainScreenDialog(model: MainModalType) {
    model.run {
        when (this) {
            is MainModalType.Logout -> LogoutDialog(
                onLogout = onLogout,
                onDismiss = onDismiss
            )

            is MainModalType.Bill -> BillBottomSheet(
                title = title,
                onDismiss = onDismiss,
                middleContent = {
                    BillDialogListComponent(
                        data = items,
                        onConfirmButtonClick = onConfirmButtonClick,
                        onRevertButtonClick = onRevertButtonClick,
                        mustShowRevertButton = mustShowRevertButton
                    )
                },
                textInfo = textInfo
            )
        }
    }
}
