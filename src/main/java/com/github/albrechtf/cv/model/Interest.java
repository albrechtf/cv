
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
    "keywords"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Interest {

    /**
     * e.g. Philosophy
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("e.g. Philosophy")
    private String name;

    @JsonProperty("keywords")
	@XmlElementWrapper(name = "keywords")
	@XmlElement(name = "keyword", type = String.class)
    private List<String> keywords = null;

    /**
     * e.g. Philosophy
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * e.g. Philosophy
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("keywords")
    public List<String> getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

}
