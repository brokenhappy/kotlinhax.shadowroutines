# ServiceLoader support
-keepnames class kotlinhax.shadowroutines.test.internal.TestMainDispatcherFactory {}
-keepnames class kotlinhax.shadowroutines.android.AndroidExceptionPreHandler {}
-keepnames class kotlinhax.shadowroutines.android.AndroidDispatcherFactory {}

# Most of volatile fields are updated with AFU and should not be mangled
-keepclassmembers class kotlinhax.shadowroutines.** {
    volatile <fields>;
}
