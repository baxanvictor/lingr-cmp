package dev.vbaxan.core.designsystem.components.popups

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import dev.vbaxan.core.presentation.util.UiText

@Composable
fun LingrPopup(
    onDismiss: () -> Unit,
    popupTrigger: @Composable () -> Unit,
    popupContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    topBarVariant: PopupTopBarVariant = PopupTopBarVariant.NoTopBar,
    isOpen: Boolean = false,
) {
    val density = LocalDensity.current

    var contentWidth by remember { mutableStateOf(0.dp) }

    val popupPositionProvider = remember(density) {
        object : PopupPositionProvider {
            override fun calculatePosition(
                anchorBounds: IntRect,
                windowSize: IntSize,
                layoutDirection: LayoutDirection,
                popupContentSize: IntSize
            ): IntOffset {
                val offsetY = with(density) { 4.dp.toPx() }.toInt()

                return IntOffset(
                    x = anchorBounds.right - with(density) { contentWidth.toPx().toInt() },
                    y = anchorBounds.top + anchorBounds.height + offsetY
                )
            }
        }
    }

    Box(
        modifier = modifier
    ) {
        popupTrigger()
        if (isOpen) {
            Popup(
                popupPositionProvider = popupPositionProvider,
                onDismissRequest = onDismiss
            ) {
                Column(
                    modifier = Modifier
                        .heightIn(max = 440.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.outline,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    LingrPopupTopBar(
                        modifier = Modifier
                            .width(contentWidth),
                        variant = when (topBarVariant) {
                            PopupTopBarVariant.NoTopBar -> InternalPopupTopBarVariant.NoTopBar
                            PopupTopBarVariant.CloseButton -> InternalPopupTopBarVariant.CloseButton(
                                onClick = onDismiss
                            )
                            is PopupTopBarVariant.Title -> InternalPopupTopBarVariant.Title(topBarVariant.title)
                            is PopupTopBarVariant.TitleWithCloseButton -> InternalPopupTopBarVariant.TitleWithCloseButton(
                                title = topBarVariant.title,
                                onCloseClick = onDismiss
                            )
                        }
                    )

                    Box(
                        modifier = Modifier
                            .onSizeChanged { size ->
                                contentWidth = with(density) { size.width.toDp() }
                            }
                            .verticalScroll(rememberScrollState())
                    ) {
                        popupContent()
                    }
                }
            }
        }
    }
}

sealed interface PopupTopBarVariant {
    data object NoTopBar : PopupTopBarVariant
    data object CloseButton : PopupTopBarVariant
    data class Title(val title: UiText) : PopupTopBarVariant
    data class TitleWithCloseButton(val title: UiText) : PopupTopBarVariant
}