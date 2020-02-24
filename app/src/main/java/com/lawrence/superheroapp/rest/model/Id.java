package com.lawrence.superheroapp.rest.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "response",
        "id",
        "name",
        "powerstats",
        "biography",
        "appearance",
        "work",
        "connections",
        "image"
})
public class Id implements Serializable {

    @JsonProperty("response")
    private String response;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("powerstats")
    private Powerstats powerstats;
    @JsonProperty("biography")
    private Biography biography;
    @JsonProperty("appearance")
    private Appearance appearance;
    @JsonProperty("work")
    private Work work;
    @JsonProperty("connections")
    private Connections connections;
    @JsonProperty("image")
    private Image image;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(String response) {
        this.response = response;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("powerstats")
    public Powerstats getPowerstats() {
        return powerstats;
    }

    @JsonProperty("powerstats")
    public void setPowerstats(Powerstats powerstats) {
        this.powerstats = powerstats;
    }

    @JsonProperty("biography")
    public Biography getBiography() {
        return biography;
    }

    @JsonProperty("biography")
    public void setBiography(Biography biography) {
        this.biography = biography;
    }

    @JsonProperty("appearance")
    public Appearance getAppearance() {
        return appearance;
    }

    @JsonProperty("appearance")
    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    @JsonProperty("work")
    public Work getWork() {
        return work;
    }

    @JsonProperty("work")
    public void setWork(Work work) {
        this.work = work;
    }

    @JsonProperty("connections")
    public Connections getConnections() {
        return connections;
    }

    @JsonProperty("connections")
    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
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

