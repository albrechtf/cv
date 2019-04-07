
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
    "institution",
    "area",
    "studyType",
    "startDate",
    "endDate",
    "gpa",
    "courses"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Education {

    /**
     * e.g. Massachusetts Institute of Technology
     * 
     */
    @JsonProperty("institution")
    @JsonPropertyDescription("e.g. Massachusetts Institute of Technology")
    private String institution;
    /**
     * e.g. Arts
     * 
     */
    @JsonProperty("area")
    @JsonPropertyDescription("e.g. Arts")
    private String area;
    /**
     * e.g. Bachelor
     * 
     */
    @JsonProperty("studyType")
    @JsonPropertyDescription("e.g. Bachelor")
    private String studyType;
    /**
     * e.g. 2014-06-29
     * 
     */
    @JsonProperty("startDate")
    @JsonPropertyDescription("e.g. 2014-06-29")
    private String startDate;
    /**
     * e.g. 2012-06-29
     * 
     */
    @JsonProperty("endDate")
    @JsonPropertyDescription("e.g. 2012-06-29")
    private String endDate;
    /**
     * grade point average, e.g. 3.67/4.0
     * 
     */
    @JsonProperty("gpa")
    @JsonPropertyDescription("grade point average, e.g. 3.67/4.0")
    private String gpa;
    /**
     * List notable courses/subjects
     * 
     */
    @JsonProperty("courses")
    @JsonPropertyDescription("List notable courses/subjects")
	@XmlElementWrapper(name = "courses")
	@XmlElement(name = "course", type = String.class)
    private List<String> courses = null;

    /**
     * e.g. Massachusetts Institute of Technology
     * 
     */
    @JsonProperty("institution")
    public String getInstitution() {
        return institution;
    }

    /**
     * e.g. Massachusetts Institute of Technology
     * 
     */
    @JsonProperty("institution")
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * e.g. Arts
     * 
     */
    @JsonProperty("area")
    public String getArea() {
        return area;
    }

    /**
     * e.g. Arts
     * 
     */
    @JsonProperty("area")
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * e.g. Bachelor
     * 
     */
    @JsonProperty("studyType")
    public String getStudyType() {
        return studyType;
    }

    /**
     * e.g. Bachelor
     * 
     */
    @JsonProperty("studyType")
    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    /**
     * e.g. 2014-06-29
     * 
     */
    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    /**
     * e.g. 2014-06-29
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
     * grade point average, e.g. 3.67/4.0
     * 
     */
    @JsonProperty("gpa")
    public String getGpa() {
        return gpa;
    }

    /**
     * grade point average, e.g. 3.67/4.0
     * 
     */
    @JsonProperty("gpa")
    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    /**
     * List notable courses/subjects
     * 
     */
    @JsonProperty("courses")
    public List<String> getCourses() {
        return courses;
    }

    /**
     * List notable courses/subjects
     * 
     */
    @JsonProperty("courses")
    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

}
