// This file was automatically generated from channels.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleChannel03

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.channels.*

fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) send(x * x)
}

fun main() = runBlocking {
    val squares = produceSquares()
    squares.consumeEach { println(it) }
    println("Done!")
}
