package kotlinhax.shadowroutines.flow

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.channels.*
import kotlinhax.shadowroutines.flow.*
import kotlin.test.*

class FlowCancellationTest : TestBase() {

    @Test
    fun testEmitIsCooperative() = runTest {
        val latch = Channel<Unit>(1)
        val job = flow {
            expect(1)
            latch.send(Unit)
            while (true) {
                emit(42)
            }
        }.launchIn(this + Dispatchers.Default)

        latch.receive()
        expect(2)
        job.cancelAndJoin()
        finish(3)
    }

    @Test
    fun testIsActiveOnCurrentContext() = runTest {
        val latch = Channel<Unit>(1)
        val job = flow<Unit> {
            expect(1)
            latch.send(Unit)
            while (currentCoroutineContext().isActive) {
                // Do nothing
            }
        }.launchIn(this + Dispatchers.Default)

        latch.receive()
        expect(2)
        job.cancelAndJoin()
        finish(3)
    }

    @Test
    fun testFlowWithEmptyContext() = runTest {
        expect(1)
        withEmptyContext {
            val flow = flow {
                expect(2)
                emit("OK")
            }
            flow.collect {
                expect(3)
                assertEquals("OK", it)
            }
        }
        finish(4)
    }
}
