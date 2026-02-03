package dev.vbaxan.core.designsystem.components.icons

import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp

@Composable
fun RotatingIcon(
    imageVector: ImageVector,
    isRotated: Boolean = false,
    iconSize: Dp,
    modifier: Modifier = Modifier,
    iconTint: Color = MaterialTheme.colorScheme.onSurfaceVariant
) {
    val rotation by animateFloatAsState(
        targetValue = if (isRotated) 180f else 0f,
        animationSpec = tween(
            durationMillis = 150,
            easing = EaseOut
        ),
        label = "iconRotation"
    )

    Icon(
        imageVector = imageVector,
        contentDescription = null,
        tint = iconTint,
        modifier = modifier
            .size(iconSize)
            .graphicsLayer { rotationZ = rotation }
    )
}