// This file was automatically generated from shared-mutable-state-and-concurrency.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.test

import kotlinhax.shadowroutines.knit.*
import org.junit.Test

class SharedStateGuideTest {
    @Test
    fun testExampleSync01() {
        test("ExampleSync01") { kotlinhax.shadowroutines.guide.exampleSync01.main() }.verifyLinesStart(
            "Completed 100000 actions in",
            "Counter ="
        )
    }

    @Test
    fun testExampleSync02() {
        test("ExampleSync02") { kotlinhax.shadowroutines.guide.exampleSync02.main() }.verifyLinesStart(
            "Completed 100000 actions in",
            "Counter ="
        )
    }

    @Test
    fun testExampleSync03() {
        test("ExampleSync03") { kotlinhax.shadowroutines.guide.exampleSync03.main() }.verifyLinesArbitraryTime(
            "Completed 100000 actions in xxx ms",
            "Counter = 100000"
        )
    }

    @Test
    fun testExampleSync04() {
        test("ExampleSync04") { kotlinhax.shadowroutines.guide.exampleSync04.main() }.verifyLinesArbitraryTime(
            "Completed 100000 actions in xxx ms",
            "Counter = 100000"
        )
    }

    @Test
    fun testExampleSync05() {
        test("ExampleSync05") { kotlinhax.shadowroutines.guide.exampleSync05.main() }.verifyLinesArbitraryTime(
            "Completed 100000 actions in xxx ms",
            "Counter = 100000"
        )
    }

    @Test
    fun testExampleSync06() {
        test("ExampleSync06") { kotlinhax.shadowroutines.guide.exampleSync06.main() }.verifyLinesArbitraryTime(
            "Completed 100000 actions in xxx ms",
            "Counter = 100000"
        )
    }
}
