// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleFlow20

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.flow.*

fun main() = runBlocking<Unit> { 
    val nums = (1..3).asFlow() // numbers 1..3
    val strs = flowOf("one", "two", "three") // strings 
    nums.zip(strs) { a, b -> "$a -> $b" } // compose a single string
        .collect { println(it) } // collect and print
}
