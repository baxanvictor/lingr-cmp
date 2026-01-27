package dev.vbaxan.core.designsystem.components.brand

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LingrHorizontalDivider(
    modifier: Modifier = Modifier,
    transparency: Float = 1.0f,
    color: Color = MaterialTheme.colorScheme.outline
) {
    HorizontalDivider(
        modifier = modifier.fillMaxWidth(),
        color = if (transparency == 1.0f) color else color.copy(alpha = transparency)
    )
}
