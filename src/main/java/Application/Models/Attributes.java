package Application.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attributes {
    private String description;

    @JsonProperty("canonicalTitle")
    private String name;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
