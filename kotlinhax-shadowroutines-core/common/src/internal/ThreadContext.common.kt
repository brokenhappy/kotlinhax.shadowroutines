package kotlinhax.shadowroutines.internal

import kotlin.coroutines.*

internal expect fun threadContextElements(context: CoroutineContext): Any
