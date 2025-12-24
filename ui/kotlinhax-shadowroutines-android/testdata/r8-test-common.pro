# Entry point for retaining MainDispatcherLoader which uses a ServiceLoader.
-keep class kotlinhax.shadowroutines.Dispatchers {
  ** getMain();
}

# Entry point for retaining CoroutineExceptionHandlerImpl.handlers which uses a ServiceLoader.
-keep class kotlinhax.shadowroutines.CoroutineExceptionHandlerKt {
  void handleCoroutineException(...);
}

# Entry point for the rest of coroutines machinery
-keep class kotlinhax.shadowroutines.BuildersKt {
  ** runBlocking(...);
  ** launch(...);
}

# We are cheating a bit by not having android.jar on R8's library classpath. Ignore those warnings.
-ignorewarnings