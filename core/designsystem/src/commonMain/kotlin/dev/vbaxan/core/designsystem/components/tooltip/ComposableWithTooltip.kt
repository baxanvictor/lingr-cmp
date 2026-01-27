@file:OptIn(ExperimentalMaterial3Api::class)

package dev.vbaxan.core.designsystem.components.tooltip

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.vbaxan.core.presentation.util.actionOnHover

@Composable
fun ComposableWithTooltip(
    tooltipText: String,
    tooltipPosition: TooltipPosition = TooltipPosition.BELOW,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val tooltipState = rememberTooltipState()

    TooltipBox(
        state = tooltipState,
        enableUserInput = false,
        positionProvider = TooltipDefaults.rememberTooltipPositionProvider(
            positioning = tooltipPosition.toTooltipAnchorPosition()
        ),
        tooltip = {
            PlainTooltip {
                Text(
                    text = tooltipText
                )
            }
        },
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .actionOnHover(
                    onHovered = { tooltipState.show() },
                    onHoverStopped = { tooltipState.dismiss() }
                )
        ) {
            content()
        }
    }
}

private fun TooltipPosition.toTooltipAnchorPosition(): TooltipAnchorPosition {
    return when (this) {
        TooltipPosition.ABOVE -> TooltipAnchorPosition.Above
        TooltipPosition.BELOW -> TooltipAnchorPosition.Below
        TooltipPosition.LEFT -> TooltipAnchorPosition.Left
        TooltipPosition.RIGHT -> TooltipAnchorPosition.Right
        TooltipPosition.START -> TooltipAnchorPosition.Start
        TooltipPosition.END -> TooltipAnchorPosition.End
    }
}

enum class TooltipPosition {
    ABOVE,
    BELOW,
    LEFT,
    RIGHT,
    START,
    END
}