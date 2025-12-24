package kotlinhax.shadowroutines.flow

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlin.test.*

class TransformTest : TestBase() {
    @Test
    fun testDoubleEmit() = runTest {
         val flow = flowOf(1, 2, 3)
             .transform {
                 emit(it)
                 emit(it)
             }
        assertEquals(listOf(1, 1, 2, 2, 3, 3), flow.toList())
    }
}