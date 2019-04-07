
package com.github.albrechtf.cv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "postalCode",
    "city",
    "countryCode",
    "region"
})
public class Location {

    /**
     * To add multiple address lines, use 
     * . For example, 1234 Glücklichkeit Straße
     * Hinterhaus 5. Etage li.
     * 
     */
    @JsonProperty("address")
    @JsonPropertyDescription("To add multiple address lines, use \n. For example, 1234 Gl\u00fccklichkeit Stra\u00dfe\nHinterhaus 5. Etage li.")
    private String address;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("city")
    private String city;
    /**
     * code as per ISO-3166-1 ALPHA-2, e.g. US, AU, IN
     * 
     */
    @JsonProperty("countryCode")
    @JsonPropertyDescription("code as per ISO-3166-1 ALPHA-2, e.g. US, AU, IN")
    private String countryCode;
    /**
     * The general region where you live. Can be a US state, or a province, for instance.
     * 
     */
    @JsonProperty("region")
    @JsonPropertyDescription("The general region where you live. Can be a US state, or a province, for instance.")
    private String region;

    /**
     * To add multiple address lines, use 
     * . For example, 1234 Glücklichkeit Straße
     * Hinterhaus 5. Etage li.
     * 
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * To add multiple address lines, use 
     * . For example, 1234 Glücklichkeit Straße
     * Hinterhaus 5. Etage li.
     * 
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * code as per ISO-3166-1 ALPHA-2, e.g. US, AU, IN
     * 
     */
    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * code as per ISO-3166-1 ALPHA-2, e.g. US, AU, IN
     * 
     */
    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * The general region where you live. Can be a US state, or a province, for instance.
     * 
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * The general region where you live. Can be a US state, or a province, for instance.
     * 
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

}
