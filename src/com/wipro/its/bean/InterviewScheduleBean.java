package com.wipro.its.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;


@Entity
@Table(name="ITS_TBL_Interview_Schedule")
public class InterviewScheduleBean {

	@Id
	@Column(name="INTERVIEWID")
	private String interviewID;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CANDIDATEID")
	private CandidateBean candidateBean;
	
	@Column(name="SUBJECT")
	//@NotEmpty(message="Please Enter Subject")
	//@Size(min=1,max=10,message="Name should be less than 10 characters")
	private String subject;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="TECHID")
	private TechPanelBean techPanelBean;
	
	@Column(name="INTERVIEWDATE")
	//@NotNull(message="Please Enter Date")
	//@DateTimeFormat(pattern="mm/dd/yyyy")
	private Date interviewDate;
	
	@Column(name="INTERVIEWTIME")
	//@NotEmpty(message="Please Enter STime")
	private String interviewTime;
	
	@Column(name="TECHRATING")
	//@NotNull(message="Please Enter Ratings")*********************to be done
	private Float techRating;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="EMPHRID")
	private HRPanelBean hrPanelBean;
	
	@Column(name="EMPHRINTERVIEW_DATE")
	//@NotNull(message="Please Enter Date")
	//@DateTimeFormat(pattern="mm/dd/yyyy")
	private Date empHRInterviewDate;
	
	@Column(name="EMPHRINTERVIEWTIME")
	//@NotEmpty(message="Please EnterTime")
	private String empHRInterviewTime;
	
	@Column(name="EMPHRRATING")
	//@NotNull(message="Please Enter Ratings")*********************to be done
	private Float empHRRating;
	
	@Column(name="RESULT")
	private String result;
	
	@Column(name="SHARERESULT")
	//@NotNull(message="Please Enter Result")*********************to be done
	private int shareResult;
	
	

	

	

	public CandidateBean getCandidateBean() {
		return candidateBean;
	}

	public void setCandidateBean(CandidateBean candidateBean) {
		this.candidateBean = candidateBean;
	}

	public TechPanelBean getTechPanelBean() {
		return techPanelBean;
	}

	public void setTechPanelBean(TechPanelBean techPanelBean) {
		this.techPanelBean = techPanelBean;
	}

	public HRPanelBean getHrPanelBean() {
		return hrPanelBean;
	}

	public void setHrPanelBean(HRPanelBean hrPanelBean) {
		this.hrPanelBean = hrPanelBean;
	}

	public String getInterviewID() {
		return interviewID;
	}

	public void setInterviewID(String interviewID) {
		this.interviewID = interviewID;
	}

	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

		public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(String interviewTime) {
		this.interviewTime = interviewTime;
	}

	public Float getTechRating() {
		return techRating;
	}

	public void setTechRating(Float techRating) {
		this.techRating = techRating;
	}

	
	public Date getEmpHRInterviewDate() {
		return empHRInterviewDate;
	}

	public void setEmpHRInterviewDate(Date empHRInterviewDate) {
		this.empHRInterviewDate = empHRInterviewDate;
	}

	public String getEmpHRInterviewTime() {
		return empHRInterviewTime;
	}

	public void setEmpHRInterviewTime(String empHRInterviewTime) {
		this.empHRInterviewTime = empHRInterviewTime;
	}

	public Float getEmpHRRating() {
		return empHRRating;
	}

	public void setEmpHRRating(Float empHRRating) {
		this.empHRRating = empHRRating;
	}

	public String getResult() {
		return result;
	}

	
	public void setResult(String result) {
		this.result = result;
	}

	public int getShareResult() {
		return shareResult;
	}

	public void setShareResult(int shareResult) {
		this.shareResult = shareResult;
	}

	
}
