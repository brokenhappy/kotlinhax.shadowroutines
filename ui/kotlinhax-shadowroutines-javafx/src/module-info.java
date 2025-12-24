import kotlinhax.shadowroutines.internal.MainDispatcherFactory;
import kotlinhax.shadowroutines.javafx.JavaFxDispatcherFactory;

module kotlinhax.shadowroutines.javafx {
    requires kotlin.stdlib;
    requires kotlinhax.shadowroutines.core;
    requires javafx.base;
    requires javafx.graphics;

    exports kotlinhax.shadowroutines.javafx;

    provides MainDispatcherFactory with JavaFxDispatcherFactory;
}
