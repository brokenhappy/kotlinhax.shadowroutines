pluginManagement {
    val javafx_plugin_version: String by settings
    plugins {
        id("org.openjfx.javafxplugin") version javafx_plugin_version
        id("me.champeau.jmh") version "0.7.2"
    }

    repositories {
        maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/dokka/dev/")
        gradlePluginPortal()
    }
}

rootProject.name = "kotlinhax.shadowroutines"

fun module(path: String) {
    val i = path.lastIndexOf("/")
    val name = path.substring(i + 1)
    include(name)
    project(":$name").projectDir = file(path)
}
val prop = System.getProperty("build_snapshot_train")
var build_snapshot_train: String by extra
build_snapshot_train = if (prop != null && prop != "") "true" else "false"
// ---------------------------

include("benchmarks")
module("test-utils")

include("kotlinhax-shadowroutines-core")

module("kotlinhax-shadowroutines-test")
module("kotlinhax-shadowroutines-debug")
module("kotlinhax-shadowroutines-bom")


module("integration/kotlinhax-shadowroutines-guava")
module("integration/kotlinhax-shadowroutines-jdk8")
module("integration/kotlinhax-shadowroutines-slf4j")
module("integration/kotlinhax-shadowroutines-play-services")

module("reactive/kotlinhax-shadowroutines-reactive")
module("reactive/kotlinhax-shadowroutines-reactor")
module("reactive/kotlinhax-shadowroutines-jdk9")
module("reactive/kotlinhax-shadowroutines-rx2")
module("reactive/kotlinhax-shadowroutines-rx3")
module("ui/kotlinhax-shadowroutines-android")
module("ui/kotlinhax-shadowroutines-android/android-unit-tests")
if (JavaVersion.current().isJava11Compatible()) {
    module("ui/kotlinhax-shadowroutines-javafx")
}
module("ui/kotlinhax-shadowroutines-swing")
