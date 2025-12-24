// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleFlow07

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.flow.*

fun main() = runBlocking<Unit> {
    // Convert an integer range to a flow
    (1..3).asFlow().collect { value -> println(value) }
}
