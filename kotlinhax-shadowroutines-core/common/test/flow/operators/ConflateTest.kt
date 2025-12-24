package kotlinhax.shadowroutines.flow

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlin.test.*

class ConflateTest : TestBase() {
    @Test // from example
    fun testExample() = withVirtualTime {
        expect(1)
        val flow = flow {
            for (i in 1..30) {
                delay(100)
                emit(i)
            }
        }
        val result = flow.conflate().onEach {
            delay(1000)
        }.toList()
        assertEquals(listOf(1, 10, 20, 30), result)
        finish(2)
    }
}