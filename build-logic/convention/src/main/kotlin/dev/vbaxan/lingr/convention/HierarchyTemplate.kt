@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

package dev.vbaxan.lingr.convention

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinHierarchyTemplate
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

private val hierarchyTemplate = KotlinHierarchyTemplate {
    withSourceSetTree(
        KotlinSourceSetTree.main,
        KotlinSourceSetTree.test
    )

    common {
        withCompilations { true }

        group("jvmCommon") {
            withJvm()
        }

        group("native") {
            withNative()

            group("apple") {
                withApple()

                group("macos") {
                    withMacos()
                }
            }
        }

        group("desktop") {
            group("macos") {
                withMacos()
            }

            group("linux") {
                withLinux()
            }
        }
    }
}

internal fun KotlinMultiplatformExtension.applyHierarchyTemplate() {
    applyHierarchyTemplate(hierarchyTemplate)
}