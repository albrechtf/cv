
package com.github.albrechtf.cv.model;

import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "organization",
    "position",
    "url",
    "startDate",
    "endDate",
    "summary",
    "highlights"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Volunteer {

    /**
     * e.g. Facebook
     * 
     */
    @JsonProperty("organization")
    @JsonPropertyDescription("e.g. Facebook")
    private String organization;
    /**
     * e.g. Software Engineer
     * 
     */
    @JsonProperty("position")
    @JsonPropertyDescription("e.g. Software Engineer")
    private String position;
    /**
     * e.g. http://facebook.example.com
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("e.g. http://facebook.example.com")
    private URI url;
    /**
     * resume.json uses the ISO 8601 date standard e.g. 2014-06-29
     * 
     */
    @JsonProperty("startDate")
    @JsonPropertyDescription("resume.json uses the ISO 8601 date standard e.g. 2014-06-29")
    private String startDate;
    /**
     * e.g. 2012-06-29
     * 
     */
    @JsonProperty("endDate")
    @JsonPropertyDescription("e.g. 2012-06-29")
    private String endDate;
    /**
     * Give an overview of your responsibilities at the company
     * 
     */
    @JsonProperty("summary")
    @JsonPropertyDescription("Give an overview of your responsibilities at the company")
    private String summary;
    /**
     * Specify accomplishments and achievements
     * 
     */
    @JsonProperty("highlights")
    @JsonPropertyDescription("Specify accomplishments and achievements")
	@XmlElementWrapper(name = "highlights")
	@XmlElement(name = "highlight", type = String.class)
    private List<String> highlights = null;

    /**
     * e.g. Facebook
     * 
     */
    @JsonProperty("organization")
    public String getOrganization() {
        return organization;
    }

    /**
     * e.g. Facebook
     * 
     */
    @JsonProperty("organization")
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * e.g. Software Engineer
     * 
     */
    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    /**
     * e.g. Software Engineer
     * 
     */
    @JsonProperty("position")
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * e.g. http://facebook.example.com
     * 
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * e.g. http://facebook.example.com
     * 
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    /**
     * resume.json uses the ISO 8601 date standard e.g. 2014-06-29
     * 
     */
    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    /**
     * resume.json uses the ISO 8601 date standard e.g. 2014-06-29
     * 
     */
    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * e.g. 2012-06-29
     * 
     */
    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    /**
     * e.g. 2012-06-29
     * 
     */
    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Give an overview of your responsibilities at the company
     * 
     */
    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    /**
     * Give an overview of your responsibilities at the company
     * 
     */
    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Specify accomplishments and achievements
     * 
     */
    @JsonProperty("highlights")
    public List<String> getHighlights() {
        return highlights;
    }

    /**
     * Specify accomplishments and achievements
     * 
     */
    @JsonProperty("highlights")
    public void setHighlights(List<String> highlights) {
        this.highlights = highlights;
    }

}
