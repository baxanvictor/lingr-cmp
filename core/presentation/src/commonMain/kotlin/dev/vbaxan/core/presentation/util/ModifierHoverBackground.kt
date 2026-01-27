package dev.vbaxan.core.presentation.util

import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

@Composable
fun Modifier.hoverBackground(
    hoveredColor: Color,
    idleColor: Color = Color.Transparent,
    shape: Shape = RectangleShape
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    return this
        .hoverable(interactionSource)
        .background(
            color = if (isHovered) hoveredColor else idleColor,
            shape = shape
        )
}