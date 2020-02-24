package com.lawrence.superheroapp.rest.model

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("gender", "race", "height", "weight", "eye-color", "hair-color")
class Appearance {
    @get:JsonProperty("gender")
    @set:JsonProperty("gender")
    @JsonProperty("gender")
    var gender: String? = null
    @get:JsonProperty("race")
    @set:JsonProperty("race")
    @JsonProperty("race")
    var race: String? = null
    @get:JsonProperty("height")
    @set:JsonProperty("height")
    @JsonProperty("height")
    var height: List<String>? = null
    @get:JsonProperty("weight")
    @set:JsonProperty("weight")
    @JsonProperty("weight")
    var weight: List<String>? = null
    @get:JsonProperty("eye-color")
    @set:JsonProperty("eye-color")
    @JsonProperty("eye-color")
    var eyeColor: String? = null
    @get:JsonProperty("hair-color")
    @set:JsonProperty("hair-color")
    @JsonProperty("hair-color")
    var hairColor: String? = null
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