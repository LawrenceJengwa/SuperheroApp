package com.lawrence.superheroapp.rest.model

import com.fasterxml.jackson.annotation.*
import java.io.Serializable
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("id", "name", "intelligence", "strength", "speed", "durability", "power", "combat")
@JsonIgnoreProperties(ignoreUnknown = true)
class Powerstats : Serializable {
    @get:JsonProperty("id")
    @set:JsonProperty("id")
    @JsonProperty("id")
    var id: String? = null
    @get:JsonProperty("name")
    @set:JsonProperty("name")
    @JsonProperty("name")
    var name: String? = null
    @get:JsonProperty("intelligence")
    @set:JsonProperty("intelligence")
    @JsonProperty("intelligence")
    var intelligence: String? = null
    @get:JsonProperty("strength")
    @set:JsonProperty("strength")
    @JsonProperty("strength")
    var strength: String? = null
    @get:JsonProperty("speed")
    @set:JsonProperty("speed")
    @JsonProperty("speed")
    var speed: String? = null
    @get:JsonProperty("durability")
    @set:JsonProperty("durability")
    @JsonProperty("durability")
    var durability: String? = null
    @get:JsonProperty("power")
    @set:JsonProperty("power")
    @JsonProperty("power")
    var power: String? = null
    @get:JsonProperty("combat")
    @set:JsonProperty("combat")
    @JsonProperty("combat")
    var combat: String? = null
    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}