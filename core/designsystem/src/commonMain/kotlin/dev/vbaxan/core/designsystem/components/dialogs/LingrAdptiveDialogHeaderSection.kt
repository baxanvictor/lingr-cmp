package dev.vbaxan.core.designsystem.components.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import lingr.core.designsystem.generated.resources.Res
import lingr.core.designsystem.generated.resources.cancel
import org.jetbrains.compose.resources.stringResource

@Composable
fun LingrAdaptiveDialogHeaderSection(
    title: String? = null,
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier,
    verticalPadding: Dp = 16.dp
) {
    Row(
        modifier = modifier
            .padding(
                horizontal = 20.dp,
                vertical = verticalPadding
            ),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.End),
        verticalAlignment = Alignment.CenterVertically
    ) {
        title?.let {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .weight(1f)
            )
        }
        IconButton(
            modifier = Modifier
                .pointerHoverIcon(PointerIcon.Hand),
            onClick = onCloseClick
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = stringResource(Res.string.cancel),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}