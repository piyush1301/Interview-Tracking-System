package com.wipro.its.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="ITS_TBL_TechPanel")
public class TechPanelBean {

	@Id
	@Column(name="TECH_ID")
	private String techID;
	@Column(name="TECH_NAME")
	private String techName;
	
	@Column(name="SUBJECTS")
	@NotEmpty(message="Please Enter First Name")
	@Size(min=1,max=10,message="Name should be less than 10 characters")
	private String subjects;
	
	public String getTechID() {
		return techID;
	}
	public void setTechID(String techID) {
		this.techID = techID;
	}
	public String getTechName() {
		return techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	public String getSubjects() {
		return subjects;
	}
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	
}
