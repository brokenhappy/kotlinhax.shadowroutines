# Module kotlinhax-shadowroutines-reactor

Utilities for [Reactor](https://projectreactor.io).

Coroutine builders:

| **Name**        | **Result**  | **Scope**        | **Description**
| --------------- | ------------| ---------------- | ---------------
| [mono]          | `Mono`      | [CoroutineScope] | A cold Mono that starts the coroutine on subscription
| [flux]          | `Flux`      | [CoroutineScope] | A cold Flux that starts the coroutine on subscription

Note that `Mono` and `Flux` are subclasses of [Reactive Streams](https://www.reactive-streams.org)'
`Publisher` and extensions for it are covered by the
[kotlinhax-shadowroutines-reactive](../kotlinhax-shadowroutines-reactive) module.

Integration with [Flow]:

| **Name**        | **Result**     | **Description**
| --------------- | -------------- | ---------------
| [Flow.asFlux]   | `Flux`         | Converts the given flow to a TCK-compliant Flux.

This adapter is integrated with Reactor's `Context` and coroutines' [ReactorContext].

Conversion functions:

| **Name** | **Description**
| -------- | ---------------
| [Job.asMono][kotlinhax.shadowroutines.Job.asMono] | Converts a job to a hot Mono
| [Deferred.asMono][kotlinhax.shadowroutines.Deferred.asMono] | Converts a deferred value to a hot Mono
| [Scheduler.asCoroutineDispatcher][reactor.core.scheduler.Scheduler.asCoroutineDispatcher] | Converts a scheduler to a [CoroutineDispatcher]

<!--- MODULE kotlinhax-shadowroutines-core -->
<!--- INDEX kotlinhax.shadowroutines -->

[CoroutineScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-scope/index.html
[CoroutineDispatcher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-dispatcher/index.html

<!--- INDEX kotlinhax.shadowroutines.channels -->
<!--- INDEX kotlinhax.shadowroutines.flow -->

[Flow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/-flow/index.html

<!--- MODULE kotlinhax-shadowroutines-reactor -->
<!--- INDEX kotlinhax.shadowroutines.reactor -->

[mono]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactor/kotlinhax.shadowroutines.reactor/mono.html
[flux]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactor/kotlinhax.shadowroutines.reactor/flux.html
[Flow.asFlux]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactor/kotlinhax.shadowroutines.reactor/as-flux.html
[ReactorContext]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactor/kotlinhax.shadowroutines.reactor/-reactor-context/index.html
[kotlinhax.shadowroutines.Job.asMono]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactor/kotlinhax.shadowroutines.reactor/as-mono.html
[kotlinhax.shadowroutines.Deferred.asMono]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactor/kotlinhax.shadowroutines.reactor/as-mono.html
[reactor.core.scheduler.Scheduler.asCoroutineDispatcher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactor/kotlinhax.shadowroutines.reactor/as-coroutine-dispatcher.html

<!--- END -->

# Package kotlinhax.shadowroutines.reactor

Utilities for [Reactor](https://projectreactor.io).
