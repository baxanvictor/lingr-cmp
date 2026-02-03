package dev.vbaxan.core.data.app

import dev.vbaxan.core.data.BuildKonfig
import dev.vbaxan.core.domain.app.AppInfoProvider
import dev.vbaxan.core.platform.PlatformUtils

internal class DefaultAppInfoProvider(
    private val platformUtils: PlatformUtils
) : AppInfoProvider {
    override fun provideAppName(): String {
        return BuildKonfig.APP_NAME
    }

    override fun provideAppVersion(): String {
        return platformUtils.getAppVersion()
    }

    override fun provideOsName(): String {
        return platformUtils.getOsName()
    }
}