plugins {
    alias(libs.plugins.convention.cmp.module.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.domain)

            implementation(libs.bundles.koin.common)

            implementation(libs.material3.adaptive)
            implementation(libs.material3.adaptive.layout)
        }
    }
}