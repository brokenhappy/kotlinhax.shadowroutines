// This file was automatically generated from channels.md by Knit tool. Do not edit.
package kotlinhax.shadowroutines.guide.test

import kotlinhax.shadowroutines.knit.*
import org.junit.Test

class ChannelsGuideTest {
    @Test
    fun testExampleChannel01() {
        test("ExampleChannel01") { kotlinhax.shadowroutines.guide.exampleChannel01.main() }.verifyLines(
            "1",
            "4",
            "9",
            "16",
            "25",
            "Done!"
        )
    }

    @Test
    fun testExampleChannel02() {
        test("ExampleChannel02") { kotlinhax.shadowroutines.guide.exampleChannel02.main() }.verifyLines(
            "1",
            "4",
            "9",
            "16",
            "25",
            "Done!"
        )
    }

    @Test
    fun testExampleChannel03() {
        test("ExampleChannel03") { kotlinhax.shadowroutines.guide.exampleChannel03.main() }.verifyLines(
            "1",
            "4",
            "9",
            "16",
            "25",
            "Done!"
        )
    }

    @Test
    fun testExampleChannel04() {
        test("ExampleChannel04") { kotlinhax.shadowroutines.guide.exampleChannel04.main() }.verifyLines(
            "1",
            "4",
            "9",
            "16",
            "25",
            "Done!"
        )
    }

    @Test
    fun testExampleChannel05() {
        test("ExampleChannel05") { kotlinhax.shadowroutines.guide.exampleChannel05.main() }.verifyLines(
            "2",
            "3",
            "5",
            "7",
            "11",
            "13",
            "17",
            "19",
            "23",
            "29"
        )
    }

    @Test
    fun testExampleChannel06() {
        test("ExampleChannel06") { kotlinhax.shadowroutines.guide.exampleChannel06.main() }.also { lines ->
            check(lines.size == 10 && lines.withIndex().all { (i, line) -> line.startsWith("Processor #") && line.endsWith(" received ${i + 1}") })
        }
    }

    @Test
    fun testExampleChannel07() {
        test("ExampleChannel07") { kotlinhax.shadowroutines.guide.exampleChannel07.main() }.verifyLines(
            "foo",
            "foo",
            "BAR!",
            "foo",
            "foo",
            "BAR!"
        )
    }

    @Test
    fun testExampleChannel08() {
        test("ExampleChannel08") { kotlinhax.shadowroutines.guide.exampleChannel08.main() }.verifyLines(
            "Sending 0",
            "Sending 1",
            "Sending 2",
            "Sending 3",
            "Sending 4"
        )
    }

    @Test
    fun testExampleChannel09() {
        test("ExampleChannel09") { kotlinhax.shadowroutines.guide.exampleChannel09.main() }.verifyLines(
            "ping Ball(hits=1)",
            "pong Ball(hits=2)",
            "ping Ball(hits=3)",
            "pong Ball(hits=4)"
        )
    }

    @Test
    fun testExampleChannel10() {
        test("ExampleChannel10") { kotlinhax.shadowroutines.guide.exampleChannel10.main() }.verifyLines(
            "Initial element is available immediately: kotlin.Unit",
            "Next element is not ready in 100 ms: null",
            "Next element is ready in 200 ms: kotlin.Unit",
            "Consumer pauses for 300ms",
            "Next element is available immediately after large consumer delay: kotlin.Unit",
            "Next element is ready in 100ms after consumer pause in 300ms: kotlin.Unit"
        )
    }
}
