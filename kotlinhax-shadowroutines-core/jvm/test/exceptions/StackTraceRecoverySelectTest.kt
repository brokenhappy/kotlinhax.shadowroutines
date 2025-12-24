package kotlinhax.shadowroutines.exceptions

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.channels.*
import kotlinhax.shadowroutines.selects.*
import org.junit.*
import org.junit.rules.*

class StackTraceRecoverySelectTest : TestBase() {

    @get:Rule
    val name = TestName()

    @Test
    fun testSelectJoin() = runTest {
        expect(1)
        val result = runCatching { doSelect() }
        expect(3)
        verifyStackTrace("select/${name.methodName}", result.exceptionOrNull()!!)
        finish(4)
    }

    private suspend fun doSelect(): Int {
        val job = CompletableDeferred(Unit)
        return select {
            job.onJoin {
                yield() // Hide the stacktrace
                expect(2)
                throw RecoverableTestException()
            }
        }
    }

    @Test
    fun testSelectCompletedAwait() = runTest {
        val deferred = CompletableDeferred<Unit>()
        deferred.completeExceptionally(RecoverableTestException())
        val result = runCatching { doSelectAwait(deferred) }
        verifyStackTrace("select/${name.methodName}", result.exceptionOrNull()!!)
    }

    private suspend fun doSelectAwait(deferred: Deferred<Unit>): Int {
        return select {
            deferred.onAwait {
                yield() // Hide the frame
                42
            }
        }
    }

    @Test
    fun testSelectOnReceive() = runTest {
        val c = Channel<Unit>()
        c.close()
        val result = kotlin.runCatching {  doSelectOnReceive(c) }
        verifyStackTrace("select/${name.methodName}", result.exceptionOrNull()!!)
    }

    private suspend fun doSelectOnReceive(c: Channel<Unit>) {
        // The channel is closed, should throw an exception
        select<Unit> {
            c.onReceive {
                expectUnreached()
            }
        }
    }
}
