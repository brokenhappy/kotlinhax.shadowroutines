@SuppressWarnings("JavaModuleNaming")
module kotlinhax.shadowroutines.jdk9 {
    requires kotlin.stdlib;
    requires kotlinhax.shadowroutines.core;
    requires kotlinhax.shadowroutines.reactive;
    requires org.reactivestreams;

    exports kotlinhax.shadowroutines.jdk9;
}
