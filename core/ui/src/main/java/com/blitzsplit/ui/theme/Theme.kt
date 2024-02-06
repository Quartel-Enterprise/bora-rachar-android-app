package com.blitzsplit.ui.theme

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = BabyBlue,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    surface = BabyBlue,
    onPrimary = Black200,
    background = BabyBlue,
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
