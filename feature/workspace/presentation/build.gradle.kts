plugins {
    alias(libs.plugins.convention.cmp.module.feature)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.designsystem)
            implementation(projects.core.domain)
            implementation(projects.core.platform)
            implementation(projects.core.presentation)

            implementation(projects.feature.workspace.domain)

            implementation(libs.material3.adaptive)
            implementation(libs.material3.adaptive.layout)
            implementation(libs.material3.adaptive.navigation)
        }
    }
}