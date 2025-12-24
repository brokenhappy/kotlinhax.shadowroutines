@file:Suppress("PackageDirectoryMismatch")
package definitely.not.kotlinhax.shadowroutines

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.debug.*
import kotlinhax.shadowroutines.selects.*
import org.junit.*
import org.junit.Test
import java.util.concurrent.*
import kotlin.test.*

class SanitizedProbesTest : DebugTestBase() {
    @Before
    override fun setUp() {
        super.setUp()
        DebugProbes.sanitizeStackTraces = true
        DebugProbes.enableCreationStackTraces = true
    }

    @Test
    fun testRecoveredStackTrace() = runTest {
        val deferred = createDeferred()
        val traces = listOf(
            "java.util.concurrent.ExecutionException\n" +
                    "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest\$createDeferredNested\$1.invokeSuspend(SanitizedProbesTest.kt:97)\n" +
                    "\tat _COROUTINE._BOUNDARY._(CoroutineDebugging.kt)\n" +
                    "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest.oneMoreNestedMethod(SanitizedProbesTest.kt:67)\n" +
                    "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest.nestedMethod(SanitizedProbesTest.kt:61)\n" +
                    "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest\$testRecoveredStackTrace\$1.invokeSuspend(SanitizedProbesTest.kt:50)\n" +
                    "\tat _COROUTINE._CREATION._(CoroutineDebugging.kt)\n" +
                    "\tat kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(IntrinsicsJvm.kt:116)\n" +
                    "\tat kotlinhax.shadowroutines.intrinsics.CancellableKt.startCoroutineCancellable(Cancellable.kt:23)\n" +
                    "\tat kotlinhax.shadowroutines.testing.TestBase.runTest\$default(TestBase.kt:141)\n" +
                    "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest.testRecoveredStackTrace(SanitizedProbesTest.kt:33)",
            "Caused by: java.util.concurrent.ExecutionException\n" +
                    "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest\$createDeferredNested\$1.invokeSuspend(SanitizedProbesTest.kt:57)\n" +
                    "\tat kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:32)\n"
        )
        nestedMethod(deferred, traces)
        deferred.join()
    }

    @Test
    fun testCoroutinesDump() = runTest {
        val deferred = createActiveDeferred()
        yield()
        verifyDump(
            "Coroutine \"coroutine#3\":BlockingCoroutine{Active}@7d68ef40, state: RUNNING\n" +
                "\tat java.lang.Thread.getStackTrace(Thread.java)\n" +
                "\tat _COROUTINE._CREATION._(CoroutineDebugging.kt)\n" +
                "\tat kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(IntrinsicsJvm.kt:116)\n" +
                "\tat kotlinhax.shadowroutines.intrinsics.CancellableKt.startCoroutineCancellable(Cancellable.kt:23)\n" +
                "\tat kotlinhax.shadowroutines.testing.TestBase.runTest\$default(TestBase.kt:141)\n" +
                "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest.testCoroutinesDump(SanitizedProbesTest.kt:56)",

            "Coroutine \"coroutine#4\":DeferredCoroutine{Active}@75c072cb, state: SUSPENDED\n" +
                    "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest\$createActiveDeferred\$1.invokeSuspend(SanitizedProbesTest.kt:63)\n" +
                    "\tat _COROUTINE._CREATION._(CoroutineDebugging.kt)\n" +
                    "\tat kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(IntrinsicsJvm.kt:116)\n" +
                    "\tat kotlinhax.shadowroutines.intrinsics.CancellableKt.startCoroutineCancellable(Cancellable.kt:23)\n" +
                    "\tat kotlinhax.shadowroutines.BuildersKt__Builders_commonKt.async\$default(Builders.common.kt)\n" +
                    "\tat kotlinhax.shadowroutines.BuildersKt.async\$default(Unknown Source)\n" +
                    "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest.createActiveDeferred(SanitizedProbesTest.kt:62)\n" +
                    "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest.access\$createActiveDeferred(SanitizedProbesTest.kt:16)\n" +
                    "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest\$testCoroutinesDump\$1.invokeSuspend(SanitizedProbesTest.kt:57)\n" +
                    "\tat kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:32)\n" +
                    "\tat kotlinhax.shadowroutines.DispatchedTask.run(DispatchedTask.kt:237)\n" +
                    "\tat kotlinhax.shadowroutines.testing.TestBase.runTest\$default(TestBase.kt:141)\n" +
                    "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest.testCoroutinesDump(SanitizedProbesTest.kt:56)"
        )
        deferred.cancelAndJoin()
    }

    @Test
    fun testSelectBuilder() = runTest {
        val selector = launchSelector()
        expect(1)
        yield()
        expect(3)
        verifyDump("Coroutine \"coroutine#1\":BlockingCoroutine{Active}@35fc6dc4, state: RUNNING\n" +
                "\tat java.lang.Thread.getStackTrace(Thread.java:1552)\n" + // Skip the rest
                "\tat _COROUTINE._CREATION._(CoroutineDebugging.kt)\n" +
                "\tat kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(IntrinsicsJvm.kt:116)",

            "Coroutine \"coroutine#2\":StandaloneCoroutine{Active}@1b68b9a4, state: SUSPENDED\n" +
                "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest\$launchSelector\$1\$1\$1.invokeSuspend(SanitizedProbesTest.kt)\n" +
                "\tat _COROUTINE._CREATION._(CoroutineDebugging.kt)\n" +
                "\tat kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(IntrinsicsJvm.kt:116)\n" +
                "\tat kotlinhax.shadowroutines.intrinsics.CancellableKt.startCoroutineCancellable(Cancellable.kt:25)\n" +
                "\tat kotlinhax.shadowroutines.BuildersKt__Builders_commonKt.launch\$default(Builders.common.kt)\n" +
                "\tat kotlinhax.shadowroutines.BuildersKt.launch\$default(Unknown Source)\n" +
                "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest.launchSelector(SanitizedProbesTest.kt:100)\n" +
                "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest.access\$launchSelector(SanitizedProbesTest.kt:16)\n" +
                "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest\$testSelectBuilder\$1.invokeSuspend(SanitizedProbesTest.kt:89)\n" +
                "\tat kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:32)\n" +
                "\tat kotlinhax.shadowroutines.DispatchedTask.run(DispatchedTask.kt:233)\n" +
                "\tat kotlinhax.shadowroutines.testing.TestBase.runTest\$default(TestBase.kt:154)\n" +
                "\tat definitely.not.kotlinhax.shadowroutines.SanitizedProbesTest.testSelectBuilder(SanitizedProbesTest.kt:88)")
        finish(4)
        selector.cancelAndJoin()
    }

    private fun CoroutineScope.launchSelector(): Job {
        val job = CompletableDeferred(Unit)
        return launch {
            select<Int> {
                job.onJoin {
                    expect(2)
                    delay(Long.MAX_VALUE)
                    1
                }
            }
        }
    }

    private fun CoroutineScope.createActiveDeferred(): Deferred<*> = async {
        suspendingMethod()
        assertTrue(true)
    }

    private suspend fun suspendingMethod() {
        delay(Long.MAX_VALUE)
    }

    private fun CoroutineScope.createDeferred(): Deferred<*> = createDeferredNested()

    private fun CoroutineScope.createDeferredNested(): Deferred<*> = async(NonCancellable) {
        throw ExecutionException(null)
    }

    private suspend fun nestedMethod(deferred: Deferred<*>, traces: List<String>) {
        oneMoreNestedMethod(deferred, traces)
        assertTrue(true) // Prevent tail-call optimization
    }

    private suspend fun oneMoreNestedMethod(deferred: Deferred<*>, traces: List<String>) {
        try {
            deferred.await()
            expectUnreached()
        } catch (e: ExecutionException) {
            verifyStackTrace(e, traces)
        }
    }
}
