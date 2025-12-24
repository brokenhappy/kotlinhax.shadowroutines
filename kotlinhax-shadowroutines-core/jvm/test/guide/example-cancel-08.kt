// This file was automatically generated from cancellation-and-timeouts.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleCancel08

import kotlinhax.shadowroutines.*

fun main() = runBlocking {
    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
        "Done" // will get cancelled before it produces this result
    }
    println("Result is $result")
}
