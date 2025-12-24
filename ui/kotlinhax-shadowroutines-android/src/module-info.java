import kotlinhax.shadowroutines.android.AndroidDispatcherFactory;
import kotlinhax.shadowroutines.internal.MainDispatcherFactory;

module kotlinhax.shadowroutines.android {
    requires kotlin.stdlib;
    requires kotlinhax.shadowroutines.core;

    exports kotlinhax.shadowroutines.android;

    provides MainDispatcherFactory with AndroidDispatcherFactory;
}
