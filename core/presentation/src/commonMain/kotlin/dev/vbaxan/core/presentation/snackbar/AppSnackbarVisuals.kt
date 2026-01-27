package dev.vbaxan.core.presentation.snackbar

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import lingr.core.presentation.generated.resources.Res
import lingr.core.presentation.generated.resources.error_icon
import org.jetbrains.compose.resources.vectorResource

sealed interface AppSnackbarVisuals : SnackbarVisuals {
    @get:Composable
    val containerColor: Color

    @get:Composable
    val contentColor: Color

    @get:Composable
    val leadingIcon: ImageVector?

    data class Message(
        override val message: String,
        override val actionLabel: String? = null,
        override val withDismissAction: Boolean = false,
        override val duration: SnackbarDuration = SnackbarDuration.Short
    ) : AppSnackbarVisuals {
        override val containerColor: Color
            @Composable get() = MaterialTheme.colorScheme.surface

        override val contentColor: Color
            @Composable get() = MaterialTheme.colorScheme.onSurface

        override val leadingIcon: ImageVector?
            @Composable get() = null
    }

    data class Error(
        override val message: String,
        override val actionLabel: String? = null,
        override val withDismissAction: Boolean = false,
        override val duration: SnackbarDuration = SnackbarDuration.Short
    ) : AppSnackbarVisuals {
        override val containerColor: Color
            @Composable get() = MaterialTheme.colorScheme.errorContainer

        override val contentColor: Color
            @Composable get() = MaterialTheme.colorScheme.onErrorContainer

        override val leadingIcon: ImageVector
            @Composable get() = vectorResource(Res.drawable.error_icon)
    }
}