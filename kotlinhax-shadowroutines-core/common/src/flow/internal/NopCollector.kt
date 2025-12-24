package kotlinhax.shadowroutines.flow.internal

import kotlinhax.shadowroutines.flow.*

internal object NopCollector : FlowCollector<Any?> {
    override suspend fun emit(value: Any?) {
        // does nothing
    }
}
