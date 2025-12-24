import kotlinhax.shadowroutines.reactive.ContextInjector;
import kotlinhax.shadowroutines.reactor.ReactorContextInjector;

module kotlinhax.shadowroutines.reactor {
    requires kotlin.stdlib;
    requires kotlinhax.shadowroutines.core;
    requires kotlinhax.shadowroutines.reactive;
    requires org.reactivestreams;
    requires reactor.core;

    exports kotlinhax.shadowroutines.reactor;

    provides ContextInjector with ReactorContextInjector;
}
