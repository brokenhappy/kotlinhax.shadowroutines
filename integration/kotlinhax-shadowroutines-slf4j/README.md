# Module kotlinhax-shadowroutines-slf4j

Integration with SLF4J [MDC](https://logback.qos.ch/manual/mdc.html).

## Example

Add [MDCContext] to the coroutine context so that the SLF4J MDC context is captured and passed into the coroutine.

```kotlin
MDC.put("kotlin", "rocks") // put a value into the MDC context

launch(MDCContext()) {
   logger.info { "..." }   // the MDC context will contain the mapping here
}
```

# Package kotlinhax.shadowroutines.slf4j

Integration with SLF4J [MDC](https://logback.qos.ch/manual/mdc.html).

<!--- MODULE kotlinhax-shadowroutines-slf4j -->
<!--- INDEX kotlinhax.shadowroutines.slf4j -->

[MDCContext]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-slf4j/kotlinhax.shadowroutines.slf4j/-m-d-c-context/index.html

<!--- END -->
