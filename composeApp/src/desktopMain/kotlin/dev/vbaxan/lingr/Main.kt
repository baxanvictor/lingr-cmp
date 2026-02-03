package dev.vbaxan.lingr

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.vbaxan.lingr.di.desktopModule
import dev.vbaxan.lingr.di.initKoin

fun main() {
    initKoin {
        modules(desktopModule)
    }

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Lingr",
            resizable = true,
        ) {
            App()
        }
    }
}