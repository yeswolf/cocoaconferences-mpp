package me.user.shared

import me.user.shared.mocks.MockConferencesSource
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertTrue

class AndroidTests : KoinTest {
    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @BeforeTest
    fun setup() {
        val testModule = module {
            single<IConferencesSource> { MockConferencesSource() }
            single<IConferencesRepository> { ConferencesRepository() }
            single { GetConferencesUseCase() }
        }
        startKoin {
            modules(testModule)
        }
    }

    private val repo by inject<IConferencesRepository>()
    private val source by inject<IConferencesSource>()
    private val useCase by inject<GetConferencesUseCase>()

    @Test
    fun testConferencesSource() {
        var result = ""
        runBlocking {
            result = source.getConferences()
        }
        assertTrue(result.isNotEmpty())
    }

    @Test
    fun testConferencesRepository() {
        var conferences: List<Conference> = listOf()
        runBlocking {
            conferences = repo.getConferences()
        }
        assertTrue(conferences.isNotEmpty())
    }

    @Test
    fun testConferencesUseCase() {
        var conferences: List<Conference> = listOf()
        runBlocking {
            conferences = useCase()
        }
        assertTrue(conferences.isNotEmpty())
    }
}