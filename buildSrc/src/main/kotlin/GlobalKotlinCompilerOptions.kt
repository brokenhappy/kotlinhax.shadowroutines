import org.jetbrains.kotlin.gradle.dsl.KotlinCommonCompilerOptions

internal fun KotlinCommonCompilerOptions.configureGlobalKotlinArgumentsAndOptIns() {
    freeCompilerArgs.addAll("-progressive")
    optIn.addAll(
        "kotlin.experimental.ExperimentalTypeInference",
        // our own opt-ins that we don't want to bother with in our own code:
        "kotlinhax.shadowroutines.DelicateCoroutinesApi",
        "kotlinhax.shadowroutines.ExperimentalCoroutinesApi",
        "kotlinhax.shadowroutines.ObsoleteCoroutinesApi",
        "kotlinhax.shadowroutines.InternalCoroutinesApi",
        "kotlinhax.shadowroutines.FlowPreview"
    )
}
