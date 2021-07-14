package me.user.shared

import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject

class AndroidTests : KoinTest {
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
    private val repo by inject<IConferencesRepository> ()
    private val source by inject<IConferencesSource> ()
    private val useCase by inject<GetConferencesUseCase>()

    @Test
    fun testConferencesSource() {
        var result = ""
        runBlocking {
            result = source.getConferences()
        }
        kotlin.test.assertTrue(result.isNotEmpty())
    }

    @Test
    fun testConferencesRepository() {
        var conferences: List<Conference> = emptyList()
        runBlocking {
            conferences = repo.getConferences()
        }
        kotlin.test.assertTrue(conferences.isNotEmpty())
    }

    @Test
    fun testConferencesUseCase() {
        var conferences: List<Conference> = emptyList()
        runBlocking {
            conferences = useCase()
        }
        kotlin.test.assertTrue(conferences.isNotEmpty())
    }
}