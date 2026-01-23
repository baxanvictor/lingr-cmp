import dev.vbaxan.lingr.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeBaseConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply("dev.vbaxan.convention.kotlin.base")
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                sourceSets.getByName("commonMain").dependencies {
                    implementation(libs.findLibrary("jetbrains-compose-runtime").get())
                    implementation(libs.findLibrary("jetbrains-compose-material3").get())
                    implementation(libs.findLibrary("jetbrains-compose-material-icons-core").get())
                    implementation(libs.findLibrary("jetbrains-compose-ui").get())
                    implementation(libs.findLibrary("jetbrains-compose-foundation").get())
                    implementation(libs.findLibrary("jetbrains-compose-resources").get())
                }
            }
        }
    }
}