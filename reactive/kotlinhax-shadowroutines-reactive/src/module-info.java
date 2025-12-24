module kotlinhax.shadowroutines.reactive {
    requires kotlin.stdlib;
    requires kotlinhax.shadowroutines.core;
    requires kotlinx.atomicfu;
    requires org.reactivestreams;

    exports kotlinhax.shadowroutines.reactive;

    uses kotlinhax.shadowroutines.reactive.ContextInjector;
}
