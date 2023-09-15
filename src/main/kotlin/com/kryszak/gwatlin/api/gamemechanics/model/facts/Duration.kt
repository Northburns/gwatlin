package com.kryszak.gwatlin.api.gamemechanics.model.facts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data model for skill/trait facts with type Duration
 */
@Serializable
@SerialName("Duration")
data class Duration(
    override val type: String,
    override val text: String? = null,
    override val icon: String? = null,
    val duration: Float
) : Fact
