package dev.vbaxan.core.domain.settings

import kotlinx.coroutines.flow.Flow

interface AppSettingsStorage {
    fun observeAppSettings(): Flow<AppSettings>
    suspend fun updateSettings(settings: AppSettings)
    suspend fun resetSettings()
}