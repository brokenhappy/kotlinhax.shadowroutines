// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.test

import kotlinhax.shadowroutines.knit.*
import org.junit.Test

class BasicsGuideTest {
    @Test
    fun testExampleBasic01() {
        test("ExampleBasic01") { kotlinhax.shadowroutines.guide.exampleBasic01.main() }.verifyLines(
            "Hello",
            "World!"
        )
    }

    @Test
    fun testExampleBasic02() {
        test("ExampleBasic02") { kotlinhax.shadowroutines.guide.exampleBasic02.main() }.verifyLines(
            "Hello",
            "World!"
        )
    }

    @Test
    fun testExampleBasic03() {
        test("ExampleBasic03") { kotlinhax.shadowroutines.guide.exampleBasic03.main() }.verifyLines(
            "Hello",
            "World!"
        )
    }

    @Test
    fun testExampleBasic04() {
        test("ExampleBasic04") { kotlinhax.shadowroutines.guide.exampleBasic04.main() }.verifyLines(
            "Hello",
            "World 1",
            "World 2",
            "Done"
        )
    }

    @Test
    fun testExampleBasic05() {
        test("ExampleBasic05") { kotlinhax.shadowroutines.guide.exampleBasic05.main() }.verifyLines(
            "Hello",
            "World!",
            "Done"
        )
    }

    @Test
    fun testExampleBasic06() {
        test("ExampleBasic06") { kotlinhax.shadowroutines.guide.exampleBasic06.main() }.also { lines ->
            check(lines.size == 1 && lines[0] == ".".repeat(50_000))
        }
    }
}
