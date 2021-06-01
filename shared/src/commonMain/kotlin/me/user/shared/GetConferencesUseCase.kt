package me.user.shared

class GetConferencesUseCase(
    private val conferencesRepository: IConferencesRepository
) {
    suspend operator fun invoke(): List<Conference> {
        return conferencesRepository.getConferences()
    }
}