package kotlinhax.shadowroutines.selects

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.channels.*
import kotlin.test.*

class SelectUnlimitedChannelTest : TestBase() {
    @Test
    fun testSelectSendWhenClosed() = runTest {
        expect(1)
        val c = Channel<Int>(Channel.UNLIMITED)
        c.send(1) // enqueue buffered element
        c.close() // then close
        assertFailsWith<ClosedSendChannelException> {
            // select sender should fail
            expect(2)
            select {
                c.onSend(2) {
                    expectUnreached()
                }
            }
        }
        finish(3)
    }
}