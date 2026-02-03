plugins {
    alias(libs.plugins.convention.kotlin.library)
    alias(libs.plugins.convention.buildkonfig)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.touchlab.kermit)
            implementation(libs.koin.core)
        }
    }
}