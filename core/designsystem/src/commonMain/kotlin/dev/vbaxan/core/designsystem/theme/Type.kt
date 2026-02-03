package dev.vbaxan.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import lingr.core.designsystem.generated.resources.Res
import lingr.core.designsystem.generated.resources.inter_18pt_bold
import lingr.core.designsystem.generated.resources.inter_18pt_light
import lingr.core.designsystem.generated.resources.inter_18pt_medium
import lingr.core.designsystem.generated.resources.inter_18pt_regular
import lingr.core.designsystem.generated.resources.inter_18pt_semibold
import lingr.core.designsystem.generated.resources.roboto_mono_medium
import org.jetbrains.compose.resources.Font

private val Inter @Composable get() = FontFamily(
    Font(
        resource = Res.font.inter_18pt_light,
        weight = FontWeight.Light
    ),
    Font(
        resource = Res.font.inter_18pt_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resource = Res.font.inter_18pt_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resource = Res.font.inter_18pt_semibold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resource = Res.font.inter_18pt_bold,
        weight = FontWeight.Bold
    )
)

private val RobotoMono @Composable get() = FontFamily(
    Font(
        resource = Res.font.roboto_mono_medium,
        weight = FontWeight.Medium
    )
)

val Typography @Composable get() = Typography(
    bodySmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
)

val AppExtendedTypography @Composable get() = ExtendedTypography(
    titleXSmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 18.sp
    ),
    monoLabelSmall = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),
    monoLabelMedium = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
)

@Immutable
data class ExtendedTypography(
    val titleXSmall: TextStyle,
    val monoLabelSmall: TextStyle,
    val monoLabelMedium: TextStyle
)