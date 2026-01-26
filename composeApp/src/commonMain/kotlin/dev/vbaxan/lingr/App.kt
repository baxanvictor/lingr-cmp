package dev.vbaxan.lingr

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.vbaxan.core.designsystem.theme.LingrTheme
import dev.vbaxan.lingr.navigation.NavigationRoot

@Composable
@Preview
fun App(
    isDarkTheme: Boolean = isSystemInDarkTheme()
) {
    LingrTheme(darkTheme = isDarkTheme) {
        Scaffold { innerPadding ->
            NavigationRoot(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}