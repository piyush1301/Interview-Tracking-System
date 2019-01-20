package com.wipro.its.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="ITS_TBL_User_Credentials")
public class CredentialsBean {

	@Id
	private String userID;
	
	@NotEmpty(message="Mandatory Field")
	private String password;
	
	@NotEmpty(message="Mandatory Field")
	private String userType;
	
	@NotNull
	private int loginStatus;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

	
	
	
	
}
