plugins {
    alias(libs.plugins.convention.kotlin.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.domain)
        }
    }
}