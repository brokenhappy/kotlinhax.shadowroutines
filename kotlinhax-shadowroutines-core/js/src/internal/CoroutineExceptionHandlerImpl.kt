package kotlinhax.shadowroutines.internal

import kotlinhax.shadowroutines.*

internal actual fun propagateExceptionFinalResort(exception: Throwable) {
    // log exception
    console.error(exception.toString())
}