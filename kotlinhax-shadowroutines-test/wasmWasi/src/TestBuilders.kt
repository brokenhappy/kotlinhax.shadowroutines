package kotlinhax.shadowroutines.test

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.internal.*
import kotlin.coroutines.*

@Suppress("ACTUAL_WITHOUT_EXPECT")
public actual typealias TestResult = Unit

internal actual fun systemPropertyImpl(name: String): String? = null

internal actual fun createTestResult(testProcedure: suspend CoroutineScope.() -> Unit) =
    runTestCoroutine(EmptyCoroutineContext, testProcedure)

internal actual fun dumpCoroutines() { }