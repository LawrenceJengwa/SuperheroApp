package com.lawrence.superheroapp.rest.model

import com.fasterxml.jackson.annotation.*
import java.io.Serializable
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("id", "full-name", "alter-egos", "aliases", "place-of-birth", "first-appearance", "publisher", "alignment")
@JsonIgnoreProperties(ignoreUnknown = true)
class Biography : Serializable {
    @get:JsonProperty("id")
    @set:JsonProperty("id")
    @JsonProperty("id")
    var id: String? = null
    @get:JsonProperty("full-name")
    @set:JsonProperty("full-name")
    @JsonProperty("full-name")
    var fullName: String? = null
    @get:JsonProperty("alter-egos")
    @set:JsonProperty("alter-egos")
    @JsonProperty("alter-egos")
    var alterEgos: String? = null
    @get:JsonProperty("aliases")
    @set:JsonProperty("aliases")
    @JsonProperty("aliases")
    var aliases: List<String>? = null
    @get:JsonProperty("place-of-birth")
    @set:JsonProperty("place-of-birth")
    @JsonProperty("place-of-birth")
    var placeOfBirth: String? = null
    @get:JsonProperty("first-appearance")
    @set:JsonProperty("first-appearance")
    @JsonProperty("first-appearance")
    var firstAppearance: String? = null
    @get:JsonProperty("publisher")
    @set:JsonProperty("publisher")
    @JsonProperty("publisher")
    var publisher: String? = null
    @get:JsonProperty("alignment")
    @set:JsonProperty("alignment")
    @JsonProperty("alignment")
    var alignment: String? = null
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