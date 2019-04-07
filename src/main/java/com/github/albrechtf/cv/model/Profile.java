
package com.github.albrechtf.cv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "network",
    "username",
    "url"
})
public class Profile {

    /**
     * e.g. Facebook or Twitter
     * 
     */
    @JsonProperty("network")
    @JsonPropertyDescription("e.g. Facebook or Twitter")
    private String network;
    /**
     * e.g. neutralthoughts
     * 
     */
    @JsonProperty("username")
    @JsonPropertyDescription("e.g. neutralthoughts")
    private String username;
    /**
     * e.g. http://twitter.example.com/neutralthoughts
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("e.g. http://twitter.example.com/neutralthoughts")
    private String url;

    /**
     * e.g. Facebook or Twitter
     * 
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * e.g. Facebook or Twitter
     * 
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * e.g. neutralthoughts
     * 
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * e.g. neutralthoughts
     * 
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * e.g. http://twitter.example.com/neutralthoughts
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * e.g. http://twitter.example.com/neutralthoughts
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

}
