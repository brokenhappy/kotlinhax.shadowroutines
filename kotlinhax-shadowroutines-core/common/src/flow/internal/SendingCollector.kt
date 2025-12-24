package kotlinhax.shadowroutines.flow.internal

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.channels.*
import kotlinhax.shadowroutines.flow.*

/**
 * Collection that sends to channel
 * @suppress **This an internal API and should not be used from general code.**
 */
@InternalCoroutinesApi
public class SendingCollector<T>(
    private val channel: SendChannel<T>
) : FlowCollector<T> {
    override suspend fun emit(value: T): Unit = channel.send(value)
}
