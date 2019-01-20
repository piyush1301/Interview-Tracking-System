package com.wipro.its.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="ITS_TBL_User_Profile")
public class ProfileBean {
	
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",parameters=@Parameter(name="property",value="candidate"))
	@Column(name="Candidate_ID")
	private String candidateId;
	
	
	@NotEmpty(message="Please Enter First Name")
	@Size(min=1,max=10,message="Name should be less than 10 characters")
	@Pattern(regexp="^[a-zA-Z ]+$",message="Please Enter Valid Name")
	@Column(name="First_Name")
	private String firstName;
	
	@NotEmpty(message="Please Enter Last Name")
	@Size(min=1,max=10 ,message="Name should be less than 10 characters")
	@Pattern(regexp="^[a-zA-Z ]+$",message="Please Enter Valid Name")
	@Column(name="Last_Name")
	private String lastName;
	
	@NotNull(message="Please Enter Date")
	@DateTimeFormat(pattern="mm/dd/yyyy")
	@Past
	@Column(name="Date_Of_Birth")
	private Date dateOfBirth;
	
	@NotEmpty(message="Please Enter Gender")
	@Column(name="Gender")
	private String gender;
	
	@NotEmpty(message="Please Enter Street")
	@Column(name="Street")
	@Size(min=1,max=10 ,message="Street should be less than 10 characters")
	private String street;
	
	@NotEmpty(message="Please Enter Location")
	@Column(name="Location")
	@Size(min=1,max=10 ,message="Location should be less than 10 characters")
	@Pattern(regexp="^[a-zA-Z ]+$",message="Please Enter Valid Name")
	private String location;
	
	@NotEmpty(message="Please Enter City")
	@Column(name="City")
	@Size(min=1,max=10 ,message="City should be less than 10 characters")
	@Pattern(regexp="^[a-zA-Z ]+$",message="Please Enter Valid Name")
	private String city;
	
	@NotEmpty(message="Please Enter State")
	@Column(name="State")
	@Size(min=1,max=10 ,message="State should be less than 10 characters")
	@Pattern(regexp="^[a-zA-Z ]+$",message="Please Enter Valid Name")
	private String state;
	
	@NotEmpty(message="Please Enter Pin code")
	//@Size(min=1,max=6,message="Enter 6 Digit Pin Code")
	@Column(name="Pin_code")
	@Pattern(regexp="^[1-9][0-9]{5}$",message="Must only Contain numeric Characters and must not start with 0")
     private String pincode;
	
	@NotEmpty(message="Please Enter Mobile No")
	@Size(min=10,max=10 ,message="Enter 10 digit Mobile No")
	@Pattern(regexp="^[7-9][0-9]{9}$",message=" Must only contain numeric characters and must start with 7,8 or 9")
private String mobileNo;
	
	
	@NotEmpty(message="Please enter valid Email")
	@Pattern(regexp="^[A-Za-z0-9\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]{2,}+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="enter valid email id")
@Column(name="Email_Id")
	private String emailId;
	
	
	
	@OneToOne(mappedBy="profile",cascade=CascadeType.ALL)
	private CandidateBean candidate;

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public CandidateBean getCandidate() {
		return candidate;
	}

	public void setCandidate(CandidateBean candidate) {
		this.candidate = candidate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	

}