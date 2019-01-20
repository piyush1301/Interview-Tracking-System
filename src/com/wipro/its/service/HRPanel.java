package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;

public interface HRPanel {
	ArrayList<CandidateBean> viewCandidates(String empHRID, Date empHRInterviewDate);
	boolean submitRatings(String interviewID, String empHRID, float rating);
	InterviewScheduleBean viewFinalResults(String interviewID);
	InterviewScheduleBean getInterviewBean(String interviewID);

}
