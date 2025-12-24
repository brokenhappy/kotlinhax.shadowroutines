module kotlinhax.shadowroutines.debug {
    requires java.management;
    requires java.instrument;
    requires kotlin.stdlib;
    requires kotlinhax.shadowroutines.core;
    requires static net.bytebuddy;
    requires static net.bytebuddy.agent;
    requires static org.junit.jupiter.api;
    requires static org.junit.platform.commons;

    exports kotlinhax.shadowroutines.debug;
    exports kotlinhax.shadowroutines.debug.junit4;
    exports kotlinhax.shadowroutines.debug.junit5;
}
