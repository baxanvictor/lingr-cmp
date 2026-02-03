package dev.vbaxan.workspace.presentation.mappers

import dev.vbaxan.core.designsystem.components.checkboxes.LingrCheckboxSelectionMode
import dev.vbaxan.workspace.presentation.model.RecommendedTargetsSelection

internal fun RecommendedTargetsSelection.toCheckboxSelectionMode(): LingrCheckboxSelectionMode {
    return when (this) {
        RecommendedTargetsSelection.ALL -> LingrCheckboxSelectionMode.SELECTED
        RecommendedTargetsSelection.SOME -> LingrCheckboxSelectionMode.INDETERMINATE
        RecommendedTargetsSelection.NONE -> LingrCheckboxSelectionMode.UNSELECTED
    }
}