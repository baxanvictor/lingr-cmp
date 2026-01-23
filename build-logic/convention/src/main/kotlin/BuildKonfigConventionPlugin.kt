import com.codingfeline.buildkonfig.gradle.BuildKonfigExtension
import dev.vbaxan.lingr.convention.pathToPackageName
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class BuildKonfigConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.codingfeline.buildkonfig")

            extensions.configure<BuildKonfigExtension> {
                defaultConfigs {
                    packageName = target.pathToPackageName()
                }
            }
        }
    }
}