package io.github.kryszak.gwatlin.api.gamemechanics.model.facts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data model for skill/trait facts with type ComboFinisher
 */
@Serializable
@SerialName("ComboFinisher")
data class ComboFinisher(
    override val type: String,
    override val text: String? = null,
    override val icon: String? = null,
    val percent: Float,
    @SerialName("finisher_type")
    val finisherType: ComboFinisherType
) : Fact
