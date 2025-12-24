import kotlinhax.shadowroutines.internal.MainDispatcherFactory;
import kotlinhax.shadowroutines.swing.SwingDispatcherFactory;

module kotlinhax.shadowroutines.swing {
    requires kotlin.stdlib;
    requires kotlinhax.shadowroutines.core;
    requires java.desktop;

    exports kotlinhax.shadowroutines.swing;

    provides MainDispatcherFactory with SwingDispatcherFactory;
}
