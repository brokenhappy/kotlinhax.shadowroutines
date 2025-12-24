package kotlinhax.shadowroutines.debug

import kotlinhax.shadowroutines.*
import org.junit.*
import org.junit.Test
import kotlin.test.*

class DumpWithCreationStackTraceTest : DebugTestBase() {
    @Before
    override fun setUp() {
        super.setUp()
        DebugProbes.enableCreationStackTraces = true
    }

    @Test
    fun testCoroutinesDump() = runTest {
        val deferred = createActiveDeferred()
        yield()
        verifyDump(
            "Coroutine \"coroutine#1\":BlockingCoroutine{Active}@70d1cb56, state: RUNNING\n" +
                "\tat java.lang.Thread.getStackTrace(Thread.java)\n" +
                "\tat kotlinhax.shadowroutines.debug.internal.DebugProbesImpl.enhanceStackTraceWithThreadDumpImpl(DebugProbesImpl.kt)\n" +
                "\tat kotlinhax.shadowroutines.debug.internal.DebugProbesImpl.dumpCoroutinesSynchronized(DebugProbesImpl.kt)\n" +
                "\tat kotlinhax.shadowroutines.debug.internal.DebugProbesImpl.dumpCoroutines(DebugProbesImpl.kt)\n" +
                "\tat kotlinhax.shadowroutines.debug.DebugProbes.dumpCoroutines(DebugProbes.kt:182)\n" +
                "\tat kotlinhax.shadowroutines.debug.StacktraceUtilsKt.verifyDump(StacktraceUtils.kt)\n" +
                "\tat kotlinhax.shadowroutines.debug.StacktraceUtilsKt.verifyDump\$default(StacktraceUtils.kt)\n" +
                "\tat kotlinhax.shadowroutines.debug.DumpWithCreationStackTraceTest\$testCoroutinesDump\$1.invokeSuspend(DumpWithCreationStackTraceTest.kt)\n" +
                "\tat _COROUTINE._CREATION._(CoroutineDebugging.kt)\n" +
                "\tat kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(IntrinsicsJvm.kt)",

            "Coroutine \"coroutine#2\":DeferredCoroutine{Active}@383fa309, state: SUSPENDED\n" +
                "\tat kotlinhax.shadowroutines.debug.DumpWithCreationStackTraceTest\$createActiveDeferred\$1.invokeSuspend(DumpWithCreationStackTraceTest.kt)"
        )
        deferred.cancelAndJoin()
    }


    private fun CoroutineScope.createActiveDeferred(): Deferred<*> = async {
        suspendingMethod()
        assertTrue(true)
    }

    private suspend fun suspendingMethod() {
        delay(Long.MAX_VALUE)
    }
}
