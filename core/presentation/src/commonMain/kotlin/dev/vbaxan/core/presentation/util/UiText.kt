package dev.vbaxan.core.presentation.util

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource

sealed interface UiText {
    data class Literal(val text: String) : UiText
    class Resource(
        val id: StringResource,
        val args: Array<Any> = arrayOf()
    ) : UiText

    @Composable
    fun asString(): String {
        return when (this) {
            is Literal -> text
            is Resource -> stringResource(
                resource = id,
                formatArgs = args
            )
        }
    }

    suspend fun asStringAsync(): String {
        return when (this) {
            is Literal -> text
            is Resource -> getString(
                resource = id,
                formatArgs = args
            )
        }
    }
}