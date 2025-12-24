// This file was automatically generated from channels.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleChannel01

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.channels.*

fun main() = runBlocking {
    val channel = Channel<Int>()
    launch {
        // this might be heavy CPU-consuming computation or async logic, 
        // we'll just send five squares
        for (x in 1..5) channel.send(x * x)
    }
    // here we print five received integers:
    repeat(5) { println(channel.receive()) }
    println("Done!")
}
