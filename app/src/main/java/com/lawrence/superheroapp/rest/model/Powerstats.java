package com.lawrence.superheroapp.rest.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "intelligence",
        "strength",
        "speed",
        "durability",
        "power",
        "combat"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Powerstats implements Serializable {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("intelligence")
    private String intelligence;
    @JsonProperty("strength")
    private String strength;
    @JsonProperty("speed")
    private String speed;
    @JsonProperty("durability")
    private String durability;
    @JsonProperty("power")
    private String power;
    @JsonProperty("combat")
    private String combat;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("intelligence")
    public String getIntelligence() {
        return intelligence;
    }

    @JsonProperty("intelligence")
    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("strength")
    public String getStrength() {
        return strength;
    }

    @JsonProperty("strength")
    public void setStrength(String strength) {
        this.strength = strength;
    }

    @JsonProperty("speed")
    public String getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @JsonProperty("durability")
    public String getDurability() {
        return durability;
    }

    @JsonProperty("durability")
    public void setDurability(String durability) {
        this.durability = durability;
    }

    @JsonProperty("power")
    public String getPower() {
        return power;
    }

    @JsonProperty("power")
    public void setPower(String power) {
        this.power = power;
    }

    @JsonProperty("combat")
    public String getCombat() {
        return combat;
    }

    @JsonProperty("combat")
    public void setCombat(String combat) {
        this.combat = combat;
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
