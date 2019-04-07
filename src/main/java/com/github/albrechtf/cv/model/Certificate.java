package com.github.albrechtf.cv.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "date", "issuer" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Certificate {

	@JsonProperty("name")
	@JsonPropertyDescription("Name of certificate, e.g. iSAQB CPSA-F")
	private String name;

	@JsonProperty("date")
	@JsonPropertyDescription("Date of certification as ISO, e.g. 2018-03-20")
	private String date;

	@JsonProperty("issuer")
	@JsonPropertyDescription("Issuer of the certificate, e.g. iSAQB e.V.")
	private String issuer;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("date")
	public String getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(String date) {
		this.date = date;
	}

	@JsonProperty("issuer")
	public String getIssuer() {
		return issuer;
	}

	@JsonProperty("issuer")
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

}
