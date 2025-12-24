import org.jetbrains.kotlin.gradle.dsl.*

plugins {
    // apply plugin to use autocomplete for Kover DSL
    id("org.jetbrains.kotlinx.kover")
}

dependencies {
    api("io.projectreactor:reactor-core:${version("reactor")}")
    api(project(":kotlinhax-shadowroutines-reactive"))
}

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileKotlin {
        compilerOptions.jvmTarget = JvmTarget.JVM_1_8
    }

    compileTestKotlin {
        compilerOptions.jvmTarget = JvmTarget.JVM_1_8
    }
}

// the version of the docs can be different from the version of the Reactor
// library itself: https://github.com/reactor/reactor-core/issues/3794
externalDocumentationLink(
    url = "https://projectreactor.io/docs/core/${version("reactor_docs")}/api/"
)


kover {
    reports {
        filters {
            excludes {
                classes(
                    "kotlinhax.shadowroutines.reactor.FlowKt", // Deprecated
                    "kotlinhax.shadowroutines.reactor.ConvertKt\$asFlux$1" // Deprecated
                )
            }
        }
    }
}
