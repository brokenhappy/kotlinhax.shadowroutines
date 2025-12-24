// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleFlow06

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.flow.*

fun simple(): Flow<Int> = flow { 
    for (i in 1..3) {
        delay(100)          
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    withTimeoutOrNull(250) { // Timeout after 250ms 
        simple().collect { value -> println(value) } 
    }
    println("Done")
}
