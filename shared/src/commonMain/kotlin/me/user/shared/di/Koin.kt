package me.user.shared.di

import me.user.shared.*
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(mainModule)
}

// called by iOS etc
fun initKoin() = initKoin{}

val mainModule = module {
    single <IConferencesSource> { ConferencesSource() }
    single <IConferencesRepository> { ConferencesRepository() }
    single { GetConferencesUseCase() }
}

