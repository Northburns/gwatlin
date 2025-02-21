package io.github.kryszak.gwatlin.api.gamemechanics.model.facts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data model for skill/trait facts with type Damage
 */
@Serializable
@SerialName("Damage")
data class Damage(
    override val type: String,
    override val text: String? = null,
    override val icon: String? = null,
    @SerialName("hit_count")
    val hitCount: Int,
    @SerialName("dmg_multiplier")
    val finisherType: Float? = null
) : Fact
