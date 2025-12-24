# Module kotlinhax-shadowroutines-rx3

Utilities for [RxJava 3.x](https://github.com/ReactiveX/RxJava).

Coroutine builders:

| **Name**        | **Result**                              | **Scope**        | **Description**
| --------------- | --------------------------------------- | ---------------- | ---------------
| [rxCompletable] | `Completable`                           | [CoroutineScope] | Cold completable that starts coroutine on subscribe
| [rxMaybe]       | `Maybe`                                 | [CoroutineScope] | Cold maybe that starts coroutine on subscribe
| [rxSingle]      | `Single`                                | [CoroutineScope] | Cold single that starts coroutine on subscribe
| [rxObservable]  | `Observable`                            | [ProducerScope]  | Cold observable that starts coroutine on subscribe
| [rxFlowable]    | `Flowable`                              | [ProducerScope]  | Cold observable that starts coroutine on subscribe with **backpressure** support 

Integration with [Flow]:

| **Name**                   | **Result**      | **Description**
| ---------------            | --------------  | ---------------
| [Flow.asFlowable]          | `Flowable`      | Converts the given flow to a cold Flowable.
| [Flow.asObservable]        | `Observable`    | Converts the given flow to a cold Observable.
| [ObservableSource.asFlow]  | `Flow`          | Converts the given cold ObservableSource to flow

Suspending extension functions and suspending iteration:

| **Name** | **Description**
| -------- | ---------------
| [CompletableSource.await][io.reactivex.rxjava3.core.CompletableSource.await] | Awaits for completion of the completable value 
| [MaybeSource.awaitSingle][io.reactivex.rxjava3.core.MaybeSource.awaitSingle] | Awaits for the value of the maybe and returns it or throws an exception
| [MaybeSource.awaitSingleOrNull][io.reactivex.rxjava3.core.MaybeSource.awaitSingleOrNull] | Awaits for the value of the maybe and returns it or null 
| [SingleSource.await][io.reactivex.rxjava3.core.SingleSource.await] | Awaits for completion of the single value and returns it 
| [ObservableSource.awaitFirst][io.reactivex.rxjava3.core.ObservableSource.awaitFirst] | Awaits for the first value from the given observable
| [ObservableSource.awaitFirstOrDefault][io.reactivex.rxjava3.core.ObservableSource.awaitFirstOrDefault] | Awaits for the first value from the given observable or default
| [ObservableSource.awaitFirstOrElse][io.reactivex.rxjava3.core.ObservableSource.awaitFirstOrElse] | Awaits for the first value from the given observable or default from a function
| [ObservableSource.awaitFirstOrNull][io.reactivex.rxjava3.core.ObservableSource.awaitFirstOrNull] | Awaits for the first value from the given observable or null
| [ObservableSource.awaitLast][io.reactivex.rxjava3.core.ObservableSource.awaitFirst] | Awaits for the last value from the given observable
| [ObservableSource.awaitSingle][io.reactivex.rxjava3.core.ObservableSource.awaitSingle] | Awaits for the single value from the given observable

Note that `Flowable` is a subclass of [Reactive Streams](https://www.reactive-streams.org)
`Publisher` and extensions for it are covered by
[kotlinhax-shadowroutines-reactive](../kotlinhax-shadowroutines-reactive) module.

Conversion functions:

| **Name** | **Description**
| -------- | ---------------
| [Job.asCompletable][kotlinhax.shadowroutines.Job.asCompletable] | Converts job to hot completable
| [Deferred.asSingle][kotlinhax.shadowroutines.Deferred.asSingle] | Converts deferred value to hot single
| [Scheduler.asCoroutineDispatcher][io.reactivex.rxjava3.core.Scheduler.asCoroutineDispatcher] | Converts scheduler to [CoroutineDispatcher]

<!--- MODULE kotlinhax-shadowroutines-core -->
<!--- INDEX kotlinhax.shadowroutines -->

[CoroutineScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-scope/index.html
[CoroutineDispatcher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-dispatcher/index.html

<!--- INDEX kotlinhax.shadowroutines.channels -->

[ProducerScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-producer-scope/index.html

<!--- INDEX kotlinhax.shadowroutines.flow -->

[Flow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/-flow/index.html

<!--- MODULE kotlinhax-shadowroutines-rx3 -->
<!--- INDEX kotlinhax.shadowroutines.rx3 -->

[rxCompletable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/rx-completable.html
[rxMaybe]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/rx-maybe.html
[rxSingle]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/rx-single.html
[rxObservable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/rx-observable.html
[rxFlowable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/rx-flowable.html
[Flow.asFlowable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/as-flowable.html
[Flow.asObservable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/as-observable.html
[ObservableSource.asFlow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/as-flow.html
[io.reactivex.rxjava3.core.CompletableSource.await]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/await.html
[io.reactivex.rxjava3.core.MaybeSource.awaitSingle]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/await-single.html
[io.reactivex.rxjava3.core.MaybeSource.awaitSingleOrNull]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/await-single-or-null.html
[io.reactivex.rxjava3.core.SingleSource.await]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/await.html
[io.reactivex.rxjava3.core.ObservableSource.awaitFirst]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/await-first.html
[io.reactivex.rxjava3.core.ObservableSource.awaitFirstOrDefault]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/await-first-or-default.html
[io.reactivex.rxjava3.core.ObservableSource.awaitFirstOrElse]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/await-first-or-else.html
[io.reactivex.rxjava3.core.ObservableSource.awaitFirstOrNull]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/await-first-or-null.html
[io.reactivex.rxjava3.core.ObservableSource.awaitSingle]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/await-single.html
[kotlinhax.shadowroutines.Job.asCompletable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/as-completable.html
[kotlinhax.shadowroutines.Deferred.asSingle]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/as-single.html
[io.reactivex.rxjava3.core.Scheduler.asCoroutineDispatcher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx3/kotlinhax.shadowroutines.rx3/as-coroutine-dispatcher.html

<!--- END -->

# Package kotlinhax.shadowroutines.rx3

Utilities for [RxJava 3.x](https://github.com/ReactiveX/RxJava).
