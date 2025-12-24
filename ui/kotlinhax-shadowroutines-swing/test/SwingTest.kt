package kotlinhax.shadowroutines.swing

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import org.junit.*
import org.junit.Test
import javax.swing.*
import kotlin.test.*

class SwingTest : MainDispatcherTestBase.WithRealTimeDelay() {
    @Before
    fun setup() {
        ignoreLostThreads("AWT-EventQueue-")
    }

    override fun isMainThread() = SwingUtilities.isEventDispatchThread()

    override fun scheduleOnMainQueue(block: () -> Unit) {
        SwingUtilities.invokeLater { block() }
    }

    /** Tests that the Main dispatcher is in fact the JavaFx one. */
    @Test
    fun testMainIsJavaFx() {
        assertSame(Dispatchers.Swing, Dispatchers.Main)
    }
}
