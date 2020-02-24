package com.lawrence.superheroapp.rest.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "group-affiliation",
        "relatives"
})
public class Connections implements Serializable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("group-affiliation")
    private String groupAffiliation;
    @JsonProperty("relatives")
    private String relatives;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("group-affiliation")
    public String getGroupAffiliation() {
        return groupAffiliation;
    }

    @JsonProperty("group-affiliation")
    public void setGroupAffiliation(String groupAffiliation) {
        this.groupAffiliation = groupAffiliation;
    }

    @JsonProperty("relatives")
    public String getRelatives() {
        return relatives;
    }

    @JsonProperty("relatives")
    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}