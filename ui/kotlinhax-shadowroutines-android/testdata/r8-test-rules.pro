-include r8-test-common.pro

-include ../resources/META-INF/com.android.tools/r8-from-1.6.0/coroutines.pro

# Validate that service-loader & debugger classes are discarded
-checkdiscard class kotlinhax.shadowroutines.internal.FastServiceLoader
-checkdiscard class kotlinhax.shadowroutines.DebugKt
-checkdiscard class kotlinhax.shadowroutines.internal.StackTraceRecoveryKt
-checkdiscard class kotlinhax.shadowroutines.debug.DebugProbesKt

# Real android projects do not keep this class, but somehow it is kept in this test (R8 bug)
# -checkdiscard class kotlinhax.shadowroutines.internal.MissingMainCoroutineDispatcher

# Should not keep this class, but it is still there (R8 bug)
#-checkdiscard class kotlinhax.shadowroutines.CoroutineId
