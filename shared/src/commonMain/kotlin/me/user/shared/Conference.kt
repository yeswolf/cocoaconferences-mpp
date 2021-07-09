package me.user.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Link(
    val https: String?
) {
    val value: String?
        get() {
            return "https:$https"
        }
}

@Serializable
data class Cfp(
    val link: Link? = null,
    val deadline: String? = null
)

@Serializable
data class Conference(
    val name: String,
    val link: Link? = null,
    val location: String,
    val start: String,
    val end: String? = null,
    @SerialName("cocoa-only")
    val cocoaOnly: Boolean,
    val cfp: Cfp? = null
)