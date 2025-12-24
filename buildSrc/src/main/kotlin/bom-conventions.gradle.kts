import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.*


configure(subprojects.filter { it.name !in unpublished }) {
    if (name == "kotlinhax-shadowroutines-bom" || name == "kotlinhax.shadowroutines") return@configure
    if (isMultiplatform) {
        kotlinExtension.sourceSets.getByName("jvmMain").dependencies {
            api(project.dependencies.platform(project(":kotlinhax-shadowroutines-bom")))
        }
    } else {
        dependencies {
            "api"(platform(project(":kotlinhax-shadowroutines-bom")))
        }
    }
}
