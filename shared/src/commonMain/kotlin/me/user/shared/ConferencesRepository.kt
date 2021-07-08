package me.user.shared

import kotlinx.serialization.builtins.ListSerializer
import net.mamoe.yamlkt.Yaml

interface IConferencesRepository {
    suspend fun getConferences() : List<Conference>
}

class ConferencesRepository (val source: IConferencesSource) : IConferencesRepository {
    override suspend fun getConferences(): List<Conference> {
        return Yaml.decodeFromString(
            ListSerializer(elementSerializer = Conference.serializer()),
            source.getConferences()
        )
    }
}