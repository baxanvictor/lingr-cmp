import dev.vbaxan.lingr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class CmpFeatureModuleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("dev.vbaxan.convention.cmp.module.library")

            extensions.configure<KotlinMultiplatformExtension> {
                sourceSets.getByName("commonMain").dependencies {
                    implementation(
                        project.dependencies.platform(libs.findLibrary("koin-bom").get())
                    )
                    implementation(
                        project.dependencies.platform(libs.findLibrary("androidx-compose-bom").get())
                    )

                    implementation(libs.findLibrary("koin-compose").get())
                    implementation(libs.findLibrary("koin-compose-viewmodel").get())

                    implementation(libs.findLibrary("jetbrains-lifecycle-viewmodel-savedstate").get())
                    implementation(libs.findLibrary("jetbrains-savedstate").get())
                    implementation(libs.findLibrary("jetbrains-bundle").get())
                    implementation(libs.findLibrary("jetbrains-compose-navigation").get())
                }
            }
        }
    }
}