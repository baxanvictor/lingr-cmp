package dev.vbaxan.core.designsystem.components.checkboxes

enum class LingrCheckboxSelectionMode {
    SELECTED,
    UNSELECTED,
    INDETERMINATE
}

val LingrCheckboxSelectionMode.isIndeterminate: Boolean
    get() = this == LingrCheckboxSelectionMode.INDETERMINATE

val LingrCheckboxSelectionMode.isUnselected: Boolean
    get() = this == LingrCheckboxSelectionMode.UNSELECTED