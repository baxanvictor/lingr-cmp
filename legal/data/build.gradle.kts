plugins {
    alias(libs.plugins.convention.kotlin.library)
    alias(libs.plugins.convention.buildkonfig)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.data)
            implementation(projects.core.domain)

            implementation(libs.koin.core)
        }
    }
}