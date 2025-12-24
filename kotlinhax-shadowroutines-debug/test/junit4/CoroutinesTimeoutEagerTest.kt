package kotlinhax.shadowroutines.debug.junit4

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import org.junit.*
import org.junit.runners.model.*

class CoroutinesTimeoutEagerTest : TestBase(disableOutCheck = true) {

    @Rule
    @JvmField
    public val validation = TestFailureValidation(
        500, true, true,
        TestResultSpec(
            "hangingTest", expectedOutParts = listOf(
                "Coroutines dump",
                "Test hangingTest timed out after 500 milliseconds",
                "BlockingCoroutine{Active}",
                "runBlocking",
                "at kotlinhax.shadowroutines.debug.junit4.CoroutinesTimeoutEagerTest.hangForever",
                "at kotlinhax.shadowroutines.debug.junit4.CoroutinesTimeoutEagerTest.waitForHangJob"),
            error = TestTimedOutException::class.java)
    )

    private val job = GlobalScope.launch(Dispatchers.Unconfined) { hangForever() }

    private suspend fun hangForever() {
        suspendCancellableCoroutine<Unit> {  }
        expectUnreached()
    }

    @Test
    fun hangingTest() = runBlocking<Unit> {
        waitForHangJob()
        expectUnreached()
    }

    private suspend fun waitForHangJob() {
        job.join()
        expectUnreached()
    }

}
