import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

kotlin {
    sourceSets {
        jvmTest {
            dependencies {
                implementation(project(":kotlinhax-shadowroutines-debug"))
            }
        }
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        nodejs {
            testTask {
                filter.apply {
                    // https://youtrack.jetbrains.com/issue/KT-61888
                    excludeTest("TestDispatchersTest", "testMainMocking")
                }
            }
        }
    }
}
