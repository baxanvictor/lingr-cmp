package dev.vbaxan.core.designsystem.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp

enum class LingrButtonStyle {
    PRIMARY,
    DESTRUCTIVE_PRIMARY,
    SECONDARY,
    DESTRUCTIVE_SECONDARY
}

@Composable
fun LingrButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: LingrButtonStyle = LingrButtonStyle.PRIMARY,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    val transparencyValue = 0.38f

    val contentColor = when (style) {
        LingrButtonStyle.PRIMARY -> MaterialTheme.colorScheme.onPrimary
        LingrButtonStyle.DESTRUCTIVE_PRIMARY -> MaterialTheme.colorScheme.onError
        LingrButtonStyle.SECONDARY -> MaterialTheme.colorScheme.onSurface
        LingrButtonStyle.DESTRUCTIVE_SECONDARY -> MaterialTheme.colorScheme.error
    }

    val colors = when (style) {
        LingrButtonStyle.PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = contentColor,
            disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = transparencyValue),
            disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = transparencyValue)
        )

        LingrButtonStyle.DESTRUCTIVE_PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = contentColor,
            disabledContainerColor = MaterialTheme.colorScheme.error.copy(alpha = transparencyValue),
            disabledContentColor = MaterialTheme.colorScheme.onError.copy(alpha = transparencyValue)
        )

        LingrButtonStyle.SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = contentColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = transparencyValue)
        )

        LingrButtonStyle.DESTRUCTIVE_SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = contentColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.error.copy(alpha = transparencyValue)
        )
    }

    val border = when {
        style == LingrButtonStyle.PRIMARY && !enabled -> BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline.copy(alpha = transparencyValue)
        )
        style == LingrButtonStyle.SECONDARY -> BorderStroke(
            width = 1.dp,
            color = if (enabled) {
                MaterialTheme.colorScheme.outline
            } else {
                MaterialTheme.colorScheme.outline.copy(alpha = transparencyValue)
            }
        )
        style == LingrButtonStyle.DESTRUCTIVE_SECONDARY -> {
            BorderStroke(
                width = 1.dp,
                color = if (enabled) {
                    MaterialTheme.colorScheme.error
                } else {
                    MaterialTheme.colorScheme.error.copy(alpha = transparencyValue)
                }
            )
        }
        else -> null
    }

    Button(
        onClick = onClick,
        modifier = modifier
            .pointerHoverIcon(PointerIcon.Hand),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        colors = colors,
        border = border
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(6.dp)
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(15.dp)
                    .alpha(
                        alpha = if (isLoading) 1f else 0f
                    ),
                strokeWidth = 1.5.dp,
                color = contentColor
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    8.dp,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.alpha(
                    alpha = if (isLoading) 0f else 1f
                )
            ) {
                leadingIcon?.invoke()
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1
                )
                trailingIcon?.invoke()
            }
        }
    }
}
