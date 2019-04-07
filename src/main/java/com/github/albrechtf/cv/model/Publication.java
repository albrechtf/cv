
package com.github.albrechtf.cv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "publisher",
    "releaseDate",
    "url",
    "summary"
})
public class Publication {

    /**
     * e.g. The World Wide Web
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("e.g. The World Wide Web")
    private String name;
    /**
     * e.g. IEEE, Computer Magazine
     * 
     */
    @JsonProperty("publisher")
    @JsonPropertyDescription("e.g. IEEE, Computer Magazine")
    private String publisher;
    /**
     * e.g. 1990-08-01
     * 
     */
    @JsonProperty("releaseDate")
    @JsonPropertyDescription("e.g. 1990-08-01")
    private String releaseDate;
    /**
     * e.g. http://www.computer.org.example.com/csdl/mags/co/1996/10/rx069-abs.html
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("e.g. http://www.computer.org.example.com/csdl/mags/co/1996/10/rx069-abs.html")
    private String url;
    /**
     * Short summary of publication. e.g. Discussion of the World Wide Web, HTTP, HTML.
     * 
     */
    @JsonProperty("summary")
    @JsonPropertyDescription("Short summary of publication. e.g. Discussion of the World Wide Web, HTTP, HTML.")
    private String summary;

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
     * e.g. IEEE, Computer Magazine
     * 
     */
    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    /**
     * e.g. IEEE, Computer Magazine
     * 
     */
    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * e.g. 1990-08-01
     * 
     */
    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * e.g. 1990-08-01
     * 
     */
    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * e.g. http://www.computer.org.example.com/csdl/mags/co/1996/10/rx069-abs.html
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * e.g. http://www.computer.org.example.com/csdl/mags/co/1996/10/rx069-abs.html
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Short summary of publication. e.g. Discussion of the World Wide Web, HTTP, HTML.
     * 
     */
    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    /**
     * Short summary of publication. e.g. Discussion of the World Wide Web, HTTP, HTML.
     * 
     */
    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

}
