package dev.vbaxan.core.designsystem.components.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import lingr.core.designsystem.generated.resources.Res
import lingr.core.designsystem.generated.resources.cancel
import org.jetbrains.compose.resources.stringResource

@Composable
fun CloseIconButton(
    onCloseClick: () -> Unit
) {
    IconButton(
        onClick = onCloseClick,
        modifier = Modifier
            .pointerHoverIcon(PointerIcon.Hand)
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(Res.string.cancel),
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(18.dp)
        )
    }
}