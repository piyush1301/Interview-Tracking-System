package com.wipro.its.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;

public interface xyzDAO {
	String createXYZ(CandidateBean cb);
	int deleteXYZ(ArrayList<String> candidateID);
	boolean updateXYZ(CandidateBean cb);
	CandidateBean findByID(String candidateID);
	ArrayList<CandidateBean> findAll();
	
	
	ArrayList<CandidateBean> viewCandidate(String empHRID, Date empHRInterviewDate);
	ArrayList<CandidateBean> viewCandidates(String techID, Date interviewDate);
	public String addCandidate(CandidateBean candidateBean);
	public ArrayList<CandidateBean> viewCandidate(String skills, float experience,String qualification);
	public String getCandidateID(CandidateBean candidateBean,String seqName);
	
	public String getUserAttempt(CandidateBean candidateBean);
	public String checkTechnicalAvalibility(InterviewScheduleBean interviewBean);
	public InterviewScheduleBean makeTechObject(InterviewScheduleBean interviewBean);
	public String scheduleInterviewforTech(InterviewScheduleBean interviewBean);
	public String getTechnicalId(InterviewScheduleBean interviewBean,String seqName);
	
	public String ifNotFirst(CandidateBean candidateBean);
	public String checkHRAvalibility(InterviewScheduleBean interviewBean);
	public String scheduleInterviewforHR(InterviewScheduleBean interviewBean);
	boolean shareCandidateDetails(String candidateID,String panel);
	
	public InterviewScheduleBean viewRatings(String interviewID);
	public boolean finalizeResultDecision(String interviewID,String result);
	public boolean declareResults(String interviewId,int share);
	
	public String getTechnicalDate(String id); 
	boolean logout(String userId); 
	
	public ArrayList<InterviewScheduleBean> viewAllInterviewDetails();
	
	
}
