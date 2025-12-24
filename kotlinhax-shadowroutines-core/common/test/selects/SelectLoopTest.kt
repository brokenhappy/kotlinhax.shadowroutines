@file:Suppress("NAMED_ARGUMENTS_NOT_ALLOWED") // KT-21913

package kotlinhax.shadowroutines.selects

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.channels.*
import kotlin.test.*

class SelectLoopTest : TestBase() {
    // https://github.com/Kotlin/kotlinhax.shadowroutines/issues/1130
    @Test
    fun testChannelSelectLoop() = runTest(
        expected = { it is TestException }
    ) {
        expect(1)
        val channel = Channel<Unit>()
        val job = launch {
            expect(2)
            channel.send(Unit)
            expect(3)
            throw TestException()
        }
        try {
            while (true) {
                select<Unit> {
                    channel.onReceiveCatching {
                        expectUnreached()
                    }
                    job.onJoin {
                        expectUnreached()
                    }
                }
            }
        } catch (e: CancellationException) {
            // select will get cancelled because of the failure of job
            finish(4)
        }
    }
}
