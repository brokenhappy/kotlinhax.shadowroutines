package kotlinhax.shadowroutines

import com.google.common.reflect.*
import kotlinhax.shadowroutines.*
import org.junit.Test
import java.io.Serializable
import java.lang.reflect.Modifier
import kotlin.test.*

class ListAllCoroutineThrowableSubclassesTest {

    /*
     * These are all the known throwables in kotlinhax.shadowroutines.
     * If you add one, this test will fail to make
     * you ensure your exception type is java.io.Serializable.
     *
     * We do not have means to check it automatically, so checks are delegated to humans.
     *
     * See #3328 for serialization rationale.
     */
    private val knownThrowables = setOf(
        "kotlinhax.shadowroutines.TimeoutCancellationException",
        "kotlinhax.shadowroutines.JobCancellationException",
        "kotlinhax.shadowroutines.internal.UndeliveredElementException",
        "kotlinhax.shadowroutines.CompletionHandlerException",
        "kotlinhax.shadowroutines.internal.DiagnosticCoroutineContextException",
        "kotlinhax.shadowroutines.internal.ExceptionSuccessfullyProcessed",
        "kotlinhax.shadowroutines.CoroutinesInternalError",
        "kotlinhax.shadowroutines.DispatchException",
        "kotlinhax.shadowroutines.channels.ClosedSendChannelException",
        "kotlinhax.shadowroutines.channels.ClosedReceiveChannelException",
        "kotlinhax.shadowroutines.flow.internal.ChildCancelledException",
        "kotlinhax.shadowroutines.flow.internal.AbortFlowException",
        "kotlinhax.shadowroutines.debug.junit5.CoroutinesTimeoutException",
    )

    @Test
    fun testThrowableSubclassesAreSerializable() {
        val classes = ClassPath.from(this.javaClass.classLoader)
            .getTopLevelClassesRecursive("kotlinhax.shadowroutines")
            // Not in the classpath: requires explicit dependency
            .filter { it.name != "kotlinhax.shadowroutines.debug.CoroutinesBlockHoundIntegration"
                    && it.name != "kotlinhax.shadowroutines.debug.junit5.CoroutinesTimeoutExtension" };
        val throwables = classes.filter { Throwable::class.java.isAssignableFrom(it.load()) }.map { it.toString() }
        for (throwable in throwables) {
            for (field in throwable.javaClass.declaredFields) {
                if (Modifier.isStatic(field.modifiers)) continue
                val type = field.type
                assertTrue(type.isPrimitive || Serializable::class.java.isAssignableFrom(type),
                    "Throwable $throwable has non-serializable field $field")
            }
        }
        assertEquals(knownThrowables.sorted(), throwables.sorted())
    }
}
