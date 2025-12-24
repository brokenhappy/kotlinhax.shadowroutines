// This file was automatically generated from exception-handling.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.test

import kotlinhax.shadowroutines.knit.*
import org.junit.Test

class ExceptionsGuideTest {
    @Test
    fun testExampleExceptions01() {
        test("ExampleExceptions01") { kotlinhax.shadowroutines.guide.exampleExceptions01.main() }.verifyExceptions(
            "Throwing exception from launch",
            "Exception in thread \"DefaultDispatcher-worker-1 @coroutine#2\" java.lang.IndexOutOfBoundsException",
            "Joined failed job",
            "Throwing exception from async",
            "Caught ArithmeticException"
        )
    }

    @Test
    fun testExampleExceptions02() {
        test("ExampleExceptions02") { kotlinhax.shadowroutines.guide.exampleExceptions02.main() }.verifyLines(
            "CoroutineExceptionHandler got java.lang.AssertionError"
        )
    }

    @Test
    fun testExampleExceptions03() {
        test("ExampleExceptions03") { kotlinhax.shadowroutines.guide.exampleExceptions03.main() }.verifyLines(
            "Cancelling child",
            "Child is cancelled",
            "Parent is not cancelled"
        )
    }

    @Test
    fun testExampleExceptions04() {
        test("ExampleExceptions04") { kotlinhax.shadowroutines.guide.exampleExceptions04.main() }.verifyLines(
            "Second child throws an exception",
            "Children are cancelled, but exception is not handled until all children terminate",
            "The first child finished its non cancellable block",
            "CoroutineExceptionHandler got java.lang.ArithmeticException"
        )
    }

    @Test
    fun testExampleExceptions05() {
        test("ExampleExceptions05") { kotlinhax.shadowroutines.guide.exampleExceptions05.main() }.verifyLines(
            "CoroutineExceptionHandler got java.io.IOException with suppressed [java.lang.ArithmeticException]"
        )
    }

    @Test
    fun testExampleExceptions06() {
        test("ExampleExceptions06") { kotlinhax.shadowroutines.guide.exampleExceptions06.main() }.verifyLines(
            "Rethrowing CancellationException with original cause",
            "CoroutineExceptionHandler got java.io.IOException"
        )
    }

    @Test
    fun testExampleSupervision01() {
        test("ExampleSupervision01") { kotlinhax.shadowroutines.guide.exampleSupervision01.main() }.verifyLines(
            "The first child is failing",
            "The first child is cancelled: true, but the second one is still active",
            "Cancelling the supervisor",
            "The second child is cancelled because the supervisor was cancelled"
        )
    }

    @Test
    fun testExampleSupervision02() {
        test("ExampleSupervision02") { kotlinhax.shadowroutines.guide.exampleSupervision02.main() }.verifyLines(
            "The child is sleeping",
            "Throwing an exception from the scope",
            "The child is cancelled",
            "Caught an assertion error"
        )
    }

    @Test
    fun testExampleSupervision03() {
        test("ExampleSupervision03") { kotlinhax.shadowroutines.guide.exampleSupervision03.main() }.verifyLines(
            "The scope is completing",
            "The child throws an exception",
            "CoroutineExceptionHandler got java.lang.AssertionError",
            "The scope is completed"
        )
    }
}
