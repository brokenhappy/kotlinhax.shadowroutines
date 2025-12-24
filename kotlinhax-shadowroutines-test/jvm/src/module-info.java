import kotlinhax.shadowroutines.CoroutineExceptionHandler;
import kotlinhax.shadowroutines.internal.MainDispatcherFactory;
import kotlinhax.shadowroutines.test.internal.ExceptionCollectorAsService;
import kotlinhax.shadowroutines.test.internal.TestMainDispatcherFactory;

module kotlinhax.shadowroutines.test {
    requires kotlin.stdlib;
    requires kotlinhax.shadowroutines.core;
    requires kotlinx.atomicfu;

    exports kotlinhax.shadowroutines.test;

    provides MainDispatcherFactory with TestMainDispatcherFactory;
    provides CoroutineExceptionHandler with ExceptionCollectorAsService;
}
