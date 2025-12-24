# Module kotlinhax-shadowroutines-reactive

Utilities for [Reactive Streams](https://www.reactive-streams.org).

Coroutine builders:

| **Name**        | **Result**                    | **Scope**        | **Description**
| --------------- | ----------------------------- | ---------------- | ---------------
| [kotlinhax.shadowroutines.reactive.publish]       | `Publisher`                   | [ProducerScope] | Cold reactive publisher that starts the coroutine on subscribe

Integration with [Flow]:

| **Name**            | **Result**        | **Description**
| ---------------     | --------------    | ---------------
| [Publisher.asFlow]  | `Flow`            | Converts the given publisher to a flow
| [Flow.asPublisher]  | `Publisher`       | Converts the given flow to a TCK-compliant publisher

If these adapters are used along with `kotlinhax-shadowroutines-reactor` in the classpath, then Reactor's `Context` is properly
propagated as coroutine context element (`ReactorContext`) and vice versa.

Suspending extension functions and suspending iteration:

| **Name** | **Description**
| -------- | ---------------
| [Publisher.awaitFirst][org.reactivestreams.Publisher.awaitFirst] | Returns the first value from the given publisher
| [Publisher.awaitFirstOrDefault][org.reactivestreams.Publisher.awaitFirstOrDefault] | Returns the first value from the given publisher or default
| [Publisher.awaitFirstOrElse][org.reactivestreams.Publisher.awaitFirstOrElse] | Returns the first value from the given publisher or default from a function
| [Publisher.awaitFirstOrNull][org.reactivestreams.Publisher.awaitFirstOrNull] | Returns the first value from the given publisher or null
| [Publisher.awaitLast][org.reactivestreams.Publisher.awaitFirst] | Returns the last value from the given publisher
| [Publisher.awaitSingle][org.reactivestreams.Publisher.awaitSingle] | Returns the single value from the given publisher

<!--- MODULE kotlinhax-shadowroutines-core -->
<!--- INDEX kotlinhax.shadowroutines -->
<!--- INDEX kotlinhax.shadowroutines.flow -->

[Flow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/-flow/index.html

<!--- INDEX kotlinhax.shadowroutines.channels -->

[ProducerScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-producer-scope/index.html

<!--- MODULE kotlinhax-shadowroutines-reactive -->
<!--- INDEX kotlinhax.shadowroutines.reactive -->

[kotlinhax.shadowroutines.reactive.publish]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactive/kotlinhax.shadowroutines.reactive/publish.html
[Publisher.asFlow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactive/kotlinhax.shadowroutines.reactive/as-flow.html
[Flow.asPublisher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactive/kotlinhax.shadowroutines.reactive/as-publisher.html
[org.reactivestreams.Publisher.awaitFirst]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactive/kotlinhax.shadowroutines.reactive/await-first.html
[org.reactivestreams.Publisher.awaitFirstOrDefault]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactive/kotlinhax.shadowroutines.reactive/await-first-or-default.html
[org.reactivestreams.Publisher.awaitFirstOrElse]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactive/kotlinhax.shadowroutines.reactive/await-first-or-else.html
[org.reactivestreams.Publisher.awaitFirstOrNull]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactive/kotlinhax.shadowroutines.reactive/await-first-or-null.html
[org.reactivestreams.Publisher.awaitSingle]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-reactive/kotlinhax.shadowroutines.reactive/await-single.html

<!--- END -->

# Package kotlinhax.shadowroutines.reactive

Utilities for [Reactive Streams](https://www.reactive-streams.org).
