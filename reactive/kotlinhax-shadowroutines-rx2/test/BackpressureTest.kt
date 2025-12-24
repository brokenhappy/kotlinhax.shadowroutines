package kotlinhax.shadowroutines.rx2

import kotlinhax.shadowroutines.testing.*
import io.reactivex.*
import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.flow.*
import kotlinhax.shadowroutines.reactive.*
import org.junit.Test
import kotlin.test.*

class BackpressureTest : TestBase() {
    @Test
    fun testBackpressureDropDirect() = runTest {
        expect(1)
        Flowable.fromArray(1)
            .onBackpressureDrop()
            .collect {
                assertEquals(1, it)
                expect(2)
            }
        finish(3)
    }

    @Test
    fun testBackpressureDropFlow() = runTest {
        expect(1)
        Flowable.fromArray(1)
            .onBackpressureDrop()
            .asFlow()
            .collect {
                assertEquals(1, it)
                expect(2)
            }
        finish(3)
    }
}