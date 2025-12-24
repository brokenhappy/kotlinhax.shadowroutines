@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
package kotlinhax.shadowroutines.debug

import kotlinhax.shadowroutines.testing.*
import com.google.gson.*
import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.debug.internal.*
import org.junit.Test
import kotlin.test.*

class EnhanceStackTraceWithTreadDumpAsJsonTest : DebugTestBase() {
    private data class StackTraceElementInfoFromJson(
        val declaringClass: String,
        val methodName: String,
        val fileName: String?,
        val lineNumber: Int
    )

    @Test
    fun testEnhancedStackTraceFormatWithDeferred() = runTest {
        val deferred = async {
            suspendingMethod()
            assertTrue(true)
        }
        yield()

        val coroutineInfo = DebugProbesImpl.dumpCoroutinesInfo()
        assertEquals(coroutineInfo.size, 2)
        val info = coroutineInfo[1]
        val enhancedStackTraceAsJsonString = DebugProbesImpl.enhanceStackTraceWithThreadDumpAsJson(info)
        val enhancedStackTraceFromJson = Gson().fromJson(enhancedStackTraceAsJsonString, Array<StackTraceElementInfoFromJson>::class.java)
        val enhancedStackTrace = DebugProbesImpl.enhanceStackTraceWithThreadDump(info, info.lastObservedStackTrace)
        assertEquals(enhancedStackTrace.size, enhancedStackTraceFromJson.size)
        for ((frame, frameFromJson) in enhancedStackTrace.zip(enhancedStackTraceFromJson)) {
            assertEquals(frame.className, frameFromJson.declaringClass)
            assertEquals(frame.methodName, frameFromJson.methodName)
            assertEquals(frame.fileName, frameFromJson.fileName)
            assertEquals(frame.lineNumber, frameFromJson.lineNumber)
        }

        deferred.cancelAndJoin()
    }

    private suspend fun suspendingMethod() {
        delay(Long.MAX_VALUE)
    }
}
