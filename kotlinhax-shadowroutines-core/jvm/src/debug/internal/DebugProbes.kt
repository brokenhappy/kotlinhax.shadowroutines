@file:Suppress("unused")

package kotlinhax.shadowroutines.debug.internal

import kotlin.coroutines.*

/*
 * This class is used by ByteBuddy from kotlinhax-shadowroutines-debug as kotlin.coroutines.jvm.internal.DebugProbesKt replacement.
 * In theory, it should belong to kotlinhax-shadowroutines-debug, but placing it here significantly simplifies the
 * Android AS debugger that does on-load DEX transformation
 */

// Stubs which are injected as coroutine probes. Require direct match of signatures
internal fun probeCoroutineResumed(frame: Continuation<*>) = DebugProbesImpl.probeCoroutineResumed(frame)

internal fun probeCoroutineSuspended(frame: Continuation<*>) = DebugProbesImpl.probeCoroutineSuspended(frame)
internal fun <T> probeCoroutineCreated(completion: Continuation<T>): Continuation<T> =
    DebugProbesImpl.probeCoroutineCreated(completion)
