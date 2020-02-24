package com.lawrence.superheroapp.rest.model

import com.fasterxml.jackson.annotation.*
import java.io.Serializable
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("occupation", "base")
class Work : Serializable {
    @get:JsonProperty("occupation")
    @set:JsonProperty("occupation")
    @JsonProperty("occupation")
    var occupation: String? = null
    @get:JsonProperty("base")
    @set:JsonProperty("base")
    @JsonProperty("base")
    var base: String? = null
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