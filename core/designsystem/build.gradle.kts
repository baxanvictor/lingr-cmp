plugins {
    alias(libs.plugins.convention.cmp.module.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.data)
            implementation(projects.core.presentation)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}

compose.resources {
    publicResClass = true
}