package dev.vbaxan.core.domain.app

interface AppInfoProvider {
    fun provideAppName(): String
    fun provideAppVersion(): String
    fun provideOsName(): String
}