@SuppressWarnings("JavaModuleNaming")
module kotlinhax.shadowroutines.rx2 {
    requires kotlin.stdlib;
    requires kotlinhax.shadowroutines.core;
    requires kotlinhax.shadowroutines.reactive;
    requires kotlinx.atomicfu;
    requires io.reactivex.rxjava2;

    exports kotlinhax.shadowroutines.rx2;
}
