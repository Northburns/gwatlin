package io.github.kryszak.gwatlin.api.guild.model.log

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data model for guild log objects with type "stash"
 */
@Serializable
@SerialName("stash")
data class GuildLogStash(
    override val id: Int,
    override val time: String,
    override val user: String? = null,
    override val type: String,
    val operation: StashOperation,
    @SerialName("item_id")
    val itemId: Int,
    val count: Int,
    val coins: Int
) : GuildLog
