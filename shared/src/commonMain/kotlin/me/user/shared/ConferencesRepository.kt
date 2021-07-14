package me.user.shared

import kotlinx.serialization.builtins.ListSerializer
import net.mamoe.yamlkt.Yaml
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface IConferencesRepository {
    suspend fun getConferences(): List<Conference>
}

class ConferencesRepository : IConferencesRepository, KoinComponent {
    private val source by inject<IConferencesSource>()
    override suspend fun getConferences(): List<Conference> {
        return Yaml.decodeFromString(
            ListSerializer(elementSerializer = Conference.serializer()),
            source.getConferences()
        )
    }
}