// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleFlow22

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.flow.*

fun main() = runBlocking<Unit> { 
    val nums = (1..3).asFlow().onEach { delay(300) } // numbers 1..3 every 300 ms
    val strs = flowOf("one", "two", "three").onEach { delay(400) } // strings every 400 ms          
    val startTime = currentTimeMillis() // remember the start time 
    nums.combine(strs) { a, b -> "$a -> $b" } // compose a single string with "combine"
        .collect { value -> // collect and print 
            println("$value at ${currentTimeMillis() - startTime} ms from start") 
        } 
}
