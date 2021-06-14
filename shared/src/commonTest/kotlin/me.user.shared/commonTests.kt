package me.user.shared

import kotlinx.coroutines.*
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
        val source = MockConferencesSource()
        val repo = ConferencesRepository(source)
        var conferences: List<Conference> = emptyList()
        runBlocking {
            conferences = repo.getConferences()
        }
        assertTrue(conferences.isNotEmpty())
    }

    @Test
    fun testConferencesUseCase() {
        val source = MockConferencesSource()
        val repo = ConferencesRepository(source)
        val useCase = GetConferencesUseCase(repo)
        var conferences: List<Conference> = emptyList()
        runBlocking {
            conferences = useCase()
        }
        assertTrue(conferences.isNotEmpty())
    }
}