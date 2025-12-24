# Module kotlinhax-shadowroutines-rx2

Utilities for [RxJava 2.x](https://github.com/ReactiveX/RxJava).

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
| [CompletableSource.await][io.reactivex.CompletableSource.await] | Awaits for completion of the completable value 
| [MaybeSource.awaitSingle][io.reactivex.MaybeSource.awaitSingle] | Awaits for the value of the maybe and returns it or throws an exception
| [MaybeSource.awaitSingleOrNull][io.reactivex.MaybeSource.awaitSingleOrNull] | Awaits for the value of the maybe and returns it or null 
| [SingleSource.await][io.reactivex.SingleSource.await] | Awaits for completion of the single value and returns it 
| [ObservableSource.awaitFirst][io.reactivex.ObservableSource.awaitFirst] | Awaits for the first value from the given observable
| [ObservableSource.awaitFirstOrDefault][io.reactivex.ObservableSource.awaitFirstOrDefault] | Awaits for the first value from the given observable or default
| [ObservableSource.awaitFirstOrElse][io.reactivex.ObservableSource.awaitFirstOrElse] | Awaits for the first value from the given observable or default from a function
| [ObservableSource.awaitFirstOrNull][io.reactivex.ObservableSource.awaitFirstOrNull] | Awaits for the first value from the given observable or null
| [ObservableSource.awaitLast][io.reactivex.ObservableSource.awaitFirst] | Awaits for the last value from the given observable
| [ObservableSource.awaitSingle][io.reactivex.ObservableSource.awaitSingle] | Awaits for the single value from the given observable

Note that `Flowable` is a subclass of [Reactive Streams](https://www.reactive-streams.org)
`Publisher` and extensions for it are covered by
[kotlinhax-shadowroutines-reactive](../kotlinhax-shadowroutines-reactive) module.

Conversion functions:

| **Name** | **Description**
| -------- | ---------------
| [Job.asCompletable][kotlinhax.shadowroutines.Job.asCompletable] | Converts job to hot completable
| [Deferred.asSingle][kotlinhax.shadowroutines.Deferred.asSingle] | Converts deferred value to hot single
| [Scheduler.asCoroutineDispatcher][io.reactivex.Scheduler.asCoroutineDispatcher] | Converts scheduler to [CoroutineDispatcher]

<!--- MODULE kotlinhax-shadowroutines-core -->
<!--- INDEX kotlinhax.shadowroutines -->

[CoroutineScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-scope/index.html
[CoroutineDispatcher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-dispatcher/index.html

<!--- INDEX kotlinhax.shadowroutines.channels -->

[ProducerScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-producer-scope/index.html

<!--- INDEX kotlinhax.shadowroutines.flow -->

[Flow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/-flow/index.html

<!--- MODULE kotlinhax-shadowroutines-rx2 -->
<!--- INDEX kotlinhax.shadowroutines.rx2 -->

[rxCompletable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/rx-completable.html
[rxMaybe]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/rx-maybe.html
[rxSingle]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/rx-single.html
[rxObservable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/rx-observable.html
[rxFlowable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/rx-flowable.html
[Flow.asFlowable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/as-flowable.html
[Flow.asObservable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/as-observable.html
[ObservableSource.asFlow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/as-flow.html
[io.reactivex.CompletableSource.await]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/await.html
[io.reactivex.MaybeSource.awaitSingle]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/await-single.html
[io.reactivex.MaybeSource.awaitSingleOrNull]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/await-single-or-null.html
[io.reactivex.SingleSource.await]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/await.html
[io.reactivex.ObservableSource.awaitFirst]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/await-first.html
[io.reactivex.ObservableSource.awaitFirstOrDefault]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/await-first-or-default.html
[io.reactivex.ObservableSource.awaitFirstOrElse]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/await-first-or-else.html
[io.reactivex.ObservableSource.awaitFirstOrNull]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/await-first-or-null.html
[io.reactivex.ObservableSource.awaitSingle]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/await-single.html
[kotlinhax.shadowroutines.Job.asCompletable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/as-completable.html
[kotlinhax.shadowroutines.Deferred.asSingle]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/as-single.html
[io.reactivex.Scheduler.asCoroutineDispatcher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-rx2/kotlinhax.shadowroutines.rx2/as-coroutine-dispatcher.html

<!--- END -->

# Package kotlinhax.shadowroutines.rx2

Utilities for [RxJava 2.x](https://github.com/ReactiveX/RxJava).
