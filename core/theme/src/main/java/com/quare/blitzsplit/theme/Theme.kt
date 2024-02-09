package com.quare.blitzsplit.theme

import android.app.Activity
import android.view.View
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val LightColorScheme = lightColorScheme(
    primary = Blue100,
    primaryContainer = Blue300,
    secondary = Blue300,
    secondaryContainer = Blue300,
    tertiary = Blue300,
    surface = Blue100,
    onPrimary = Black200,
    background = Blue100
)

@Composable
fun BlitzSplitTheme(content: @Composable () -> Unit) {
    val colorScheme = LightColorScheme // TODO: Add dark color scheme and adapt with material 3
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.apply {
                statusBarColor = colorScheme.primary.toArgb()
                // TODO: resolve system ui visibility deprecated (material 3)
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
