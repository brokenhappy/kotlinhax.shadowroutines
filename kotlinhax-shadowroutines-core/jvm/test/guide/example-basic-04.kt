// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleBasic04

import kotlinhax.shadowroutines.*

// Sequentially executes doWorld followed by "Done"
fun main() = runBlocking {
    doWorld()
    println("Done")
}

// Concurrently executes both sections
suspend fun doWorld() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}
