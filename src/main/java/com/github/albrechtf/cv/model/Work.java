
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
    "name",
    "location",
    "description",
    "position",
    "url",
    "startDate",
    "endDate",
    "summary",
    "highlights"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Work {

    /**
     * e.g. Facebook
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("e.g. Facebook")
    private String name;
    /**
     * e.g. Menlo Park, CA
     * 
     */
    @JsonProperty("location")
    @JsonPropertyDescription("e.g. Menlo Park, CA")
    private String location;
    /**
     * e.g. Social Media Company
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("e.g. Social Media Company")
    private String description;
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
     * Specify multiple accomplishments
     * 
     */
    @JsonProperty("highlights")
    @JsonPropertyDescription("Specify multiple accomplishments")
	@XmlElementWrapper(name = "highlights")
	@XmlElement(name = "highlight", type = String.class)
	private List<String> highlights;

	@JsonProperty("technologies")
	@JsonPropertyDescription("Technologies used in this role (non-standard property)")
	@XmlElementWrapper(name = "technologies")
	@XmlElement(name = "technology", type = String.class)
	private List<String> technologies;

    /**
     * e.g. Facebook
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * e.g. Facebook
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * e.g. Menlo Park, CA
     * 
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * e.g. Menlo Park, CA
     * 
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * e.g. Social Media Company
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * e.g. Social Media Company
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
     * Specify multiple accomplishments
     * 
     */
    @JsonProperty("highlights")
    public List<String> getHighlights() {
        return highlights;
    }

    /**
     * Specify multiple accomplishments
     * 
     */
    @JsonProperty("highlights")
    public void setHighlights(List<String> highlights) {
        this.highlights = highlights;
    }

	@JsonProperty("technologies")
	public List<String> getTechnologies() {
		return technologies;
	}

	@JsonProperty("technologies")
	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

}
