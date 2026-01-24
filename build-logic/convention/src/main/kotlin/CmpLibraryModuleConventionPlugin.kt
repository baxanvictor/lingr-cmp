import dev.vbaxan.lingr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class CmpLibraryModuleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply("dev.vbaxan.convention.kotlin.library")
                apply("dev.vbaxan.convention.compose.base")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                sourceSets.getByName("commonMain").dependencies {
                    implementation(libs.findLibrary("jetbrains-lifecycle-compose").get())
                    implementation(libs.findLibrary("jetbrains-compose-viewmodel").get())
                    implementation(libs.findLibrary("jetbrains-navigation3-ui").get())
                    implementation(libs.findLibrary("jetbrains-viewmodel-navigation3").get())
                }
            }
        }
    }
}
