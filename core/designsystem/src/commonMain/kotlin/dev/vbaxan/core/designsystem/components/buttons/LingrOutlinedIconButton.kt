package dev.vbaxan.core.designsystem.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp

@Composable
fun LingrOutlinedIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    displayBorder: Boolean = true,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit
) {
    OutlinedIconButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .size(45.dp)
            .pointerHoverIcon(PointerIcon.Hand),
        shape = RoundedCornerShape(80.dp),
        border = if (displayBorder) {
            BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline
            )
        } else null,
        colors = IconButtonDefaults.outlinedIconButtonColors(
            containerColor = containerColor,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        content()
    }
}