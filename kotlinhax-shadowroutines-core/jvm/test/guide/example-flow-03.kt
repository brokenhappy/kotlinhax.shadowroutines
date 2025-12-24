// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.exampleFlow03

import kotlinhax.shadowroutines.*                 
                           
suspend fun simple(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}

fun main() = runBlocking<Unit> {
    simple().forEach { value -> println(value) } 
}
