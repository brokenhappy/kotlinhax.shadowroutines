package kotlinhax.shadowroutines.internal

import kotlinhax.shadowroutines.testing.*
import kotlinhax.shadowroutines.*
import kotlin.test.*

class FastServiceLoaderTest : TestBase() {
    @Test
    fun testCrossModuleService() {
        val providers = CoroutineScope::class.java.let { FastServiceLoader.loadProviders(it, it.classLoader) }
        assertEquals(3, providers.size)
        val className = "kotlinhax.shadowroutines.android.EmptyCoroutineScopeImpl"
        for (i in 1 .. 3) {
            assert(providers[i - 1].javaClass.name == "$className$i")
        }
    }
}
