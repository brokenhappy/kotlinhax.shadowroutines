# Module kotlinhax-shadowroutines-core

Core primitives to work with coroutines.

Coroutine builder functions:

| **Name**                                       | **Result**                                                   | **Scope**                                                  | **Description**
| ---------------------------------------------- | ------------------------------------------------------------ | ---------------------------------------------------------- | ---------------
| [launch][kotlinhax.shadowroutines.launch]            | [Job][kotlinhax.shadowroutines.Job]                                | [CoroutineScope][kotlinhax.shadowroutines.CoroutineScope]        | Launches coroutine that does not have any result 
| [async][kotlinhax.shadowroutines.async]              | [Deferred][kotlinhax.shadowroutines.Deferred]                      | [CoroutineScope][kotlinhax.shadowroutines.CoroutineScope]        | Returns a single value with the future result
| [produce][kotlinhax.shadowroutines.channels.produce] | [ReceiveChannel][kotlinhax.shadowroutines.channels.ReceiveChannel] | [ProducerScope][kotlinhax.shadowroutines.channels.ProducerScope] | Produces a stream of elements
| [runBlocking][kotlinhax.shadowroutines.runBlocking]  | `T`                                                          | [CoroutineScope][kotlinhax.shadowroutines.CoroutineScope]        | Blocks the thread while the coroutine runs

Coroutine dispatchers implementing [CoroutineDispatcher]:
 
| **Name**                                                                                            | **Description**
| --------------------------------------------------------------------------------------------------- | ---------------
| [Dispatchers.Main][kotlinhax.shadowroutines.Dispatchers.Main]                                             | Confines coroutine execution to the UI thread
| [Dispatchers.Default][kotlinhax.shadowroutines.Dispatchers.Default]                                       | Confines coroutine execution to a shared pool of background threads
| [Dispatchers.Unconfined][kotlinhax.shadowroutines.Dispatchers.Unconfined]                                 | Does not confine coroutine execution in any way
| [CoroutineDispatcher.limitedParallelism][kotlinhax.shadowroutines.CoroutineDispatcher.limitedParallelism] | Creates a view of the given dispatcher, limiting the number of tasks executing in parallel

More context elements:

| **Name**                                                                  | **Description**
| ------------------------------------------------------------------------- | ---------------
| [NonCancellable][kotlinhax.shadowroutines.NonCancellable]                       | A non-cancelable job that is always active
| [CoroutineExceptionHandler][kotlinhax.shadowroutines.CoroutineExceptionHandler] | Handler for uncaught exception

Synchronization primitives for coroutines:

| **Name**                                                                                                                                             | **Suspending functions**                                                                                            | **Description**
|------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------| ---------------
| [Mutex][kotlinhax.shadowroutines.sync.Mutex]                                                                                                               | [lock][kotlinhax.shadowroutines.sync.Mutex.lock]                                                                          | Mutual exclusion
| [Semaphore][kotlinhax.shadowroutines.sync.Semaphore]                                                                                                       | [acquire][kotlinhax.shadowroutines.sync.Semaphore.acquire]                                                                | Limiting the maximum concurrency
| [Channel][kotlinhax.shadowroutines.channels.Channel]                                                                                                       | [send][kotlinhax.shadowroutines.channels.SendChannel.send], [receive][kotlinhax.shadowroutines.channels.ReceiveChannel.receive] | Communication channel (aka queue or exchanger)
| [Flow](https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/-flow/)                                         | [collect][kotlinhax.shadowroutines.flow.Flow.collect]                                                                     | Asynchronous stream of values

<!---  Flow direct link is here to workaround MD case-insensitivity -->

Top-level suspending functions:

| **Name**                                                  | **Description**
| --------------------------------------------------------- | ---------------
| [delay][kotlinhax.shadowroutines.delay]                         | Non-blocking sleep
| [yield][kotlinhax.shadowroutines.yield]                         | Yields thread in single-threaded dispatchers
| [withContext][kotlinhax.shadowroutines.withContext]             | Switches to a different context
| [withTimeout][kotlinhax.shadowroutines.withTimeout]             | Set execution time-limit with exception on timeout 
| [withTimeoutOrNull][kotlinhax.shadowroutines.withTimeoutOrNull] | Set execution time-limit will null result on timeout
| [awaitAll][kotlinhax.shadowroutines.awaitAll]                   | Awaits for successful completion of all given jobs or exceptional completion of any
| [joinAll][kotlinhax.shadowroutines.joinAll]                     | Joins on all given jobs

Cancellation support for user-defined suspending functions is available with [suspendCancellableCoroutine]
helper function.
The [NonCancellable] job object is provided to suppress cancellation inside the
`withContext(NonCancellable) {...}` block of code.

Ways to construct asynchronous streams of values:

| **Name**                                                              | **Type** | **Description**
| --------------------------------------------------------------------- | -------- | ---------------
| [flow][kotlinhax.shadowroutines.flow.flow]                                  | cold     | Runs a generator-style block of code that emits values
| [flowOf][kotlinhax.shadowroutines.flow.flowOf]                              | cold     | Emits the values passed as arguments
| [channelFlow][kotlinhax.shadowroutines.flow.channelFlow]                    | cold     | Runs the given code, providing a channel sending to which means emitting from the flow
| [callbackFlow][kotlinhax.shadowroutines.flow.callbackFlow]                  | cold     | Allows transforming a callback-based API into a flow
| [ReceiveChannel.consumeAsFlow][kotlinhax.shadowroutines.flow.consumeAsFlow] | hot      | Transforms a channel into a flow, emitting all of the received values to a single subscriber
| [ReceiveChannel.receiveAsFlow][kotlinhax.shadowroutines.flow.receiveAsFlow] | hot      | Transforms a channel into a flow, distributing the received values among its subscribers
| [MutableSharedFlow][kotlinhax.shadowroutines.flow.MutableSharedFlow]        | hot      | Allows emitting each value to arbitrarily many subscribers at once
| [MutableStateFlow][kotlinhax.shadowroutines.flow.MutableStateFlow]          | hot      | Represents mutable state as a flow

A *cold* stream is some process of generating values, and this process is performed separately for each subscriber.
A *hot* stream uses the same source of values independently of whether there are subscribers.

A [select][kotlinhax.shadowroutines.selects.select] expression waits for the result of multiple suspending functions simultaneously:

| **Receiver**                                                 | **Suspending function**                                         | **Select clause**                                                 | **Non-suspending version**
| ------------------------------------------------------------ | --------------------------------------------------------------- | ----------------------------------------------------------------- | --------------------------
| [Job][kotlinhax.shadowroutines.Job]                                | [join][kotlinhax.shadowroutines.Job.join]                             | [onJoin][kotlinhax.shadowroutines.Job.onJoin]                           | [isCompleted][kotlinhax.shadowroutines.Job.isCompleted]
| [Deferred][kotlinhax.shadowroutines.Deferred]                      | [await][kotlinhax.shadowroutines.Deferred.await]                      | [onAwait][kotlinhax.shadowroutines.Deferred.onAwait]                    | [isCompleted][kotlinhax.shadowroutines.Job.isCompleted]
| [SendChannel][kotlinhax.shadowroutines.channels.SendChannel]       | [send][kotlinhax.shadowroutines.channels.SendChannel.send]            | [onSend][kotlinhax.shadowroutines.channels.SendChannel.onSend]          | [trySend][kotlinhax.shadowroutines.channels.SendChannel.trySend]
| [ReceiveChannel][kotlinhax.shadowroutines.channels.ReceiveChannel] | [receive][kotlinhax.shadowroutines.channels.ReceiveChannel.receive]   | [onReceive][kotlinhax.shadowroutines.channels.ReceiveChannel.onReceive] | [tryReceive][kotlinhax.shadowroutines.channels.ReceiveChannel.tryReceive]
| [ReceiveChannel][kotlinhax.shadowroutines.channels.ReceiveChannel] | [receiveCatching][kotlinhax.shadowroutines.channels.receiveCatching]  | [onReceiveCatching][kotlinhax.shadowroutines.channels.onReceiveCatching] | [tryReceive][kotlinhax.shadowroutines.channels.ReceiveChannel.tryReceive]
| none                                                         | [delay][kotlinhax.shadowroutines.delay]                               | [onTimeout][kotlinhax.shadowroutines.selects.SelectBuilder.onTimeout]   | none

# Package kotlinhax.shadowroutines

General-purpose coroutine builders, contexts, and helper functions.

# Package kotlinhax.shadowroutines.sync

Synchronization primitives (mutex and semaphore).

# Package kotlinhax.shadowroutines.channels

Channels &mdash; non-blocking primitives for communicating a stream of elements between coroutines.

# Package kotlinhax.shadowroutines.flow

Flow &mdash; asynchronous cold and hot streams of elements.

# Package kotlinhax.shadowroutines.selects

Select &mdash; expressions that perform multiple suspending operations simultaneously until one of them succeeds.

# Package kotlinhax.shadowroutines.intrinsics

Low-level primitives for finer-grained control of coroutines.

# Package kotlinhax.shadowroutines.future

[JDK 8's `CompletableFuture`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html) support.

# Package kotlinhax.shadowroutines.stream

[JDK 8's `Stream`](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html) support.

# Package kotlinhax.shadowroutines.time

[JDK 8's `Duration`](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html) support via additional overloads for existing time-based operators.

<!--- MODULE kotlinhax-shadowroutines-core -->
<!--- INDEX kotlinhax.shadowroutines -->

[kotlinhax.shadowroutines.launch]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/launch.html
[kotlinhax.shadowroutines.Job]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-job/index.html
[kotlinhax.shadowroutines.CoroutineScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-scope/index.html
[kotlinhax.shadowroutines.async]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/async.html
[kotlinhax.shadowroutines.Deferred]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-deferred/index.html
[kotlinhax.shadowroutines.runBlocking]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/run-blocking.html
[CoroutineDispatcher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-dispatcher/index.html
[kotlinhax.shadowroutines.Dispatchers.Main]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-dispatchers/-main.html
[kotlinhax.shadowroutines.Dispatchers.Default]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-dispatchers/-default.html
[kotlinhax.shadowroutines.Dispatchers.Unconfined]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-dispatchers/-unconfined.html
[kotlinhax.shadowroutines.CoroutineDispatcher.limitedParallelism]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-dispatcher/limited-parallelism.html
[kotlinhax.shadowroutines.NonCancellable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-non-cancellable/index.html
[kotlinhax.shadowroutines.CoroutineExceptionHandler]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-exception-handler/index.html
[kotlinhax.shadowroutines.delay]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/delay.html
[kotlinhax.shadowroutines.yield]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/yield.html
[kotlinhax.shadowroutines.withContext]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/with-context.html
[kotlinhax.shadowroutines.withTimeout]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/with-timeout.html
[kotlinhax.shadowroutines.withTimeoutOrNull]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/with-timeout-or-null.html
[kotlinhax.shadowroutines.awaitAll]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/await-all.html
[kotlinhax.shadowroutines.joinAll]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/join-all.html
[suspendCancellableCoroutine]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/suspend-cancellable-coroutine.html
[NonCancellable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-non-cancellable/index.html
[kotlinhax.shadowroutines.Job.join]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-job/join.html
[kotlinhax.shadowroutines.Job.onJoin]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-job/on-join.html
[kotlinhax.shadowroutines.Job.isCompleted]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-job/is-completed.html
[kotlinhax.shadowroutines.Deferred.await]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-deferred/await.html
[kotlinhax.shadowroutines.Deferred.onAwait]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-deferred/on-await.html

<!--- INDEX kotlinhax.shadowroutines.flow -->

[kotlinhax.shadowroutines.flow.Flow.collect]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/collect.html
[kotlinhax.shadowroutines.flow.flow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/flow.html
[kotlinhax.shadowroutines.flow.flowOf]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/flow-of.html
[kotlinhax.shadowroutines.flow.channelFlow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/channel-flow.html
[kotlinhax.shadowroutines.flow.callbackFlow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/callback-flow.html
[kotlinhax.shadowroutines.flow.consumeAsFlow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/consume-as-flow.html
[kotlinhax.shadowroutines.flow.receiveAsFlow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/receive-as-flow.html
[kotlinhax.shadowroutines.flow.MutableSharedFlow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/-mutable-shared-flow/index.html
[kotlinhax.shadowroutines.flow.MutableStateFlow]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.flow/-mutable-state-flow/index.html

<!--- INDEX kotlinhax.shadowroutines.sync -->

[kotlinhax.shadowroutines.sync.Mutex]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.sync/-mutex/index.html
[kotlinhax.shadowroutines.sync.Mutex.lock]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.sync/-mutex/lock.html
[kotlinhax.shadowroutines.sync.Semaphore]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.sync/-semaphore/index.html
[kotlinhax.shadowroutines.sync.Semaphore.acquire]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.sync/-semaphore/acquire.html

<!--- INDEX kotlinhax.shadowroutines.channels -->

[kotlinhax.shadowroutines.channels.produce]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/produce.html
[kotlinhax.shadowroutines.channels.ReceiveChannel]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/index.html
[kotlinhax.shadowroutines.channels.ProducerScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-producer-scope/index.html
[kotlinhax.shadowroutines.channels.Channel]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-channel/index.html
[kotlinhax.shadowroutines.channels.SendChannel.send]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-send-channel/send.html
[kotlinhax.shadowroutines.channels.ReceiveChannel.receive]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/receive.html
[kotlinhax.shadowroutines.channels.SendChannel]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-send-channel/index.html
[kotlinhax.shadowroutines.channels.SendChannel.onSend]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-send-channel/on-send.html
[kotlinhax.shadowroutines.channels.SendChannel.trySend]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-send-channel/try-send.html
[kotlinhax.shadowroutines.channels.ReceiveChannel.onReceive]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/on-receive.html
[kotlinhax.shadowroutines.channels.ReceiveChannel.tryReceive]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/try-receive.html
[kotlinhax.shadowroutines.channels.receiveCatching]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/receive-catching.html
[kotlinhax.shadowroutines.channels.onReceiveCatching]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/on-receive-catching.html

<!--- INDEX kotlinhax.shadowroutines.selects -->

[kotlinhax.shadowroutines.selects.select]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.selects/select.html
[kotlinhax.shadowroutines.selects.SelectBuilder.onTimeout]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.selects/on-timeout.html

<!--- INDEX kotlinhax.shadowroutines.test -->
<!--- END -->
