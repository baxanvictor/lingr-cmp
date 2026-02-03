package dev.vbaxan.core.designsystem.components.popups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.vbaxan.core.designsystem.components.brand.LingrHorizontalDivider
import dev.vbaxan.core.designsystem.components.buttons.CloseIconButton
import dev.vbaxan.core.designsystem.theme.extended
import dev.vbaxan.core.presentation.util.UiText

@Composable
internal fun LingrPopupTopBar(
    modifier: Modifier = Modifier,
    variant: InternalPopupTopBarVariant
) {
    val topBarContent: @Composable () -> Unit = {
        when (variant) {
            InternalPopupTopBarVariant.NoTopBar -> {}

            is InternalPopupTopBarVariant.CloseButton -> Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                CloseIconButton(
                    onCloseClick = variant.onClick
                )
            }

            is InternalPopupTopBarVariant.Title -> Text(
                text = variant.title.asString(),
                style = MaterialTheme.typography.extended.titleXSmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(start = 16.dp)
            )

            is InternalPopupTopBarVariant.TitleWithCloseButton -> Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = variant.title.asString(),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                )
                CloseIconButton(
                    onCloseClick = variant.onCloseClick
                )
            }
        }
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        topBarContent()
        if (variant != InternalPopupTopBarVariant.NoTopBar) {
            LingrHorizontalDivider(modifier = Modifier.fillMaxWidth())
        }
    }
}

internal sealed interface InternalPopupTopBarVariant {
    data object NoTopBar : InternalPopupTopBarVariant
    data class CloseButton(val onClick: () -> Unit) : InternalPopupTopBarVariant
    data class Title(val title: UiText) : InternalPopupTopBarVariant
    data class  TitleWithCloseButton(
        val title: UiText,
        val onCloseClick: () -> Unit
    ) : InternalPopupTopBarVariant
}