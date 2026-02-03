import com.codingfeline.buildkonfig.compiler.FieldSpec
import com.codingfeline.buildkonfig.gradle.BuildKonfigExtension
import dev.vbaxan.lingr.convention.libs
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

                    buildConfigField(
                        FieldSpec.Type.STRING,
                        "APP_NAME",
                        libs.findVersion("appName").get().toString()
                    )

                    buildConfigField(
                        FieldSpec.Type.STRING,
                        "DESKTOP_APP_VERSION",
                        libs.findVersion("desktopAppVersion").get().toString()
                    )
                }
            }
        }
    }
}