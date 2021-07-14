package me.user.shared

import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.Test
import kotlin.test.assertTrue

class IosTests: KoinTest {
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
//        val source = MockConferencesSource()
        var result = ""
        runBlocking {
            result = source.getConferences()
        }
        assertTrue(result.isNotEmpty())
    }

    @Test
    fun testConferencesRepository() {
//        val repo = ConferencesRepository()
        var conferences: List<Conference> = emptyList()
        runBlocking {
            conferences = repo.getConferences()
        }
        assertTrue(conferences.isNotEmpty())
    }

    @Test
    fun testConferencesUseCase() {
//        val useCase = GetConferencesUseCase()
        var conferences: List<Conference> = emptyList()
        runBlocking {
            conferences = useCase()
        }
        assertTrue(conferences.isNotEmpty())
    }

}