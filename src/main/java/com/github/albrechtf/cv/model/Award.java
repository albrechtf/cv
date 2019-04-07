
package com.github.albrechtf.cv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "date",
    "awarder",
    "summary"
})
public class Award {

    /**
     * e.g. One of the 100 greatest minds of the century
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("e.g. One of the 100 greatest minds of the century")
    private String title;
    /**
     * e.g. 1989-06-12
     * 
     */
    @JsonProperty("date")
    @JsonPropertyDescription("e.g. 1989-06-12")
    private String date;
    /**
     * e.g. Time Magazine
     * 
     */
    @JsonProperty("awarder")
    @JsonPropertyDescription("e.g. Time Magazine")
    private String awarder;
    /**
     * e.g. Received for my work with Quantum Physics
     * 
     */
    @JsonProperty("summary")
    @JsonPropertyDescription("e.g. Received for my work with Quantum Physics")
    private String summary;

    /**
     * e.g. One of the 100 greatest minds of the century
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * e.g. One of the 100 greatest minds of the century
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * e.g. 1989-06-12
     * 
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * e.g. 1989-06-12
     * 
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * e.g. Time Magazine
     * 
     */
    @JsonProperty("awarder")
    public String getAwarder() {
        return awarder;
    }

    /**
     * e.g. Time Magazine
     * 
     */
    @JsonProperty("awarder")
    public void setAwarder(String awarder) {
        this.awarder = awarder;
    }

    /**
     * e.g. Received for my work with Quantum Physics
     * 
     */
    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    /**
     * e.g. Received for my work with Quantum Physics
     * 
     */
    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

}
