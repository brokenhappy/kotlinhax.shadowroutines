@file:Suppress("NAMED_ARGUMENTS_NOT_ALLOWED") // KT-21913

package kotlinhax.shadowroutines.flow

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.channels.*
import kotlin.test.*

class FlowCallbackTest : TestBase() {
    @Test
    fun testClosedPrematurely() = runTest {
        val outerScope = this
        val flow = callbackFlow {
            // ~ callback-based API
            outerScope.launch(Job()) {
                expect(2)
                try {
                    send(1)
                    expectUnreached()
                } catch (e: IllegalStateException) {
                    expect(3)
                    assertTrue(e.message!!.contains("awaitClose"))
                }
            }
            expect(1)
        }
        try {
            flow.collect()
        } catch (e: IllegalStateException) {
            expect(4)
            assertTrue(e.message!!.contains("awaitClose"))
        }
        finish(5)
    }

    @Test
    fun testNotClosedPrematurely() = runTest {
        val outerScope = this
        val flow = callbackFlow {
            // ~ callback-based API
            outerScope.launch(Job()) {
                expect(2)
                send(1)
                close()
            }
            expect(1)
            awaitClose()
        }

        assertEquals(listOf(1), flow.toList())
        finish(3)
    }
}
