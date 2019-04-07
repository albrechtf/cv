
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
    "description",
    "highlights",
    "keywords",
    "startDate",
    "endDate",
    "url",
    "roles",
    "entity",
    "type"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

    /**
     * e.g. The World Wide Web
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("e.g. The World Wide Web")
    private String name;
    /**
     * Short summary of project. e.g. Collated works of 2017.
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Short summary of project. e.g. Collated works of 2017.")
    private String description;
    /**
     * Specify multiple features
     * 
     */
    @JsonProperty("highlights")
    @JsonPropertyDescription("Specify multiple features")
	@XmlElementWrapper(name = "highlights")
	@XmlElement(name = "highlight", type = String.class)
    private List<String> highlights = null;
    /**
     * Specify special elements involved
     * 
     */
    @JsonProperty("keywords")
    @JsonPropertyDescription("Specify special elements involved")
	@XmlElementWrapper(name = "keywords")
	@XmlElement(name = "keyword", type = String.class)
    private List<String> keywords = null;
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
     * e.g. http://www.computer.org/csdl/mags/co/1996/10/rx069-abs.html
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("e.g. http://www.computer.org/csdl/mags/co/1996/10/rx069-abs.html")
    private URI url;
    /**
     * Specify your role on this project or in company
     * 
     */
    @JsonProperty("roles")
    @JsonPropertyDescription("Specify your role on this project or in company")
	@XmlElementWrapper(name = "roles")
	@XmlElement(name = "role", type = String.class)
    private List<String> roles = null;
    /**
     * Specify the relevant company/entity affiliations e.g. 'greenpeace', 'corporationXYZ'
     * 
     */
    @JsonProperty("entity")
    @JsonPropertyDescription("Specify the relevant company/entity affiliations e.g. 'greenpeace', 'corporationXYZ'")
    private String entity;
    /**
     *  e.g. 'volunteering', 'presentation', 'talk', 'application', 'conference'
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription(" e.g. 'volunteering', 'presentation', 'talk', 'application', 'conference'")
    private String type;

    /**
     * e.g. The World Wide Web
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * e.g. The World Wide Web
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Short summary of project. e.g. Collated works of 2017.
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Short summary of project. e.g. Collated works of 2017.
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Specify multiple features
     * 
     */
    @JsonProperty("highlights")
    public List<String> getHighlights() {
        return highlights;
    }

    /**
     * Specify multiple features
     * 
     */
    @JsonProperty("highlights")
    public void setHighlights(List<String> highlights) {
        this.highlights = highlights;
    }

    /**
     * Specify special elements involved
     * 
     */
    @JsonProperty("keywords")
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * Specify special elements involved
     * 
     */
    @JsonProperty("keywords")
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
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
     * e.g. http://www.computer.org/csdl/mags/co/1996/10/rx069-abs.html
     * 
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * e.g. http://www.computer.org/csdl/mags/co/1996/10/rx069-abs.html
     * 
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    /**
     * Specify your role on this project or in company
     * 
     */
    @JsonProperty("roles")
    public List<String> getRoles() {
        return roles;
    }

    /**
     * Specify your role on this project or in company
     * 
     */
    @JsonProperty("roles")
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    /**
     * Specify the relevant company/entity affiliations e.g. 'greenpeace', 'corporationXYZ'
     * 
     */
    @JsonProperty("entity")
    public String getEntity() {
        return entity;
    }

    /**
     * Specify the relevant company/entity affiliations e.g. 'greenpeace', 'corporationXYZ'
     * 
     */
    @JsonProperty("entity")
    public void setEntity(String entity) {
        this.entity = entity;
    }

    /**
     *  e.g. 'volunteering', 'presentation', 'talk', 'application', 'conference'
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *  e.g. 'volunteering', 'presentation', 'talk', 'application', 'conference'
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

}
