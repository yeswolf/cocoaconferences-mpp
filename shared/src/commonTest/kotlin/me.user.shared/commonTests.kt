package me.user.shared

import kotlinx.coroutines.*
import org.koin.core.context.startKoin
import org.koin.dsl.module
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(DelicateCoroutinesApi::class)
fun runBlocking(block: suspend () -> Unit) {
    GlobalScope.launch(Dispatchers.Unconfined) {
        withContext(Dispatchers.Unconfined) {
            block()
        }
    }
}

class CommonTests {
    companion object {
        init {
            val testModule = module {
                single <IConferencesSource> { MockConferencesSource() }
                single <IConferencesRepository> { ConferencesRepository() }
                single { GetConferencesUseCase() }
            }
            startKoin {
                modules(testModule)
            }
        }
    }
    @Test
    fun testConferencesSource() {
        val source = MockConferencesSource()
        var result = ""
        runBlocking {
            result = source.getConferences()
        }
        assertTrue(result.isNotEmpty())
    }

    @Test
    fun testConferencesRepository() {
        val repo = ConferencesRepository()
        var conferences: List<Conference> = emptyList()
        runBlocking {
            conferences = repo.getConferences()
        }
        assertTrue(conferences.isNotEmpty())
    }

    @Test
    fun testConferencesUseCase() {
        val useCase = GetConferencesUseCase()
        var conferences: List<Conference> = emptyList()
        runBlocking {
            conferences = useCase()
        }
        assertTrue(conferences.isNotEmpty())
    }
}