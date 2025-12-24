@file:Suppress("unused")
package kotlinhax.shadowroutines.lincheck

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.selects.*
import kotlinhax.shadowroutines.sync.*
import org.jetbrains.kotlinx.lincheck.*
import org.jetbrains.kotlinx.lincheck.annotations.*
import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.paramgen.*

@Param(name = "owner", gen = IntGen::class, conf = "0:2")
class MutexLincheckTest : AbstractLincheckTest() {
    private val mutex = Mutex()

    @Operation(handleExceptionsAsResult = [IllegalStateException::class])
    fun tryLock(@Param(name = "owner") owner: Int) = mutex.tryLock(owner.asOwnerOrNull)

    // TODO: `lock()` with non-null owner is non-linearizable
    @Operation(promptCancellation = true)
    suspend fun lock() = mutex.lock(null)

    // TODO: `onLock` with non-null owner is non-linearizable
    // onLock may suspend in case of clause re-registration.
    @Operation(allowExtraSuspension = true, promptCancellation = true)
    suspend fun onLock() = select<Unit> { mutex.onLock(null) {} }

    @Operation(handleExceptionsAsResult = [IllegalStateException::class])
    fun unlock(@Param(name = "owner") owner: Int) = mutex.unlock(owner.asOwnerOrNull)

    @Operation
    fun isLocked() = mutex.isLocked

    @Operation
    fun holdsLock(@Param(name = "owner") owner: Int) = mutex.holdsLock(owner)

    override fun <O : Options<O, *>> O.customize(isStressTest: Boolean): O =
        actorsBefore(0)

    private val Int.asOwnerOrNull get() = if (this == 0) null else this
}
