package dev.vbaxan.core.data.settings

import dev.vbaxan.core.domain.settings.AppSettings
import dev.vbaxan.core.domain.settings.AppSettingsStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal class InMemoryAppSettingsStorage(
    defaultScanTargetsProvider: DefaultScanTargetsProvider
) : AppSettingsStorage {
    private val defaultAppSettings = AppSettings(
        defaultScanTargetTypes = defaultScanTargetsProvider.provideDefaultScanTargetTypes()
    )

    private val settingsFlow = MutableStateFlow(defaultAppSettings)

    override fun observeAppSettings(): Flow<AppSettings> = settingsFlow.asStateFlow()

    override suspend fun updateSettings(settings: AppSettings) {
        settingsFlow.update { settings }
    }

    override suspend fun resetSettings() {
        settingsFlow.update { defaultAppSettings }
    }
}