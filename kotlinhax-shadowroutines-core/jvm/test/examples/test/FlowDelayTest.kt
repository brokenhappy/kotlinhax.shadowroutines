// This file was automatically generated from Delay.kt by Knit tool. Do not edit.
package kotlinhax.shadowroutines.examples.test

import kotlinhax.shadowroutines.knit.*
import org.junit.Test

class FlowDelayTest {
    @Test
    fun testExampleDelay01() {
        test("ExampleDelay01") { kotlinhax.shadowroutines.examples.exampleDelay01.main() }.verifyLines(
            "3, 4, 5"
        )
    }

    @Test
    fun testExampleDelay02() {
        test("ExampleDelay02") { kotlinhax.shadowroutines.examples.exampleDelay02.main() }.verifyLines(
            "1, 3, 4, 5"
        )
    }

    @Test
    fun testExampleDelayDuration01() {
        test("ExampleDelayDuration01") { kotlinhax.shadowroutines.examples.exampleDelayDuration01.main() }.verifyLines(
            "3, 4, 5"
        )
    }

    @Test
    fun testExampleDelayDuration02() {
        test("ExampleDelayDuration02") { kotlinhax.shadowroutines.examples.exampleDelayDuration02.main() }.verifyLines(
            "1, 3, 4, 5"
        )
    }

    @Test
    fun testExampleDelay03() {
        test("ExampleDelay03") { kotlinhax.shadowroutines.examples.exampleDelay03.main() }.verifyLines(
            "1, 3, 5, 7, 9"
        )
    }

    @Test
    fun testExampleDelayDuration03() {
        test("ExampleDelayDuration03") { kotlinhax.shadowroutines.examples.exampleDelayDuration03.main() }.verifyLines(
            "1, 3, 5, 7, 9"
        )
    }

    @Test
    fun testExampleTimeoutDuration01() {
        test("ExampleTimeoutDuration01") { kotlinhax.shadowroutines.examples.exampleTimeoutDuration01.main() }.verifyLines(
            "1, 2, 3, -1"
        )
    }
}
