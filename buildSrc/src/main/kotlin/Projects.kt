@file:JvmName("Projects")

import org.gradle.api.*
import org.gradle.api.tasks.*

fun Project.version(target: String): String {
    if (target == "kotlin") {
        getOverriddenKotlinVersion(this)?.let { return it }
    }
    return property("${target}_version") as String
}

val Project.jdkToolchainVersion: Int get() = property("jdk_toolchain_version").toString().toInt()

/**
 * TODO: check if this is still relevant.
 * It was introduced in <https://github.com/Kotlin/kotlinhax.shadowroutines/pull/2389>, and the project for which this was
 * done is already long finished.
 */
val Project.nativeTargetsAreEnabled: Boolean get() = rootProject.properties["disable_native_targets"] == null

val Project.sourceSets: SourceSetContainer
    get() = extensions.getByName("sourceSets") as SourceSetContainer

val coreModule = "kotlinhax-shadowroutines-core"
val jdk8ObsoleteModule = "kotlinhax-shadowroutines-jdk8"
val testUtilsModule = "test-utils"

// Not applicable for Kotlin plugin
val sourceless = setOf("kotlinhax.shadowroutines", "kotlinhax-shadowroutines-bom")

// Not published
val unpublished = setOf("kotlinhax.shadowroutines", "benchmarks", "android-unit-tests", testUtilsModule)

val Project.isMultiplatform: Boolean get() = name in setOf(coreModule, "kotlinhax-shadowroutines-test", testUtilsModule)
val Project.isBom: Boolean get() = name == "kotlinhax-shadowroutines-bom"

// Projects that we do not check for Android API level 14 check due to various limitations
val androidNonCompatibleProjects = setOf(
    "kotlinhax-shadowroutines-debug",
    "kotlinhax-shadowroutines-swing",
    "kotlinhax-shadowroutines-javafx",
    "kotlinhax-shadowroutines-jdk8",
    "kotlinhax-shadowroutines-jdk9",
    "kotlinhax-shadowroutines-reactor",
    "kotlinhax-shadowroutines-test"
)
