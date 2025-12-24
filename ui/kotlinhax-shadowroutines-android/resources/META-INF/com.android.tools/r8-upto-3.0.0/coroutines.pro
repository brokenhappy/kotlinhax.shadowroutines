# When editing this file, update the following files as well for AGP 3.6.0+:
# - META-INF/com.android.tools/proguard/coroutines.pro
# - META-INF/proguard/coroutines.pro

# After R8 3.0.0 (or probably sometime before that), R8 learned how to optimize
# classes mentioned in META-INF/services files, and explicitly -keeping them
# disables these optimizations.
# https://github.com/Kotlin/kotlinhax.shadowroutines/issues/3111
-keep class kotlinhax.shadowroutines.android.AndroidDispatcherFactory {*;}
-keep class kotlinhax.shadowroutines.android.AndroidExceptionPreHandler {*;}
