// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleBasic06

import kotlinhax.shadowroutines.*

fun main() = runBlocking {
    repeat(50_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print(".")
        }
    }
}
