import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "dev.vbaxan.convention.buildlogic"

dependencies {
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    implementation(libs.buildkonfig.gradlePlugin)
    implementation(libs.buildkonfig.compiler)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("kotlinBase") {
            id = "dev.vbaxan.convention.kotlin.base"
            implementationClass = "KotlinBaseConventionPlugin"
        }
        register("kotlinLibrary") {
            id = "dev.vbaxan.convention.kotlin.library"
            implementationClass = "KotlinLibraryConventionPlugin"
        }
        register("composeBase") {
            id = "dev.vbaxan.convention.compose.base"
            implementationClass = "ComposeBaseConventionPlugin"
        }
        register("cmpLibraryModule") {
            id = "dev.vbaxan.convention.cmp.module.library"
            implementationClass = "CmpLibraryConventionPlugin"
        }
        register("cmpFeatureModule") {
            id = "dev.vbaxan.convention.cmp.module.feature"
            implementationClass = "CmpFeatureModuleConventionPlugin"
        }
        register("buildKonfig") {
            id = "dev.vbaxan.convention.buildkonfig"
            implementationClass = "BuildKonfigConventionPlugin"
        }
    }
}