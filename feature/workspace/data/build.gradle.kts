plugins {
    alias(libs.plugins.convention.kotlin.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.data)
            implementation(projects.core.domain)

            implementation(projects.feature.workspace.domain)

            implementation(libs.koin.core)
        }
    }
}