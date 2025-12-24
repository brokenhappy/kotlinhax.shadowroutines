// This file was automatically generated from cancellation-and-timeouts.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleCancel07

import kotlinhax.shadowroutines.*

fun main() = runBlocking {
    withTimeout(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
}
