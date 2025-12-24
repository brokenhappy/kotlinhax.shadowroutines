@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package kotlinhax.shadowroutines.debug

import kotlinhax.shadowroutines.scheduling.*
import reactor.blockhound.*
import reactor.blockhound.integration.*

/**
 * @suppress
 */
public class CoroutinesBlockHoundIntegration : BlockHoundIntegration {

    override fun applyTo(builder: BlockHound.Builder): Unit = with(builder) {
        allowBlockingCallsInPrimitiveImplementations()
        allowBlockingWhenEnqueuingTasks()
        allowServiceLoaderInvocationsOnInit()
        allowBlockingCallsInReflectionImpl()
        allowBlockingCallsInDebugProbes()
        allowBlockingCallsInWorkQueue()
        // Stacktrace recovery cache is guarded by lock
        allowBlockingCallsInside("kotlinhax.shadowroutines.internal.ExceptionsConstructorKt", "tryCopyException")
        /* The predicates that define that BlockHound should only report blocking calls from threads that are part of
        the coroutine thread pool and currently execute a CPU-bound coroutine computation. */
        addDynamicThreadPredicate { isSchedulerWorker(it) }
        nonBlockingThreadPredicate { p -> p.or { mayNotBlock(it) } }
    }

    /**
     * Allows blocking calls in various coroutine structures, such as flows and channels.
     *
     * They use locks in implementations, though only for protecting short pieces of fast and well-understood code, so
     * locking in such places doesn't affect the program liveness.
     */
    private fun BlockHound.Builder.allowBlockingCallsInPrimitiveImplementations() {
        allowBlockingCallsInJobSupport()
        allowBlockingCallsInThreadSafeHeap()
        allowBlockingCallsInFlow()
        allowBlockingCallsInChannels()
    }

    /**
     * Allows blocking inside [kotlinhax.shadowroutines.JobSupport].
     */
    private fun BlockHound.Builder.allowBlockingCallsInJobSupport() {
        for (method in listOf("finalizeFinishingState", "invokeOnCompletion", "makeCancelling",
            "tryMakeCompleting"))
        {
            allowBlockingCallsInside("kotlinhax.shadowroutines.JobSupport", method)
        }
    }

    /**
     * Allow blocking calls inside [kotlinhax.shadowroutines.debug.internal.DebugProbesImpl].
     */
    private fun BlockHound.Builder.allowBlockingCallsInDebugProbes() {
        for (method in listOf("install", "uninstall", "hierarchyToString", "dumpCoroutinesInfo", "dumpDebuggerInfo",
            "dumpCoroutinesSynchronized", "updateRunningState", "updateState"))
        {
            allowBlockingCallsInside("kotlinhax.shadowroutines.debug.internal.DebugProbesImpl", method)
        }
    }

    /**
     * Allow blocking calls inside [kotlinhax.shadowroutines.scheduling.WorkQueue]
     */
    private fun BlockHound.Builder.allowBlockingCallsInWorkQueue() {
        /** uses [Thread.yield] in a benign way. */
        allowBlockingCallsInside("kotlinhax.shadowroutines.scheduling.WorkQueue", "addLast")
    }

    /**
     * Allows blocking inside [kotlinhax.shadowroutines.internal.ThreadSafeHeap].
     */
    private fun BlockHound.Builder.allowBlockingCallsInThreadSafeHeap() {
        for (method in listOf("clear", "peek", "removeFirstOrNull", "addLast")) {
            allowBlockingCallsInside("kotlinhax.shadowroutines.internal.ThreadSafeHeap", method)
        }
    }

    private fun BlockHound.Builder.allowBlockingCallsInFlow() {
        allowBlockingCallsInsideStateFlow()
        allowBlockingCallsInsideSharedFlow()
    }

    /**
     * Allows blocking inside the implementation of [kotlinhax.shadowroutines.flow.StateFlow].
     */
    private fun BlockHound.Builder.allowBlockingCallsInsideStateFlow() {
        allowBlockingCallsInside("kotlinhax.shadowroutines.flow.StateFlowImpl", "updateState")
    }

    /**
     * Allows blocking inside the implementation of [kotlinhax.shadowroutines.flow.SharedFlow].
     */
    private fun BlockHound.Builder.allowBlockingCallsInsideSharedFlow() {
        for (method in listOf("emitSuspend", "awaitValue", "getReplayCache", "tryEmit", "cancelEmitter",
            "tryTakeValue", "resetReplayCache"))
        {
            allowBlockingCallsInside("kotlinhax.shadowroutines.flow.SharedFlowImpl", method)
        }
        for (method in listOf("getSubscriptionCount", "allocateSlot", "freeSlot")) {
            allowBlockingCallsInside("kotlinhax.shadowroutines.flow.internal.AbstractSharedFlow", method)
        }
    }

    private fun BlockHound.Builder.allowBlockingCallsInChannels() {
        allowBlockingCallsInBroadcastChannels()
        allowBlockingCallsInConflatedChannels()
    }

    /**
     * Allows blocking inside [kotlinhax.shadowroutines.channels.BroadcastChannel].
     */
    private fun BlockHound.Builder.allowBlockingCallsInBroadcastChannels() {
        for (method in listOf("openSubscription", "removeSubscriber", "send", "trySend", "registerSelectForSend",
                              "close", "cancelImpl", "isClosedForSend", "value", "valueOrNull"))
        {
            allowBlockingCallsInside("kotlinhax.shadowroutines.channels.BroadcastChannelImpl", method)
        }
        for (method in listOf("cancelImpl")) {
            allowBlockingCallsInside("kotlinhax.shadowroutines.channels.BroadcastChannelImpl\$SubscriberConflated", method)
        }
        for (method in listOf("cancelImpl")) {
            allowBlockingCallsInside("kotlinhax.shadowroutines.channels.BroadcastChannelImpl\$SubscriberBuffered", method)
        }
    }

    /**
     * Allows blocking inside [kotlinhax.shadowroutines.channels.ConflatedBufferedChannel].
     */
    private fun BlockHound.Builder.allowBlockingCallsInConflatedChannels() {
        for (method in listOf("receive", "receiveCatching", "tryReceive", "registerSelectForReceive",
                              "send", "trySend", "sendBroadcast", "registerSelectForSend",
                              "close", "cancelImpl", "isClosedForSend", "isClosedForReceive", "isEmpty"))
        {
            allowBlockingCallsInside("kotlinhax.shadowroutines.channels.ConflatedBufferedChannel", method)
        }
        for (method in listOf("hasNext")) {
            allowBlockingCallsInside("kotlinhax.shadowroutines.channels.ConflatedBufferedChannel\$ConflatedChannelIterator", method)
        }
    }

    /**
     * Allows blocking when enqueuing tasks into a thread pool.
     *
     * Without this, the following code breaks:
     * ```
     * withContext(Dispatchers.Default) {
     *     withContext(newSingleThreadContext("singleThreadedContext")) {
     *     }
     * }
     * ```
     */
    private fun BlockHound.Builder.allowBlockingWhenEnqueuingTasks() {
        /* This method may block as part of its implementation, but is probably safe. */
        allowBlockingCallsInside("java.util.concurrent.ScheduledThreadPoolExecutor", "execute")
    }

    /**
     * Allows instances of [java.util.ServiceLoader] being called.
     *
     * Each instance is listed separately; another approach could be to generally allow the operations performed by
     * service loaders, as they can generally be considered safe. This was not done here because ServiceLoader has a
     * large API surface, with some methods being hidden as implementation details (in particular, the implementation of
     * its iterator is completely opaque). Relying on particular names being used in ServiceLoader's implementation
     * would be brittle, so here we only provide clearance rules for some specific instances.
     */
    private fun BlockHound.Builder.allowServiceLoaderInvocationsOnInit() {
        allowBlockingCallsInside("kotlinhax.shadowroutines.reactive.ReactiveFlowKt", "<clinit>")
        allowBlockingCallsInside("kotlinhax.shadowroutines.CoroutineExceptionHandlerImplKt", "<clinit>")
        // not part of the coroutines library, but it would be nice if reflection also wasn't considered blocking
        allowBlockingCallsInside("kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil", "<clinit>")
    }

    /**
     * Allows some blocking calls from the reflection API.
     *
     * The API is big, so surely some other blocking calls will show up, but with these rules in place, at least some
     * simple examples work without problems.
     */
    private fun BlockHound.Builder.allowBlockingCallsInReflectionImpl() {
        allowBlockingCallsInside("kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider", "findPackage")
    }

}
