package dev.vbaxan.core.platform

expect class PlatformUtils {
    fun currentOs(): OperatingSystem
    fun getOsName(): String
    fun getAppVersion(): String
}