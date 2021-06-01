package me.user.shared

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

interface IConferencesSource {
    suspend fun getConferences(): String
}

class ConferencesSource : IConferencesSource {
    private val url = "https://raw.githubusercontent.com/Lascorbe/CocoaConferences/master/_data/conferences.yml"
    override suspend fun getConferences(): String {
        val client = HttpClient()
        val address = Url(url)
        val result = client.get<String> {
            url(address.toString())
        }
        return result.replace("|", "")
            .replace("{", "")
            .replace("}","")
    }
}