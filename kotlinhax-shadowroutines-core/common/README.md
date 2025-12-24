# Module kotlinhax-shadowroutines-core

Core primitives to work with coroutines available on all platforms.

Coroutine builder functions:

| **Name**      | **Result**    | **Scope**        | **Description**
| ------------- | ------------- | ---------------- | ---------------
| [launch]      | [Job]         | [CoroutineScope] | Launches coroutine that does not have any result 
| [async]       | [Deferred]    | [CoroutineScope] | Returns a single value with the future result
| [produce][kotlinhax.shadowroutines.channels.produce]     | [ReceiveChannel][kotlinhax.shadowroutines.channels.ReceiveChannel] | [ProducerScope][kotlinhax.shadowroutines.channels.ProducerScope]  | Produces a stream of elements
| [actor][kotlinhax.shadowroutines.channels.actor]     | [SendChannel][kotlinhax.shadowroutines.channels.SendChannel] | [ActorScope][kotlinhax.shadowroutines.channels.ActorScope]  | Processes a stream of messages

Coroutine dispatchers implementing [CoroutineDispatcher]:
 
| **Name**                    | **Description**
| --------------------------- | ---------------
| [Dispatchers.Default]       | Confines coroutine execution to a shared pool of background threads
| [Dispatchers.Unconfined]    | Does not confine coroutine execution in any way
| [newSingleThreadContext]    | Creates a single-threaded coroutine context
| [newFixedThreadPoolContext] | Creates a thread pool of a fixed size 
| [Executor.asCoroutineDispatcher][asCoroutineDispatcher] | Extension to convert any executor

More context elements:

| **Name**                    | **Description**
| --------------------------- | ---------------
| [NonCancellable]            | A non-cancelable job that is always active
| [CoroutineExceptionHandler] | Handler for uncaught exception

Synchronization primitives for coroutines:

| **Name**   | **Suspending functions**                                    | **Description**
| ---------- | ----------------------------------------------------------- | ---------------
| [Mutex][kotlinhax.shadowroutines.sync.Mutex]          | [lock][kotlinhax.shadowroutines.sync.Mutex.lock]                                          | Mutual exclusion 
| [Channel][kotlinhax.shadowroutines.channels.Channel]  | [send][kotlinhax.shadowroutines.channels.SendChannel.send], [receive][kotlinhax.shadowroutines.channels.ReceiveChannel.receive] | Communication channel (aka queue or exchanger)

Top-level suspending functions:

| **Name**                 | **Description**
| -------------------      | ---------------
| [delay]                  | Non-blocking sleep
| [yield]                  | Yields thread in single-threaded dispatchers
| [withContext]            | Switches to a different context
| [withTimeout]            | Set execution time-limit with exception on timeout 
| [withTimeoutOrNull]      | Set execution time-limit will null result on timeout
| [awaitAll]               | Awaits for successful completion of all given jobs or exceptional completion of any
| [joinAll]                | Joins on all given jobs

Cancellation support for user-defined suspending functions is available with [suspendCancellableCoroutine]
helper function. [NonCancellable] job object is provided to suppress cancellation with 
`withContext(NonCancellable) {...}` block of code.

[Select][kotlinhax.shadowroutines.selects.select] expression waits for the result of multiple suspending functions simultaneously:

| **Receiver**     | **Suspending function**                       | **Select clause**                                | **Non-suspending version**
| ---------------- | --------------------------------------------- | ------------------------------------------------ | --------------------------
| [Job]            | [join][Job.join]                              | [onJoin][Job.onJoin]                   | [isCompleted][Job.isCompleted]
| [Deferred]       | [await][Deferred.await]                       | [onAwait][Deferred.onAwait]                 | [isCompleted][Job.isCompleted]
| [SendChannel][kotlinhax.shadowroutines.channels.SendChannel]    | [send][kotlinhax.shadowroutines.channels.SendChannel.send]                      | [onSend][kotlinhax.shadowroutines.channels.SendChannel.onSend]                   | [trySend][kotlinhax.shadowroutines.channels.SendChannel.trySend]
| [ReceiveChannel][kotlinhax.shadowroutines.channels.ReceiveChannel] | [receive][kotlinhax.shadowroutines.channels.ReceiveChannel.receive]             | [onReceive][kotlinhax.shadowroutines.channels.ReceiveChannel.onReceive]             | [tryReceive][kotlinhax.shadowroutines.channels.ReceiveChannel.tryReceive]
| [ReceiveChannel][kotlinhax.shadowroutines.channels.ReceiveChannel] | [receiveCatching][kotlinhax.shadowroutines.channels.ReceiveChannel.receiveCatching] | [onReceiveCatching][kotlinhax.shadowroutines.channels.ReceiveChannel.onReceiveCatching] | [tryReceive][kotlinhax.shadowroutines.channels.ReceiveChannel.tryReceive]
| none            | [delay]                                        | [onTimeout][kotlinhax.shadowroutines.selects.SelectBuilder.onTimeout]                   | none

This module provides debugging facilities for coroutines (run JVM with `-ea` or `-Dkotlinhax.shadowroutines.debug` options) 
and [newCoroutineContext] function to write user-defined coroutine builders that work with these
debugging facilities. See [DEBUG_PROPERTY_NAME] for more details.

# Package kotlinhax.shadowroutines

General-purpose coroutine builders, contexts, and helper functions.

# Package kotlinhax.shadowroutines.flow

Flow -- primitive to work with asynchronous and event-based streams of data.

# Package kotlinhax.shadowroutines.sync

Synchronization primitives (mutex).

# Package kotlinhax.shadowroutines.channels

Channels -- non-blocking primitives for communicating a stream of elements between coroutines.

# Package kotlinhax.shadowroutines.selects

Select expression to perform multiple suspending operations simultaneously until one of them succeeds.

# Package kotlinhax.shadowroutines.intrinsics

Low-level primitives for finer-grained control of coroutines.

<!--- MODULE kotlinhax-shadowroutines-core -->
<!--- INDEX kotlinhax.shadowroutines -->

[launch]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/launch.html
[Job]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-job/index.html
[CoroutineScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-scope/index.html
[async]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/async.html
[Deferred]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-deferred/index.html
[CoroutineDispatcher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-dispatcher/index.html
[Dispatchers.Default]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-dispatchers/-default.html
[Dispatchers.Unconfined]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-dispatchers/-unconfined.html
[newSingleThreadContext]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/new-single-thread-context.html
[newFixedThreadPoolContext]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/new-fixed-thread-pool-context.html
[asCoroutineDispatcher]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/as-coroutine-dispatcher.html
[NonCancellable]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-non-cancellable/index.html
[CoroutineExceptionHandler]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-coroutine-exception-handler/index.html
[delay]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/delay.html
[yield]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/yield.html
[withContext]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/with-context.html
[withTimeout]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/with-timeout.html
[withTimeoutOrNull]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/with-timeout-or-null.html
[awaitAll]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/await-all.html
[joinAll]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/join-all.html
[suspendCancellableCoroutine]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/suspend-cancellable-coroutine.html
[Job.join]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-job/join.html
[Job.onJoin]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-job/on-join.html
[Job.isCompleted]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-job/is-completed.html
[Deferred.await]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-deferred/await.html
[Deferred.onAwait]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-deferred/on-await.html
[newCoroutineContext]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/new-coroutine-context.html
[DEBUG_PROPERTY_NAME]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines/-d-e-b-u-g_-p-r-o-p-e-r-t-y_-n-a-m-e.html

<!--- INDEX kotlinhax.shadowroutines.sync -->

[kotlinhax.shadowroutines.sync.Mutex]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.sync/-mutex/index.html
[kotlinhax.shadowroutines.sync.Mutex.lock]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.sync/-mutex/lock.html

<!--- INDEX kotlinhax.shadowroutines.channels -->

[kotlinhax.shadowroutines.channels.produce]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/produce.html
[kotlinhax.shadowroutines.channels.ReceiveChannel]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/index.html
[kotlinhax.shadowroutines.channels.ProducerScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-producer-scope/index.html
[kotlinhax.shadowroutines.channels.actor]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/actor.html
[kotlinhax.shadowroutines.channels.SendChannel]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-send-channel/index.html
[kotlinhax.shadowroutines.channels.ActorScope]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-actor-scope/index.html
[kotlinhax.shadowroutines.channels.Channel]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-channel/index.html
[kotlinhax.shadowroutines.channels.SendChannel.send]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-send-channel/send.html
[kotlinhax.shadowroutines.channels.ReceiveChannel.receive]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/receive.html
[kotlinhax.shadowroutines.channels.SendChannel.onSend]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-send-channel/on-send.html
[kotlinhax.shadowroutines.channels.SendChannel.trySend]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-send-channel/try-send.html
[kotlinhax.shadowroutines.channels.ReceiveChannel.onReceive]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/on-receive.html
[kotlinhax.shadowroutines.channels.ReceiveChannel.tryReceive]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/try-receive.html
[kotlinhax.shadowroutines.channels.ReceiveChannel.receiveCatching]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/receive-catching.html
[kotlinhax.shadowroutines.channels.ReceiveChannel.onReceiveCatching]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.channels/-receive-channel/on-receive-catching.html

<!--- INDEX kotlinhax.shadowroutines.selects -->

[kotlinhax.shadowroutines.selects.select]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.selects/select.html
[kotlinhax.shadowroutines.selects.SelectBuilder.onTimeout]: https://kotlinlang.org/api/kotlinhax.shadowroutines/kotlinhax-shadowroutines-core/kotlinhax.shadowroutines.selects/on-timeout.html

<!--- END -->
