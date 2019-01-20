package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.dao.xyzDAO;
@Service("techpanel")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class TechPanelImpl implements TechPanel{
	@Autowired
	xyzDAO itsDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ArrayList<CandidateBean> viewCandidates(String techID, Date interviewDate) {
		// TODO Auto-generated method stub
		return itsDao.viewCandidates(techID,interviewDate);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean submitRatings(String interviewID, String techID, float rating) {
		InterviewScheduleBean a2=(InterviewScheduleBean) sessionFactory.getCurrentSession().get(InterviewScheduleBean.class, interviewID);
		
		System.out.println(a2);
		if(rating>5)
			return false;
		else
		{
		a2.setTechRating(rating);
		sessionFactory.getCurrentSession().saveOrUpdate(a2);
		System.out.println("hello");
		return true;
		}
	}

	public InterviewScheduleBean viewFinalResults(String interviewID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public InterviewScheduleBean getInterviewBean(String interviewID) {
		InterviewScheduleBean a1=null;
		InterviewScheduleBean ibean=new InterviewScheduleBean();
		try
		{
		a1=(InterviewScheduleBean) sessionFactory.getCurrentSession().get(InterviewScheduleBean.class, interviewID);
		if(a1==null)
		{
			ibean.setInterviewID("no object exist");
		}
		else
		{
			ibean=a1;
		}
		}
		catch(Exception e)
		{
			ibean=null;
		}
		
		//System.out.println(q);
		
		System.out.println(a1);
		return ibean;	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ArrayList<InterviewScheduleBean> viewAllInterviewDetails() {
		// TODO Auto-generated method stub
		
		ArrayList <InterviewScheduleBean> al=itsDao.viewAllInterviewDetails();
		return al;
	}

	}


