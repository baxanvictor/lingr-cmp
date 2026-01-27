package dev.vbaxan.core.designsystem.components.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import dev.vbaxan.core.presentation.snackbar.AppSnackbarVisuals

@Composable
fun LingrSnackbarScaffold(
    snackbarHostState: SnackbarHostState? = null,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.background,
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets.statusBars
            .union(WindowInsets.displayCutout)
            .union(WindowInsets.ime),
        snackbarHost = {
            snackbarHostState?.let {
                SnackbarHost(
                    hostState = snackbarHostState,
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                ) { data ->
                    val visuals = data.visuals as? AppSnackbarVisuals

                    val containerColor: Color
                    val contentColor: Color
                    val leadingIcon: ImageVector?
                    when (visuals) {
                        is AppSnackbarVisuals.Message -> {
                            containerColor = visuals.containerColor
                            contentColor = visuals.contentColor
                            leadingIcon = visuals.leadingIcon
                        }
                        is AppSnackbarVisuals.Error -> {
                            containerColor = visuals.containerColor
                            contentColor = visuals.contentColor
                            leadingIcon = visuals.leadingIcon
                        }
                        else -> {
                            containerColor = MaterialTheme.colorScheme.surface
                            contentColor = MaterialTheme.colorScheme.onSurface
                            leadingIcon = null
                        }
                    }

                    Snackbar(
                        containerColor = containerColor,
                        contentColor = contentColor
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            leadingIcon?.let {
                                Icon(
                                    imageVector = leadingIcon,
                                    contentDescription = null,
                                    tint = contentColor,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                            Text(
                                data.visuals.message
                            )
                        }
                    }
                }
            }
        },
        containerColor = containerColor,
        floatingActionButton = floatingActionButton
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding),
        ) {
            content()
        }
    }
}