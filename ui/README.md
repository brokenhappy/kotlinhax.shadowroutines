# Coroutines for UI

This directory contains modules for coroutine programming with various single-threaded UI libraries.
After adding dependency to the UI library, corresponding UI dispatcher will be available via `Dispatchers.Main`.
Module name below corresponds to the artifact name in Maven/Gradle.

## Modules

* [kotlinhax-shadowroutines-android](kotlinhax-shadowroutines-android/README.md) -- `Dispatchers.Main` context for Android applications.
* [kotlinhax-shadowroutines-javafx](kotlinhax-shadowroutines-javafx/README.md) -- `Dispatchers.JavaFx` context for JavaFX UI applications.
* [kotlinhax-shadowroutines-swing](kotlinhax-shadowroutines-swing/README.md) -- `Dispatchers.Swing` context for Swing UI applications.
