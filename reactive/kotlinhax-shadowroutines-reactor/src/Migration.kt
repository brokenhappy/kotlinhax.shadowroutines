@file:JvmName("FlowKt")

package kotlinhax.shadowroutines.reactor

import kotlinhax.shadowroutines.flow.*
import reactor.core.publisher.*

/** @suppress **/
@Deprecated(
    message = "Replaced in favor of ReactiveFlow extension, please import kotlinhax.shadowroutines.reactor.* instead of kotlinhax.shadowroutines.reactor.FlowKt",
    level = DeprecationLevel.HIDDEN
) // Compatibility with Spring 5.2-RC
@JvmName("asFlux")
public fun <T : Any> Flow<T>.asFluxDeprecated(): Flux<T> = asFlux()
