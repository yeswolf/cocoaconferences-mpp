package me.user.shared

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.core.component.KoinComponent

interface IConferencesSource : KoinComponent {
    suspend fun getConferences(): String
}

fun fixRaw(result: String) = result.replace("|", "")
    .replace("{", "")
    .replace("}", "")
    .replace("http:", "https:")

class ConferencesSource : IConferencesSource, KoinComponent {
    private val url = "https://raw.githubusercontent.com/Lascorbe/CocoaConferences/master/_data/conferences.yml"
    override suspend fun getConferences(): String {
        val client = HttpClient()
        val address = Url(url)
        val result = client.get<String> {
            url(address.toString())
        }
        return fixRaw(result)
    }
}