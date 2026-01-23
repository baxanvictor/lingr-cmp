package dev.vbaxan.lingr.convention

import org.gradle.api.Project

internal fun Project.pathToPackageName(): String {
    val relativePackageName = path
        .replace(':', '.')
        .lowercase()

    return "dev.vbaxan$relativePackageName"
}