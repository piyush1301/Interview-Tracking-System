package com.wipro.its.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="ITS_TBL_Candidate")
public class CandidateBean {

	

	@Id
	@Column(name="Candidate_ID")
	private String candidateID;
	
		@Column(name="Primary_Skills")
		private String primarySkills;
		
		@Column(name="Secondary_Skills")
		private String secondarySkills;
		
		@Column(name="Experience")
		@NotNull
		private Float experience;
		
		@Column(name="Qualification")
		@NotEmpty(message="Enter Qualification")
		private String qualification;
		
		@Column(name="Designation")
		@NotEmpty(message="Enter Designation")
		@Size(min=1,max=10 ,message="Designation should be less than 10 characters")
		private String designation;
		
		@Column(name="Notice_Period")
		@NotNull
		private Integer noticePeriod;
		
		@Column(name="Location")
		@NotEmpty(message="Enter Location")
		@Size(min=1,max=10 ,message="Location should be less than 10 characters")
		private String location;
		
		@Column(name="Share_Details")
		private Integer shareDetails;
		
		
		@OneToOne(cascade=CascadeType.ALL)
		@PrimaryKeyJoinColumn
		private ProfileBean profile;


		public String getCandidateID() {
			return candidateID;
		}

		public void setCandidateID(String candidateID) {
			this.candidateID = candidateID;
		}

		public ProfileBean getProfile() {
			return profile;
		}

		public void setProfile(ProfileBean profile) {
			this.profile = profile;
		}

		public String getPrimarySkills() {
			return primarySkills;
		}

		public void setPrimarySkills(String primarySkills) {
			this.primarySkills = primarySkills;
		}

		public String getSecondarySkills() {
			return secondarySkills;
		}

		public void setSecondarySkills(String secondarySkills) {
			this.secondarySkills = secondarySkills;
		}

		public Float getExperience() {
			return experience;
		}

		public void setExperience(Float experience) {
			this.experience = experience;
		}

		public String getQualification() {
			return qualification;
		}

		public void setQualification(String qualification) {
			this.qualification = qualification;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public Integer getNoticePeriod() {
			return noticePeriod;
		}

		public void setNoticePeriod(Integer noticePeriod) {
			this.noticePeriod = noticePeriod;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public Integer getShareDetails() {
			return shareDetails;
		}

		public void setShareDetails(Integer shareDetails) {
			this.shareDetails = shareDetails;
		}

		
}
