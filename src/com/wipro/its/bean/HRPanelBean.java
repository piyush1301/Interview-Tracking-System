package com.wipro.its.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="ITS_TBL_HRPanel")
public class HRPanelBean {

	@Id
	private String empHRID;
	
	private String empHRName;
	
	public String getEmpHRID() {
		return empHRID;
	}

	public void setEmpHRID(String empHRID) {
		this.empHRID = empHRID;
	}

	public String getEmpHRName() {
		return empHRName;
	}

	public void setEmpHRName(String empHRName) {
		this.empHRName = empHRName;
	}

	
	
	
	
}
