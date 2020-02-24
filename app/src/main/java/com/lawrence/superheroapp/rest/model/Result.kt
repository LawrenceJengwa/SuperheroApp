package com.lawrence.superheroapp.rest.model

import com.fasterxml.jackson.annotation.*
import java.io.Serializable
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("id", "name", "powerstats", "biography", "appearance", "work", "connections", "image")
class Result : Serializable {
    @get:JsonProperty("id")
    @set:JsonProperty("id")
    @JsonProperty("id")
    var id: String? = null
    @get:JsonProperty("name")
    @set:JsonProperty("name")
    @JsonProperty("name")
    var name: String? = null
    @get:JsonProperty("powerstats")
    @set:JsonProperty("powerstats")
    @JsonProperty("powerstats")
    var powerstats: Powerstats? = null
    @get:JsonProperty("biography")
    @set:JsonProperty("biography")
    @JsonProperty("biography")
    var biography: Biography? = null
    @get:JsonProperty("appearance")
    @set:JsonProperty("appearance")
    @JsonProperty("appearance")
    var appearance: Appearance? = null
    @get:JsonProperty("work")
    @set:JsonProperty("work")
    @JsonProperty("work")
    var work: Work? = null
    @get:JsonProperty("connections")
    @set:JsonProperty("connections")
    @JsonProperty("connections")
    var connections: Connections? = null
    @get:JsonProperty("image")
    @set:JsonProperty("image")
    @JsonProperty("image")
    var image: Image? = null
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