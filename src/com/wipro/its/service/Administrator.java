package com.wipro.its.service;

import java.util.ArrayList;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;

public interface Administrator {
	
	public String addCandidate(ProfileBean profileBean,CandidateBean candidateBean);
	public ArrayList<CandidateBean> viewCandidate(String skills, float experience,String qualification);
	public String getUserAttempt(CandidateBean candidateBean);
	public String checkTechnicalAvalibility(InterviewScheduleBean interviewBean);
	public InterviewScheduleBean makeTechObject(InterviewScheduleBean interviewBean);
	public String scheduleInterviewforTech(InterviewScheduleBean interviewBean);
	
	public String ifNotFirst(CandidateBean candidateBean);
	public String checkHRAvalibility(InterviewScheduleBean interviewBean);
	public String scheduleInterviewforHR(InterviewScheduleBean interviewBean);
	boolean shareCandidateDetails(String candidateID,String panel);

	public InterviewScheduleBean viewRatings(String interviewID);
	public boolean finalizeResultDecision(String interviewID,String result);
	public boolean declareResults(String interviewId,int share);

}
