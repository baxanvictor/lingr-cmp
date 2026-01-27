package dev.vbaxan.core.designsystem.components.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.vbaxan.core.presentation.util.currentDeviceConfiguration

@Composable
fun LingrAdaptiveDialogSheetLayout(
    onDismiss: () -> Unit,
    maxDialogHeight: Dp = 960.dp,
    content: @Composable () -> Unit
) {
    val configuration = currentDeviceConfiguration()
    if (configuration.isMobile) {
        LingrBottomSheet(
            onDismiss = onDismiss,
            content = content
        )
    } else {
        LingrDialogContent(
            onDismiss = onDismiss,
            maxHeight = maxDialogHeight,
            content = content
        )
    }
}