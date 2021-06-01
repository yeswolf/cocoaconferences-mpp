package me.user.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cfp(
//    val link: String? = null,
    val deadline: String? = null
)

@Serializable
data class Conference(
    val name: String,
//    val link: String? = null,
    val location: String,
    val start: String,
    val end: String? = null,
    @SerialName("cocoa-only")
    val cocoaOnly: Boolean,
    val cfp: Cfp? = null
)