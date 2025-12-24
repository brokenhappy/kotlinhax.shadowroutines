package kotlinhax.shadowroutines.flow.internal

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.flow.*

internal actual class AbortFlowException actual constructor(
    actual val owner: Any
) : CancellationException("Flow was aborted, no more elements needed")
internal actual class ChildCancelledException : CancellationException("Child of the scoped flow was cancelled")
