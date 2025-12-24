package kotlinhax.shadowroutines.exceptions

actual inline fun yieldThread() { Thread.yield() }

actual fun currentThreadName(): String = Thread.currentThread().name
