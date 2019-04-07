
package com.github.albrechtf.cv.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Resume Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "basics",
    "work",
    "volunteer",
    "education",
    "awards",
    "publications",
    "skills",
    "languages",
    "interests",
    "references",
    "projects",
		"certificates",
    "meta"
})
@XmlRootElement(name = "resume")
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume {

    @JsonProperty("basics")
    private Basics basics;

    @JsonProperty("work")
	@XmlElementWrapper(name = "workhistory")
	@XmlElement(name = "work", type = Work.class)
	private List<Work> work;

    @JsonProperty("volunteer")
	@XmlElementWrapper(name = "volunteering")
	@XmlElement(name = "volunteer", type = Volunteer.class)
	private List<Volunteer> volunteer;

    @JsonProperty("education")
	@XmlElementWrapper(name = "educations")
	@XmlElement(name = "education", type = Education.class)
	private List<Education> education;

    /**
     * Specify any awards you have received throughout your professional career
     * 
     */
    @JsonProperty("awards")
    @JsonPropertyDescription("Specify any awards you have received throughout your professional career")
	@XmlElementWrapper(name = "awards")
	@XmlElement(name = "award", type = Award.class)
	private List<Award> awards;

    /**
     * Specify your publications through your career
     * 
     */
    @JsonProperty("publications")
    @JsonPropertyDescription("Specify your publications through your career")
	@XmlElementWrapper(name = "publications")
	@XmlElement(name = "publication", type = Publication.class)
	private List<Publication> publications;

    /**
     * List out your professional skill-set
     * 
     */
    @JsonProperty("skills")
    @JsonPropertyDescription("List out your professional skill-set")
	@XmlElementWrapper(name = "skills")
	@XmlElement(name = "skill", type = Skill.class)
	private List<Skill> skills;
    /**
     * List any other languages you speak
     * 
     */
    @JsonProperty("languages")
    @JsonPropertyDescription("List any other languages you speak")
	@XmlElementWrapper(name = "languages")
	@XmlElement(name = "language", type = Language.class)
	private List<Language> languages;

	@JsonProperty("certificates")
	@JsonPropertyDescription("List any certificates you have received")
	@XmlElementWrapper(name = "certificates")
	@XmlElement(name = "certificate", type = Certificate.class)
	private List<Certificate> certificates;

    @JsonProperty("interests")
	@XmlElementWrapper(name = "interests")
	@XmlElement(name = "interest", type = Interest.class)
	private List<Interest> interests;

    /**
     * List references you have received
     * 
     */
    @JsonProperty("references")
    @JsonPropertyDescription("List references you have received")
	@XmlElementWrapper(name = "references")
	@XmlElement(name = "reference", type = Reference.class)
	private List<Reference> references;

    /**
     * Specify career projects
     * 
     */
    @JsonProperty("projects")
    @JsonPropertyDescription("Specify career projects")
	@XmlElementWrapper(name = "projects")
	@XmlElement(name = "project", type = Project.class)
	private List<Project> projects;

    /**
     * The schema version and any other tooling configuration lives here
     * 
     */
    @JsonProperty("meta")
    @JsonPropertyDescription("The schema version and any other tooling configuration lives here")
    private Meta meta;

    @JsonProperty("basics")
    public Basics getBasics() {
        return basics;
    }

    @JsonProperty("basics")
    public void setBasics(Basics basics) {
        this.basics = basics;
    }

    @JsonProperty("work")
    public List<Work> getWork() {
        return work;
    }

    @JsonProperty("work")
    public void setWork(List<Work> work) {
        this.work = work;
    }

    @JsonProperty("volunteer")
    public List<Volunteer> getVolunteer() {
        return volunteer;
    }

    @JsonProperty("volunteer")
    public void setVolunteer(List<Volunteer> volunteer) {
        this.volunteer = volunteer;
    }

    @JsonProperty("education")
    public List<Education> getEducation() {
        return education;
    }

    @JsonProperty("education")
    public void setEducation(List<Education> education) {
        this.education = education;
    }

    /**
     * Specify any awards you have received throughout your professional career
     * 
     */
    @JsonProperty("awards")
    public List<Award> getAwards() {
        return awards;
    }

    /**
     * Specify any awards you have received throughout your professional career
     * 
     */
    @JsonProperty("awards")
    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    /**
     * Specify your publications through your career
     * 
     */
    @JsonProperty("publications")
    public List<Publication> getPublications() {
        return publications;
    }

    /**
     * Specify your publications through your career
     * 
     */
    @JsonProperty("publications")
    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    /**
     * List out your professional skill-set
     * 
     */
    @JsonProperty("skills")
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * List out your professional skill-set
     * 
     */
    @JsonProperty("skills")
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    /**
     * List any other languages you speak
     * 
     */
    @JsonProperty("languages")
    public List<Language> getLanguages() {
        return languages;
    }

    /**
     * List any other languages you speak
     * 
     */
    @JsonProperty("languages")
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

	@JsonProperty("certificates")
	public List<Certificate> getCertificates() {
		return certificates;
	}

	@JsonProperty("certificates")
	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

    @JsonProperty("interests")
    public List<Interest> getInterests() {
        return interests;
    }

    @JsonProperty("interests")
    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    /**
     * List references you have received
     * 
     */
    @JsonProperty("references")
    public List<Reference> getReferences() {
        return references;
    }

    /**
     * List references you have received
     * 
     */
    @JsonProperty("references")
    public void setReferences(List<Reference> references) {
        this.references = references;
    }

    /**
     * Specify career projects
     * 
     */
    @JsonProperty("projects")
    public List<Project> getProjects() {
        return projects;
    }

    /**
     * Specify career projects
     * 
     */
    @JsonProperty("projects")
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    /**
     * The schema version and any other tooling configuration lives here
     * 
     */
    @JsonProperty("meta")
    public Meta getMeta() {
        return meta;
    }

    /**
     * The schema version and any other tooling configuration lives here
     * 
     */
    @JsonProperty("meta")
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
