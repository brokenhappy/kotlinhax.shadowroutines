// This file was automatically generated from composing-suspending-functions.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.test

import kotlinhax.shadowroutines.knit.*
import org.junit.Test

class ComposingGuideTest {
    @Test
    fun testExampleCompose01() {
        test("ExampleCompose01") { kotlinhax.shadowroutines.guide.exampleCompose01.main() }.verifyLinesArbitraryTime(
            "The answer is 42",
            "Completed in 2017 ms"
        )
    }

    @Test
    fun testExampleCompose02() {
        test("ExampleCompose02") { kotlinhax.shadowroutines.guide.exampleCompose02.main() }.verifyLinesArbitraryTime(
            "The answer is 42",
            "Completed in 1017 ms"
        )
    }

    @Test
    fun testExampleCompose03() {
        test("ExampleCompose03") { kotlinhax.shadowroutines.guide.exampleCompose03.main() }.verifyLinesArbitraryTime(
            "The answer is 42",
            "Completed in 1017 ms"
        )
    }

    @Test
    fun testExampleCompose04() {
        test("ExampleCompose04") { kotlinhax.shadowroutines.guide.exampleCompose04.main() }.verifyLinesArbitraryTime(
            "The answer is 42",
            "Completed in 1085 ms"
        )
    }

    @Test
    fun testExampleCompose05() {
        test("ExampleCompose05") { kotlinhax.shadowroutines.guide.exampleCompose05.main() }.verifyLinesArbitraryTime(
            "The answer is 42",
            "Completed in 1017 ms"
        )
    }

    @Test
    fun testExampleCompose06() {
        test("ExampleCompose06") { kotlinhax.shadowroutines.guide.exampleCompose06.main() }.verifyLines(
            "Second child throws an exception",
            "First child was cancelled",
            "Computation failed with ArithmeticException"
        )
    }
}
