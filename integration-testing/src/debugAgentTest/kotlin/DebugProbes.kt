@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
package kotlin.coroutines.jvm.internal

import kotlinhax.shadowroutines.debug.internal.*
import kotlin.coroutines.*

internal fun <T> probeCoroutineCreated(completion: Continuation<T>): Continuation<T> = DebugProbesImpl.probeCoroutineCreated(completion)

internal fun probeCoroutineResumed(frame: Continuation<*>) = DebugProbesImpl.probeCoroutineResumed(frame)

internal fun probeCoroutineSuspended(frame: Continuation<*>) = DebugProbesImpl.probeCoroutineSuspended(frame)
