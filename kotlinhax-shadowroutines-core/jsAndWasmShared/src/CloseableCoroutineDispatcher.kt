package kotlinhax.shadowroutines

public actual abstract class CloseableCoroutineDispatcher actual constructor() : CoroutineDispatcher(), AutoCloseable {
    public actual abstract override fun close()
}
