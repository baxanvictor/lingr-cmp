package dev.vbaxan.core.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalExtendedColors = staticCompositionLocalOf { LightExtendedColors }
val LocalExtendedTypography = staticCompositionLocalOf<ExtendedTypography> {
    error("Font not provided")
}

val ColorScheme.extended: ExtendedColors
    @ReadOnlyComposable
    @Composable
    get() = LocalExtendedColors.current

val Typography.extended: ExtendedTypography
    @ReadOnlyComposable
    @Composable
    get() = LocalExtendedTypography.current

@Immutable
data class ExtendedColors(
    // Hover
    val hoverColor: Color,
    val destructiveHover: Color,
    val infoHighlight: Color
)

val LightColorScheme = lightColorScheme(
    primary = SignalTeal500,
    onPrimary = Base0,
    primaryContainer = SignalTeal300,
    onPrimaryContainer = SignalTeal900,

    secondary = Base700,
    onSecondary = Base0,
    secondaryContainer = Base800,
    onSecondaryContainer = Base150,

    error = Red500,
    onError = Base0,

    errorContainer = Red200,
    onErrorContainer = Red600,

    background = Base0,
    onBackground = Base900,
    surface = Base150,
    onSurface = Base900,
    surfaceVariant = Base150,
    onSurfaceVariant = Base700,

    outline = Base900.copy(alpha = 0.12f)
)

val DarkColorScheme = darkColorScheme(
    primary = SignalTeal500,
    onPrimary = Base0,
    primaryContainer = SignalTeal800,
    onPrimaryContainer = SignalTeal300,

    secondary = Base400,
    onSecondary = Base0,
    secondaryContainer = Base800,
    onSecondaryContainer = Base150,

    error = Red500,
    onError = Base0,
    errorContainer = Red600,
    onErrorContainer = Red200,

    background = Base1000,
    onBackground = Base0,
    surface = Base950,
    onSurface = Base0,
    surfaceVariant = Base900,
    onSurfaceVariant = Base150,

    outline = Base0.copy(alpha = 0.12f)
)

val LightExtendedColors = ExtendedColors(
    hoverColor = SignalTeal500.copy(alpha = 0.04f),
    destructiveHover = Red500.copy(alpha = 0.08f),
    infoHighlight = SignalTeal500.copy(alpha = 0.12f)
)

val DarkExtendedColors = ExtendedColors(
    hoverColor = SignalTeal500.copy(alpha = 0.08f),
    destructiveHover = Red500.copy(alpha = 0.16f),
    infoHighlight = SignalTeal500.copy(alpha = 0.2f)
)