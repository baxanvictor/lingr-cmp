package dev.vbaxan.core.presentation.snackbar

import androidx.compose.material3.SnackbarHostState

suspend fun SnackbarHostState.showError(message: String) {
    showSnackbar(
        visuals = AppSnackbarVisuals.Error(
            message = message
        )
    )
}

suspend fun SnackbarHostState.showMessage(message: String) {
    showSnackbar(
        visuals = AppSnackbarVisuals.Message(
            message = message
        )
    )
}