@SuppressWarnings("JavaModuleNaming")
module kotlinhax.shadowroutines.rx3 {
    requires kotlin.stdlib;
    requires kotlinhax.shadowroutines.core;
    requires kotlinhax.shadowroutines.reactive;
    requires kotlinx.atomicfu;
    requires io.reactivex.rxjava3;

    exports kotlinhax.shadowroutines.rx3;
}
