package me.user.shared

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(DelicateCoroutinesApi::class)
fun runBlocking(block: suspend () -> Unit) {
    CoroutineScope(Dispatchers.Main).launch { // can be other dispatcher
        block()
    }
}

class CommonTests : KoinTest {

    companion object {
        init {
            val testModule = module {
                single<IConferencesSource> { MockConferencesSource() }
                single<IConferencesRepository> { ConferencesRepository() }
                single { GetConferencesUseCase() }
            }
            startKoin {
                modules(testModule)
            }
        }
    }

    private val repo by inject<IConferencesRepository>()
    private val source by inject<IConferencesSource>()
    private val useCase by inject<GetConferencesUseCase>()

    @Test
    fun testConferencesSource() {
        var result: String
        runBlocking {
            result = source.getConferences()
            assertTrue(result.isNotEmpty())
        }
    }

    @Test
    fun testConferencesRepository() {
        var conferences: List<Conference>
        runBlocking {
            conferences = repo.getConferences()
            assertTrue(conferences.isNotEmpty())
        }
    }

    @Test
    fun testConferencesUseCase() {
        var conferences: List<Conference>
        runBlocking {
            conferences = useCase()
            assertTrue(conferences.isNotEmpty())
        }
    }
}