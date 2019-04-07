
package com.github.albrechtf.cv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The schema version and any other tooling configuration lives here
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "canonical",
    "version",
    "lastModified"
})
public class Meta {

    /**
     * URL (as per RFC 3986) to latest version of this document
     * 
     */
    @JsonProperty("canonical")
    @JsonPropertyDescription("URL (as per RFC 3986) to latest version of this document")
    private String canonical;
    /**
     * A version field which follows semver - e.g. v1.0.0
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("A version field which follows semver - e.g. v1.0.0")
    private String version;
    /**
     * Using ISO 8601 with YYYY-MM-DDThh:mm:ss
     * 
     */
    @JsonProperty("lastModified")
    @JsonPropertyDescription("Using ISO 8601 with YYYY-MM-DDThh:mm:ss")
    private String lastModified;

    /**
     * URL (as per RFC 3986) to latest version of this document
     * 
     */
    @JsonProperty("canonical")
    public String getCanonical() {
        return canonical;
    }

    /**
     * URL (as per RFC 3986) to latest version of this document
     * 
     */
    @JsonProperty("canonical")
    public void setCanonical(String canonical) {
        this.canonical = canonical;
    }

    /**
     * A version field which follows semver - e.g. v1.0.0
     * 
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * A version field which follows semver - e.g. v1.0.0
     * 
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Using ISO 8601 with YYYY-MM-DDThh:mm:ss
     * 
     */
    @JsonProperty("lastModified")
    public String getLastModified() {
        return lastModified;
    }

    /**
     * Using ISO 8601 with YYYY-MM-DDThh:mm:ss
     * 
     */
    @JsonProperty("lastModified")
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

}
