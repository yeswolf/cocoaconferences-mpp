package me.user.shared

import kotlin.test.Test
import kotlin.test.assertTrue

class IosTests {

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