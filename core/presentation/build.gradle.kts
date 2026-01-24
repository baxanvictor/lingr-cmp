plugins {
    alias(libs.plugins.convention.cmp.module.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.domain)

            implementation(libs.bundles.koin.common)
        }
    }
}