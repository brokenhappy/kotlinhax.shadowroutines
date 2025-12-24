// This file was automatically generated from cancellation-and-timeouts.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.test

import kotlinhax.shadowroutines.knit.*
import org.junit.Test

class CancellationGuideTest {
    @Test
    fun testExampleCancel01() {
        test("ExampleCancel01") { kotlinhax.shadowroutines.guide.exampleCancel01.main() }.verifyLines(
            "job: I'm sleeping 0 ...",
            "job: I'm sleeping 1 ...",
            "job: I'm sleeping 2 ...",
            "main: I'm tired of waiting!",
            "main: Now I can quit."
        )
    }

    @Test
    fun testExampleCancel02() {
        test("ExampleCancel02") { kotlinhax.shadowroutines.guide.exampleCancel02.main() }.verifyLines(
            "job: I'm sleeping 0 ...",
            "job: I'm sleeping 1 ...",
            "job: I'm sleeping 2 ...",
            "main: I'm tired of waiting!",
            "job: I'm sleeping 3 ...",
            "job: I'm sleeping 4 ...",
            "main: Now I can quit."
        )
    }

    @Test
    fun testExampleCancel04() {
        test("ExampleCancel04") { kotlinhax.shadowroutines.guide.exampleCancel04.main() }.verifyLines(
            "job: I'm sleeping 0 ...",
            "job: I'm sleeping 1 ...",
            "job: I'm sleeping 2 ...",
            "main: I'm tired of waiting!",
            "main: Now I can quit."
        )
    }

    @Test
    fun testExampleCancel05() {
        test("ExampleCancel05") { kotlinhax.shadowroutines.guide.exampleCancel05.main() }.verifyLines(
            "job: I'm sleeping 0 ...",
            "job: I'm sleeping 1 ...",
            "job: I'm sleeping 2 ...",
            "main: I'm tired of waiting!",
            "job: I'm running finally",
            "main: Now I can quit."
        )
    }

    @Test
    fun testExampleCancel06() {
        test("ExampleCancel06") { kotlinhax.shadowroutines.guide.exampleCancel06.main() }.verifyLines(
            "job: I'm sleeping 0 ...",
            "job: I'm sleeping 1 ...",
            "job: I'm sleeping 2 ...",
            "main: I'm tired of waiting!",
            "job: I'm running finally",
            "job: And I've just delayed for 1 sec because I'm non-cancellable",
            "main: Now I can quit."
        )
    }

    @Test
    fun testExampleCancel07() {
        test("ExampleCancel07") { kotlinhax.shadowroutines.guide.exampleCancel07.main() }.verifyLinesStartWith(
            "I'm sleeping 0 ...",
            "I'm sleeping 1 ...",
            "I'm sleeping 2 ...",
            "Exception in thread \"main\" kotlinhax.shadowroutines.TimeoutCancellationException: Timed out waiting for 1300 ms"
        )
    }

    @Test
    fun testExampleCancel08() {
        test("ExampleCancel08") { kotlinhax.shadowroutines.guide.exampleCancel08.main() }.verifyLines(
            "I'm sleeping 0 ...",
            "I'm sleeping 1 ...",
            "I'm sleeping 2 ...",
            "Result is null"
        )
    }

    @Test
    fun testExampleCancel10() {
        test("ExampleCancel10") { kotlinhax.shadowroutines.guide.exampleCancel10.main() }.verifyLines(
            "0"
        )
    }
}
