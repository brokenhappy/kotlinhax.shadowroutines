package kotlinhax.shadowroutines.test
import kotlinhax.shadowroutines.*

public actual typealias TestResult = Unit

internal actual fun createTestResult(testProcedure: suspend CoroutineScope.() -> Unit) {
    runBlocking {
        testProcedure()
    }
}

internal actual fun systemPropertyImpl(name: String): String? = null

internal actual fun dumpCoroutines() { }
