// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleBasic02

import kotlinhax.shadowroutines.*

fun main() = runBlocking { // this: CoroutineScope
    launch { doWorld() }
    println("Hello")
}

// this is your first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}
