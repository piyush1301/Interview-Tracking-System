package com.wipro.its.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;

import com.wipro.its.dao.xyzDAO;

@Service("administrator")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class AdministratorImpl implements Administrator{

	@Autowired
	xyzDAO itsDao;

	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	public String addCandidate(ProfileBean profileBean,CandidateBean candidateBean) {

		
		candidateBean.setProfile(profileBean);
		profileBean.setCandidate(candidateBean);
		
		String ans=itsDao.getCandidateID(candidateBean, "its_seq_candidateID");
		if(!(ans.equals("FAIL")))
		{
			candidateBean.setCandidateID(ans);
			ans=itsDao.addCandidate(candidateBean);
		}
		return ans;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ArrayList<CandidateBean> viewCandidate(String skills,float experience, String qualification) {
		ArrayList<CandidateBean> al=itsDao.viewCandidate(skills, experience, qualification);
		return al;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String getUserAttempt(CandidateBean candidateBean) {
		
		String ans=itsDao.getUserAttempt(candidateBean);
		return ans;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String checkTechnicalAvalibility(InterviewScheduleBean interviewBean) {
		String ans=itsDao.checkTechnicalAvalibility(interviewBean);
		return ans;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public InterviewScheduleBean makeTechObject(InterviewScheduleBean interviewBean) {
		InterviewScheduleBean ibean=itsDao.makeTechObject(interviewBean);
		return ibean;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String scheduleInterviewforTech(InterviewScheduleBean interviewBean) {
		
		String ans="";
		String id=itsDao.getTechnicalId(interviewBean,"its_seq_interviewID");
			if(id.equalsIgnoreCase("ERROR"))
			{
				ans="ERROR";
			}
			
			else
			{
				interviewBean.setInterviewID(id);
				id=itsDao.scheduleInterviewforTech(interviewBean);
				ans=id;
			}
		return ans;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String ifNotFirst(CandidateBean candidateBean) {
		
		String ans=itsDao.ifNotFirst(candidateBean);
		return ans;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String checkHRAvalibility(InterviewScheduleBean interviewBean) {
		String ans=itsDao.checkHRAvalibility(interviewBean);
		return ans;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String scheduleInterviewforHR(InterviewScheduleBean interviewBean) {
		String ans=itsDao.scheduleInterviewforHR(interviewBean);
		return ans;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean shareCandidateDetails(String candidateID, String panel) {
		boolean ans=itsDao.shareCandidateDetails(candidateID, panel);
		return ans;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public InterviewScheduleBean viewRatings(String interviewID) {
		InterviewScheduleBean interviewBean=itsDao.viewRatings(interviewID);
		return interviewBean;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean finalizeResultDecision(String interviewID, String result) {
		boolean ans=itsDao.finalizeResultDecision(interviewID, result);
		return ans;
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean declareResults(String interviewId, int share) {
		boolean ans=itsDao.declareResults(interviewId, share);
		return ans;
	}


}
