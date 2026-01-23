import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import dev.vbaxan.lingr.convention.libs as tomlLibs

plugins {
    alias(libs.plugins.convention.cmp.module.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.koin.common)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.jsystemthemedetector)
        }
    }
}

val appName = tomlLibs.findVersion("appName").get().toString()
val desktopDistVersion = tomlLibs.findVersion("desktopDistVersion").get().toString()
val projectApplicationId = tomlLibs.findVersion("projectApplicationId").get().toString()

compose.desktop {
    application {
        mainClass = "dev.vbaxan.lingr.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Deb)
            packageName = appName
            packageVersion = desktopDistVersion
            includeAllModules = true

            macOS {
                bundleID = projectApplicationId
                appCategory = "public.app-category.utilities"
                minimumSystemVersion = "12.0"
                packageBuildVersion = desktopDistVersion

                // TODO: set iconFile
            }

            linux {
                // TODO: set iconFile
            }
        }
    }
}