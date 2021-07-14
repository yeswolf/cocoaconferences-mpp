package me.user.shared

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetConferencesUseCase : KoinComponent {
    private val conferencesRepository by inject<IConferencesRepository>()
    suspend operator fun invoke(): List<Conference> {
        return conferencesRepository.getConferences()
    }
}