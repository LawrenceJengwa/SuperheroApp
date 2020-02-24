package com.lawrence.superheroapp.rest.model

import com.fasterxml.jackson.annotation.*
import java.io.Serializable
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("name", "group-affiliation", "relatives")
class Connections : Serializable {
    @JsonProperty("name")
    var name: String? = null
    @get:JsonProperty("group-affiliation")
    @set:JsonProperty("group-affiliation")
    @JsonProperty("group-affiliation")
    var groupAffiliation: String? = null
    @get:JsonProperty("relatives")
    @set:JsonProperty("relatives")
    @JsonProperty("relatives")
    var relatives: String? = null
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