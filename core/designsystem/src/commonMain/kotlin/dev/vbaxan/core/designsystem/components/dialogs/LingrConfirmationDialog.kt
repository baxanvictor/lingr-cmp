package dev.vbaxan.core.designsystem.components.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import dev.vbaxan.core.designsystem.components.buttons.LingrButton
import dev.vbaxan.core.designsystem.components.buttons.LingrButtonStyle
import lingr.core.designsystem.generated.resources.Res
import lingr.core.designsystem.generated.resources.dismiss_dialog
import org.jetbrains.compose.resources.stringResource

@Composable
fun LingrConfirmationDialog(
    title: String,
    subtitle: CharSequence,
    variant: LingrRemovalConfirmationDialogVariant = LingrRemovalConfirmationDialogVariant.DestructivePrimary,
    confirmButtonText: String,
    cancelButtonText: String,
    onConfirmClick: () -> Unit,
    onCancelClick: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .padding(
                    horizontal = 24.dp,
                    vertical = 16.dp
                )
                .widthIn(max = 480.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                if (subtitle is AnnotatedString) {
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                } else {
                    Text(
                        text = subtitle.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.End),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LingrButton(
                        text = cancelButtonText,
                        onClick = onCancelClick,
                        style = LingrButtonStyle.SECONDARY
                    )
                    LingrButton(
                        text = confirmButtonText,
                        onClick = onConfirmClick,
                        style = variant.confirmButtonStyle
                    )
                }
            }
            IconButton(
                onClick = onDismiss,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .pointerHoverIcon(PointerIcon.Hand)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(Res.string.dismiss_dialog),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

sealed interface LingrRemovalConfirmationDialogVariant {
    val confirmButtonStyle: LingrButtonStyle

    data object Primary : LingrRemovalConfirmationDialogVariant {
        override val confirmButtonStyle: LingrButtonStyle = LingrButtonStyle.PRIMARY
    }

    data object DestructivePrimary : LingrRemovalConfirmationDialogVariant {
        override val confirmButtonStyle: LingrButtonStyle = LingrButtonStyle.DESTRUCTIVE_PRIMARY
    }
}