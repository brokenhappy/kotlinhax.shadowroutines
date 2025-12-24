import kotlinhax.shadowroutines.CoroutineExceptionHandler;
import kotlinhax.shadowroutines.internal.MainDispatcherFactory;

module kotlinhax.shadowroutines.core {
    requires transitive kotlin.stdlib;
    requires kotlinx.atomicfu;

    // these are used by kotlinhax.shadowroutines.debug.internal.AgentPremain
    requires static java.instrument; // contains java.lang.instrument.*
    requires static jdk.unsupported; // contains sun.misc.Signal

    exports kotlinhax.shadowroutines;
    exports kotlinhax.shadowroutines.channels;
    exports kotlinhax.shadowroutines.debug.internal;
    exports kotlinhax.shadowroutines.flow;
    exports kotlinhax.shadowroutines.flow.internal;
    exports kotlinhax.shadowroutines.future;
    exports kotlinhax.shadowroutines.internal;
    exports kotlinhax.shadowroutines.intrinsics;
    exports kotlinhax.shadowroutines.scheduling;
    exports kotlinhax.shadowroutines.selects;
    exports kotlinhax.shadowroutines.stream;
    exports kotlinhax.shadowroutines.sync;
    exports kotlinhax.shadowroutines.time;

    uses CoroutineExceptionHandler;
    uses MainDispatcherFactory;
}
