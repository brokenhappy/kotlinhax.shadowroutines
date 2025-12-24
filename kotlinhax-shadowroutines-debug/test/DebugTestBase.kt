package kotlinhax.shadowroutines.debug


import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlinhax.shadowroutines.debug.junit4.*
import org.junit.*

open class DebugTestBase : TestBase() {

    @JvmField
    @Rule
    val timeout = CoroutinesTimeout.seconds(60)

    @Before
    open fun setUp() {
        DebugProbes.sanitizeStackTraces = false
        DebugProbes.enableCreationStackTraces = false
        DebugProbes.install()
    }

    @After
    fun tearDown() {
        DebugProbes.uninstall()
    }
}
