package io.github.kryszak.gwatlin.api.gamemechanics.model.facts

import kotlinx.serialization.Serializable

/**
 * Data model for buff prefix object
 */
@Serializable
data class BuffPrefix(
    val test: String,
    val icon: String,
    val status: String,
    val description: String
)
