package kotlinhax.shadowroutines.flow

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlin.test.*

class SafeFlowTest : TestBase() {

    @Test
    fun testEmissionsFromDifferentStateMachine() = runTest {
        val result = flow<Int> {
            emit1(1)
            emit2(2)
        }.onEach { yield() }.toList()
        assertEquals(listOf(1, 2), result)
        finish(3)
    }

    private suspend fun FlowCollector<Int>.emit1(expect: Int) {
        emit(expect)
        expect(expect)
    }

    private suspend fun FlowCollector<Int>.emit2(expect: Int) {
        emit(expect)
        expect(expect)
    }
}
