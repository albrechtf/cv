
package com.github.albrechtf.cv.model;

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
    "level",
    "keywords"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Skill {

    /**
     * e.g. Web Development
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("e.g. Web Development")
    private String name;
    /**
     * e.g. Master
     * 
     */
    @JsonProperty("level")
    @JsonPropertyDescription("e.g. Master")
    private String level;
    /**
     * List some keywords pertaining to this skill
     * 
     */
    @JsonProperty("keywords")
    @JsonPropertyDescription("List some keywords pertaining to this skill")
	@XmlElementWrapper(name = "keywords")
	@XmlElement(name = "keyword", type = String.class)
    private List<String> keywords = null;

	@JsonProperty("rating")
	@JsonPropertyDescription("Rating (0-100) for graphical representation")
	private int rating;

    /**
     * e.g. Web Development
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * e.g. Web Development
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * e.g. Master
     * 
     */
    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    /**
     * e.g. Master
     * 
     */
    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * List some keywords pertaining to this skill
     * 
     */
    @JsonProperty("keywords")
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * List some keywords pertaining to this skill
     * 
     */
    @JsonProperty("keywords")
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

	@JsonProperty("rating")
	public int getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(int rating) {
		this.rating = rating;
	}

}
