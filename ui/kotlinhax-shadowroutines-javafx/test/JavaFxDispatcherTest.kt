package kotlinhax.shadowroutines.javafx

import kotlinhax.shadowroutines.testing.*
import javafx.application.*
import kotlinhax.shadowroutines.*
import org.junit.*
import org.junit.Test
import kotlin.test.*

class JavaFxDispatcherTest : MainDispatcherTestBase.WithRealTimeDelay() {
    @Before
    fun setup() {
        ignoreLostThreads("JavaFX Application Thread", "Thread-", "QuantumRenderer-", "InvokeLaterDispatcher")
    }

    override fun shouldSkipTesting(): Boolean {
        if (!initPlatform()) {
            println("Skipping JavaFxTest in headless environment")
            return true // ignore test in headless environments
        }
        return false
    }

    override fun isMainThread() = Platform.isFxApplicationThread()

    override fun scheduleOnMainQueue(block: () -> Unit) {
        Platform.runLater { block() }
    }

    /** Tests that the Main dispatcher is in fact the JavaFx one. */
    @Test
    fun testMainIsJavaFx() {
        assertSame(Dispatchers.JavaFx, Dispatchers.Main)
    }

}
