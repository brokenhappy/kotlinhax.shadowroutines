package benchmarks.flow

import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.flow.*
import org.openjdk.jmh.annotations.*
import java.util.concurrent.*
import benchmarks.flow.scrabble.flow as unsafeFlow
import kotlinhax.shadowroutines.flow.flow as safeFlow

@Warmup(iterations = 7, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 7, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
open class SafeFlowBenchmark {

    private fun numbersSafe() = safeFlow {
        for (i in 2L..1000L) emit(i)
    }

    private fun numbersUnsafe() = unsafeFlow {
        for (i in 2L..1000L) emit(i)
    }

    @Benchmark
    fun safeNumbers(): Int = runBlocking {
        numbersSafe().count()
    }

    @Benchmark
    fun unsafeNumbers(): Int = runBlocking {
        numbersUnsafe().count()
    }
}
