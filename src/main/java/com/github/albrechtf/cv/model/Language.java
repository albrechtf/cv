
package com.github.albrechtf.cv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "language",
    "fluency"
})
public class Language {

    /**
     * e.g. English, Spanish
     * 
     */
    @JsonProperty("language")
    @JsonPropertyDescription("e.g. English, Spanish")
    private String language;
    /**
     * e.g. Fluent, Beginner
     * 
     */
    @JsonProperty("fluency")
    @JsonPropertyDescription("e.g. Fluent, Beginner")
    private String fluency;

    /**
     * e.g. English, Spanish
     * 
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * e.g. English, Spanish
     * 
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * e.g. Fluent, Beginner
     * 
     */
    @JsonProperty("fluency")
    public String getFluency() {
        return fluency;
    }

    /**
     * e.g. Fluent, Beginner
     * 
     */
    @JsonProperty("fluency")
    public void setFluency(String fluency) {
        this.fluency = fluency;
    }

}
