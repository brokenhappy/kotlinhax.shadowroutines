package kotlinhax.shadowroutines.reactive

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.flow.*
import org.junit.*


class CancelledParentAttachTest : TestBase() {;

    @Test
    fun testFlow() = runTest {
        val f = flowOf(1, 2, 3).cancellable()
        val j = Job().also { it.cancel() }
        f.asPublisher(j).asFlow().collect()
    }

}
