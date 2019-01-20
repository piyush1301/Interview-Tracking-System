package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.dao.xyzDAO;
@Service("hrpanel")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class HRPanelImpl implements HRPanel {
	@Autowired
	xyzDAO itsDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public ArrayList<CandidateBean> viewCandidates(String empHRID, Date empHRInterviewDate) {
		// TODO Auto-generated method stub
		System.out.println(empHRID+"   "+empHRInterviewDate);
		
		return itsDao.viewCandidate(empHRID,empHRInterviewDate);
		
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean submitRatings(String interviewID, String empHRID, float rating) {
		// TODO Auto-generated method stub
		
		InterviewScheduleBean a2=(InterviewScheduleBean) sessionFactory.getCurrentSession().get(InterviewScheduleBean.class, interviewID);
				
		System.out.println(a2);
		a2.setEmpHRRating(rating);
		sessionFactory.getCurrentSession().saveOrUpdate(a2);
		
		return true;
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public InterviewScheduleBean viewFinalResults(String interviewID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public InterviewScheduleBean getInterviewBean(String interviewID) {
		// TODO Auto-generated method stub
		
		//System.out.println(interviewID);
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
		
		System.out.println(a1);
		return ibean;
	}

}
