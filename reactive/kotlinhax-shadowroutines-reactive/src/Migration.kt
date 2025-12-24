@file:JvmMultifileClass
@file:JvmName("FlowKt")

package kotlinhax.shadowroutines.reactive

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.flow.*
import org.reactivestreams.*

// Binary compatibility with Spring 5.2 RC
/** @suppress */
@Deprecated(
    message = "Replaced in favor of ReactiveFlow extension, please import kotlinhax.shadowroutines.reactive.* instead of kotlinhax.shadowroutines.reactive.FlowKt",
    level = DeprecationLevel.HIDDEN
)
@JvmName("asFlow")
public fun <T : Any> Publisher<T>.asFlowDeprecated(): Flow<T> = asFlow()

// Binary compatibility with Spring 5.2 RC
/** @suppress */
@Deprecated(
    message = "Replaced in favor of ReactiveFlow extension, please import kotlinhax.shadowroutines.reactive.* instead of kotlinhax.shadowroutines.reactive.FlowKt",
    level = DeprecationLevel.HIDDEN
)
@JvmName("asPublisher")
public fun <T : Any> Flow<T>.asPublisherDeprecated(): Publisher<T> = asPublisher()

/** @suppress */
@Deprecated(
    message = "batchSize parameter is deprecated, use .buffer() instead to control the backpressure",
    level = DeprecationLevel.HIDDEN,
    replaceWith = ReplaceWith("asFlow().buffer(batchSize)", imports = ["kotlinhax.shadowroutines.flow.*"])
)
public fun <T : Any> Publisher<T>.asFlow(batchSize: Int): Flow<T> = asFlow().buffer(batchSize)
