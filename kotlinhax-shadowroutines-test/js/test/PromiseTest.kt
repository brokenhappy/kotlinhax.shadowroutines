package kotlinhax.shadowroutines.test

import kotlinhax.shadowroutines.*
import kotlin.test.*

class PromiseTest {
    @Test
    fun testCompletionFromPromise() = runTest {
        var promiseEntered = false
        val p = promise {
            delay(1)
            promiseEntered = true
        }
        delay(2)
        p.await()
        assertTrue(promiseEntered)
    }
}