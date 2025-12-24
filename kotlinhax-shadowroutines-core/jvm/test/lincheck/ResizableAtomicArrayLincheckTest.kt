package kotlinhax.shadowroutines.lincheck

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.internal.*
import org.jetbrains.kotlinx.lincheck.annotations.*
import org.jetbrains.kotlinx.lincheck.paramgen.*

@Param(name = "index", gen = IntGen::class, conf = "0:4")
@Param(name = "value", gen = IntGen::class, conf = "1:5")
class ResizableAtomicArrayLincheckTest : AbstractLincheckTest() {
    private val a = ResizableAtomicArray<Int>(2)

    @Operation
    fun get(@Param(name = "index") index: Int): Int? = a[index]

    @Operation(nonParallelGroup = "writer")
    fun set(@Param(name = "index") index: Int, @Param(name = "value") value: Int) {
        a.setSynchronized(index, value)
    }
}