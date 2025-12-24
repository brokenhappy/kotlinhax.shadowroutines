package kotlinhax.shadowroutines.reactive

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.selects.*
import org.junit.Test
import kotlin.test.*

class PublisherMultiTest : TestBase() {
    @Test
    fun testConcurrentStress() = runBlocking {
        val n = 10_000 * stressTestMultiplier
        val observable = publish {
            // concurrent emitters (many coroutines)
            val jobs = List(n) {
                // launch
                launch(Dispatchers.Default) {
                    send(it)
                }
            }
            jobs.forEach { it.join() }
        }
        val resultSet = mutableSetOf<Int>()
        observable.collect {
            assertTrue(resultSet.add(it))
        }
        assertEquals(n, resultSet.size)
    }

    @Test
    fun testConcurrentStressOnSend() = runBlocking {
        val n = 10_000 * stressTestMultiplier
        val observable = publish<Int> {
            // concurrent emitters (many coroutines)
            val jobs = List(n) {
                // launch
                launch(Dispatchers.Default) {
                    select<Unit> {
                        onSend(it) {}
                    }
                }
            }
            jobs.forEach { it.join() }
        }
        val resultSet = mutableSetOf<Int>()
        observable.collect {
            assertTrue(resultSet.add(it))
        }
        assertEquals(n, resultSet.size)
    }
}
