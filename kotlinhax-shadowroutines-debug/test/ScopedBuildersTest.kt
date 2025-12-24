package kotlinhax.shadowroutines.debug

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import org.junit.*
import kotlin.coroutines.*

class ScopedBuildersTest : DebugTestBase() {

    @Test
    fun testNestedScopes() = runBlocking {
        val job = launch { doInScope() }
        yield()
        yield()
        verifyDump(
            "Coroutine \"coroutine#1\":BlockingCoroutine{Active}@16612a51, state: RUNNING",

            "Coroutine \"coroutine#2\":StandaloneCoroutine{Active}@6b53e23f, state: SUSPENDED\n" +
                "\tat kotlinhax.shadowroutines.debug.ScopedBuildersTest\$doWithContext\$2.invokeSuspend(ScopedBuildersTest.kt:49)\n" +
                "\tat kotlinhax.shadowroutines.debug.ScopedBuildersTest.doWithContext(ScopedBuildersTest.kt:47)\n" +
                "\tat kotlinhax.shadowroutines.debug.ScopedBuildersTest\$doInScope\$2.invokeSuspend(ScopedBuildersTest.kt:41)\n" +
                "\tat kotlinhax.shadowroutines.debug.ScopedBuildersTest\$testNestedScopes\$1\$job\$1.invokeSuspend(ScopedBuildersTest.kt:30)"
        )
        job.cancelAndJoin()
        finish(4)
    }

    private suspend fun doInScope() = coroutineScope {
        expect(1)
        doWithContext()
        expectUnreached()
    }

    private suspend fun doWithContext() {
        expect(2)
        withContext(wrapperDispatcher(coroutineContext)) {
            expect(3)
            delay(Long.MAX_VALUE)
        }
        expectUnreached()
    }
}
