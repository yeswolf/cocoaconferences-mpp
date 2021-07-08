package me.user.shared

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidTests {
    @Test
    fun testConferencesSource() {
        val source = MockConferencesSource()
        var result = ""
        runBlocking {
            result = source.getConferences()
        }
        kotlin.test.assertTrue(result.isNotEmpty())
    }

    @Test
    fun testConferencesRepository() {
        val source = MockConferencesSource()
        val repo = ConferencesRepository(source)
        var conferences: List<Conference> = emptyList()
        runBlocking {
            conferences = repo.getConferences()
        }
        kotlin.test.assertTrue(conferences.isNotEmpty())
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
        kotlin.test.assertTrue(conferences.isNotEmpty())
    }
}