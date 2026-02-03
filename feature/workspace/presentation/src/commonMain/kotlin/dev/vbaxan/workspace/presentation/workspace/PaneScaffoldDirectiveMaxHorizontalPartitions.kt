package dev.vbaxan.workspace.presentation.workspace

import androidx.compose.runtime.Composable
import dev.vbaxan.core.presentation.util.DeviceConfiguration
import dev.vbaxan.core.presentation.util.currentDeviceConfiguration

@Composable
internal fun paneScaffoldDirectiveMaxHorizontalPartitions(): Int {
    val configuration = currentDeviceConfiguration()

    return when (configuration) {
        DeviceConfiguration.MOBILE_PORTRAIT,
        DeviceConfiguration.TABLET_PORTRAIT -> 1
        DeviceConfiguration.MOBILE_LANDSCAPE,
        DeviceConfiguration.TABLET_LANDSCAPE,
        DeviceConfiguration.DESKTOP -> 2
    }
}