package com.wipro.its.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.bean.HRPanelBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.TechPanelBean;

@Repository("itsDao")
public class xyzDAOImpl implements xyzDAO{

	@Autowired
	SessionFactory sessionFactory;

	public String createXYZ(CandidateBean cb) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int deleteXYZ(ArrayList<String> candidateID) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public boolean updateXYZ(CandidateBean cb) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public CandidateBean findByID(String candidateID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<CandidateBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public String addCandidate(CandidateBean candidateBean) {
		String ans="";
		try
		{
			ans=(String)sessionFactory.getCurrentSession().save(candidateBean);
		}
		catch(Exception e)
		{
			ans = "ERROR";			
		}
		return ans;
}


public ArrayList<CandidateBean> viewCandidate(String skills,float experience, String qualification) {
		ArrayList<CandidateBean> al=new ArrayList<CandidateBean>();
		
	try
	{
		
		Query q=sessionFactory.getCurrentSession().createQuery("FROM CandidateBean WHERE primarySkills=? And experience=? And qualification=?");
		q.setString(0,skills);
		q.setFloat(1,experience);
		q.setString(2,qualification);
		al=(ArrayList<CandidateBean>) q.list();
	}
	
	catch(Exception e)
	{
		al=null;
	}
	return al;
}
public String getCandidateID(CandidateBean candidateBean, String seqName) {
	
	String ans="null";
	String query="select "+seqName+".nextval from dual";
	ans=sessionFactory.getCurrentSession().createSQLQuery(query).uniqueResult().toString();
	
	if((ans.equals("null")))
	{
		ans="FAIL";
	}
	
	else
	{
		String val=candidateBean.getProfile().getFirstName();
		val=(val.substring(0,2)).toUpperCase();
		ans=val+ans;
	}
	return ans;
}


@Override
public ArrayList<CandidateBean> viewCandidate(String empHRID, Date empHRInterviewDate) {
	ArrayList<InterviewScheduleBean> list1 = (ArrayList<InterviewScheduleBean>) sessionFactory.getCurrentSession().createCriteria(InterviewScheduleBean.class).list();
	Iterator it = list1.iterator();
	ArrayList<CandidateBean> list2 = new ArrayList<>();
	
	System.out.println("Inside HRPANEL DAO");
	
	while(it.hasNext()) {
		InterviewScheduleBean obj = (InterviewScheduleBean) it.next();
		 SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MMM-yyyy");
		 String d1 = dmyFormat.format(obj.getEmpHRInterviewDate());
		 String d2 = dmyFormat.format(empHRInterviewDate);
		System.out.println(d1);
		System.out.println(d2);
		if(obj.getHrPanelBean().getEmpHRID().equals(empHRID)&&d1.equals(d2)) {
			CandidateBean bean = (CandidateBean) sessionFactory.getCurrentSession().get(CandidateBean.class, obj.getCandidateBean().getCandidateID());
			list2.add(bean);
		}
	}
	return list2;
}


public ArrayList<CandidateBean> viewCandidates(String techID, Date interviewDate) {

	ArrayList<InterviewScheduleBean> list1 = (ArrayList<InterviewScheduleBean>) sessionFactory.getCurrentSession().createCriteria(InterviewScheduleBean.class).list();
	Iterator it = list1.iterator();
	ArrayList<CandidateBean> list2 = new ArrayList<>();
	while(it.hasNext()) {
		InterviewScheduleBean obj = (InterviewScheduleBean) it.next();
		 SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MMM-yyyy");
		 String d1 = dmyFormat.format(obj.getInterviewDate());
		 String d2 = dmyFormat.format(interviewDate);
		System.out.println(d1);
		System.out.println(d2);
		if(obj.getTechPanelBean().getTechID().equals(techID)&&d1.equals(d2)) {
			CandidateBean bean = (CandidateBean) sessionFactory.getCurrentSession().get(CandidateBean.class, obj.getCandidateBean().getCandidateID());
			list2.add(bean);
		}
	}
	return list2;
}


public String getUserAttempt(CandidateBean candidateBean) {
	String ans="";
	List<InterviewScheduleBean> l=new ArrayList<InterviewScheduleBean>();
	try
	{
		Query q=sessionFactory.getCurrentSession().createQuery("FROM InterviewScheduleBean WHERE candidateBean.candidateID=?");
		q.setString(0,candidateBean.getCandidateID());
		System.out.println("upar wala chal rha hai");
		l=q.list();
	
		if(l.isEmpty())
		{
			ans="FIRST";
		}
		else
		{
			ans="SECOND";
		}
	}
	
	catch(Exception e)
	{
		ans="ERROR";
	}
	return ans;
}



public String checkTechnicalAvalibility(InterviewScheduleBean interviewBean) {
	String ans="";
	List<InterviewScheduleBean>l=new ArrayList<InterviewScheduleBean>();
	Date d=interviewBean.getInterviewDate();
	SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
	String da=sf.format(d);
	try
	{
	
		d=sf.parse(da);
		Query q=sessionFactory.getCurrentSession().createQuery("FROM InterviewScheduleBean WHERE techPanelBean.techName=? AND interviewDate=?");
		q.setString(0,interviewBean.getTechPanelBean().getTechName());
		q.setDate(1,d);
		l=q.list();
		
		if(l.isEmpty())
		{
			ans="Avaliable";
			
		}
		
		else
		{
			ans="Not_Avaliable";
		}
	}
	
	catch(Exception e)
	{
		ans="ERROR";
	}
		return ans;
}


public InterviewScheduleBean makeTechObject(InterviewScheduleBean interviewBean) {
	
	List<TechPanelBean> l;
	InterviewScheduleBean current =new InterviewScheduleBean();
	
	//try
	//{
		CandidateBean cbean=(CandidateBean)sessionFactory.getCurrentSession().get(CandidateBean.class,interviewBean.getCandidateBean().getCandidateID());
		Query q=sessionFactory.getCurrentSession().createQuery("FROM TechPanelBean WHERE techName=?");
		q.setString(0,interviewBean.getTechPanelBean().getTechName());
		System.out.println("Before List");
		l=q.list();
		System.out.println("After List");
		System.out.println("Before Iterator");
		Iterator<TechPanelBean> it=l.iterator();
		System.out.println("After Iterator");
		//it=l.iterator();
		System.out.println("Before Iterator next");
		TechPanelBean tbean=null;
		while(it.hasNext())
		{
			tbean=it.next();
		}
		System.out.println("After Iterator next");
		current.setCandidateBean(cbean);
		current.setSubject(tbean.getSubjects());
		current.setTechPanelBean(tbean);
		current.setInterviewDate(interviewBean.getInterviewDate());
		current.setInterviewTime(interviewBean.getInterviewTime());
		current.setShareResult(0);
	//}
	
	//catch(Exception e)
	//{
		//current=null;
	//}
	return current;
}


public String scheduleInterviewforTech(InterviewScheduleBean interviewBean) {
	
	String ans="";
	
	try
	{
		ans=(String)sessionFactory.getCurrentSession().save(interviewBean);
	}
	catch(Exception e)
	{
		ans="ERROR";
	}
		return ans;
}


public String getTechnicalId(InterviewScheduleBean interviewBean,String seqName) {
	String ans="";
	try
	{
	ans=sessionFactory.getCurrentSession().createSQLQuery("select "+seqName+".nextval from dual").uniqueResult().toString();
	ans=((interviewBean.getSubject().substring(0,2)).toUpperCase())+ans;
	}
	catch(Exception e)
	{
		ans="ERROR";
	}
		return ans;
}



public String ifNotFirst(CandidateBean candidateBean) {
	
	String ans="";
	List<InterviewScheduleBean> l=new ArrayList<InterviewScheduleBean>();
	InterviewScheduleBean interviewBean=new InterviewScheduleBean();
	
	
	
	Query q=sessionFactory.getCurrentSession().createQuery("FROM InterviewScheduleBean WHERE candidateBean.candidateID=?");
	q.setString(0,candidateBean.getCandidateID());
	l=q.list();
	Iterator<InterviewScheduleBean> it=l.iterator();
	while(it.hasNext())
	{
		interviewBean=it.next();
		
			if(it.hasNext())
			{
				continue;
			}
			
			else
			{
				if(interviewBean.getTechRating()==null)
				{
					ans="TechnicalresultAwaited";
				}
				
				else
				{
					if(interviewBean.getTechRating()<=(2.5))
					{
						SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
						String testDate=sf.format(interviewBean.getInterviewDate());
						String todayDate=sf.format(new Date());
						int diff=(Integer.parseInt(cmpDates(testDate,todayDate)));
						
							if(diff>=30)
							{
								
								ans="TechnicalReScheduled";
							}
							
							else
							{
								
								ans="NotApplicable";
							}
					}
					
					else
					{
						if(interviewBean.getHrPanelBean()==null)
						{
							ans=interviewBean.getInterviewID();
							ans=ans+"BookForHr";
						}
						
						else
						{
							if(interviewBean.getEmpHRRating()==null)
							{
								ans="HRresultAwaited";
							}
							
							else
							{
								if(interviewBean.getResult()==null)
								{
									ans="ResultNotSet";
								}
								else
								{
									if(interviewBean.getResult().equalsIgnoreCase("PASS"))
									{
										ans="PASS";
									}
									else if(interviewBean.getResult().equalsIgnoreCase("FAIL"))
									{
										SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
										String testDate=sf.format(interviewBean.getEmpHRInterviewDate());
										String todayDate=sf.format(new Date());
										int diff=(Integer.parseInt(cmpDates(testDate,todayDate)));
										
											if(diff>=30)
											{
												
												ans="TechnicalReScheduled";
											}
											
											else
											{
												
												ans="NotApplicable";
											}
									}
								}
							}
						}
					}
				}
			}
	}
	return ans;
}

public String cmpDates(String testDate,String todayDate)
{
	String ans="";
	ans=sessionFactory.getCurrentSession().createSQLQuery("select (to_date('"+todayDate+"','dd-mm-yyyy')-to_date('"+testDate+"','dd-mm-yyyy')) from dual").uniqueResult().toString();
	return ans;
}



public String checkHRAvalibility(InterviewScheduleBean interviewBean) {
	
	String ans="";
	Date d=interviewBean.getEmpHRInterviewDate();
	SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy");
	List<InterviewScheduleBean> l=new ArrayList<InterviewScheduleBean>();
	String da=sf.format(d);
	
	try 
	{	
		String id= interviewBean.getCandidateBean().getCandidateID();
		Query a=sessionFactory.getCurrentSession().createQuery("FROM InterviewScheduleBean WHERE candidateBean.candidateID=?");
		a.setString(0,id);
		InterviewScheduleBean interview =new InterviewScheduleBean();
		
		l=a.list();
		Iterator<InterviewScheduleBean> it=l.iterator();
		while(it.hasNext())
		{
			interview=it.next();
			
			if(it.hasNext())
			{
				continue;
			}
			
			else
			{
				Date tech=interview.getInterviewDate();
				Date hr=interviewBean.getEmpHRInterviewDate();
				
				String techDate=sf.format(tech);
				String hrDate=sf.format(hr);
				
				String an=cmpDates(techDate, hrDate);
				int i=Integer.parseInt(an);
				
				if(i>=0)
				{
					ans="CorrectDate";
				}
				
				else
				{
					ans="InCorrectDate"+techDate;
				}
			}
		}
		
		
		if(ans.equalsIgnoreCase("CorrectDate"))
		{
		
			d=sf.parse(da);
			Query q=sessionFactory.getCurrentSession().createQuery("FROM InterviewScheduleBean WHERE hrPanelBean.empHRName=? AND empHRInterviewDate=?");
			q.setString(0,interviewBean.getHrPanelBean().getEmpHRName());
			q.setDate(1,d);
			l=q.list();
			
			if(l.isEmpty())
			{
				ans="Avalibile";
			}
	
			else
			{
				ans="NotAvalible";
			}
		}
	}
	
	catch(Exception e)
	{
		ans="ERROR";
	}
	return ans;
}



public String scheduleInterviewforHR(InterviewScheduleBean interviewBean) {
	
	String ans="";
	InterviewScheduleBean current=new InterviewScheduleBean();
	try
	{
	current=(InterviewScheduleBean)sessionFactory.getCurrentSession().get(InterviewScheduleBean.class,interviewBean.getInterviewID());
	if(current==null)
		{
			ans="ERROR";
		}
	else
		{
			current.setHrPanelBean(getHR(interviewBean.getHrPanelBean().getEmpHRName()));
			current.setEmpHRInterviewDate(interviewBean.getEmpHRInterviewDate());
			current.setEmpHRInterviewTime(interviewBean.getEmpHRInterviewTime());
			sessionFactory.getCurrentSession().saveOrUpdate(current);
			ans="SUCCESS";
		}
	}
	catch(Exception e)
	{
		ans="ERROR";
	}
	return ans;
}

public HRPanelBean getHR(String hr)
{
	HRPanelBean hrPanel=new HRPanelBean();
	List<HRPanelBean> l=new ArrayList<HRPanelBean>();
	
	try
	{
	
		Query q=sessionFactory.getCurrentSession().createQuery("FROM HRPanelBean WHERE empHRName=?");
		q.setString(0,hr);
	
		l=q.list();
		Iterator<HRPanelBean> it=l.iterator();
		hrPanel=it.next();
	}
	
	catch(Exception e)
	{
		hrPanel=null;
	}
	return hrPanel;
}



public boolean shareCandidateDetails(String candidateID, String panel) {
	//boolean ans=false;
	//try
	//{
		/*int i=-1;
		int share=Integer.parseInt(panel);
		System.out.println("Value "+share);
		Query q=sessionFactory.getCurrentSession().createQuery("UPDATE CandidateBean set shareDetails=?  WHERE candidateID=?");
		q.setInteger(0,share);
		q.setString(1,candidateID);
		i=q.executeUpdate();
		System.out.println("i==" +i);
		if(i==1)
		{
			return true;
			//ans=true;
		}
	//}
	//catch(Exception e)
	//{
		//ans=false;
	//}
		else
	return false;*/
	try {
	CandidateBean cb = (CandidateBean) sessionFactory.getCurrentSession().get(CandidateBean.class, candidateID);
	int share=Integer.parseInt(panel);
	cb.setShareDetails(share);
	sessionFactory.getCurrentSession().saveOrUpdate(cb);
	}
	catch(Exception e) {
		return false;
	}
	return true;
}



public InterviewScheduleBean viewRatings(String interviewID) {
	InterviewScheduleBean interviewBean=null;
	try
	{
		interviewBean=(InterviewScheduleBean)sessionFactory.getCurrentSession().get(InterviewScheduleBean.class, interviewID);
		if(interviewBean==null)
		{
			InterviewScheduleBean interview=new InterviewScheduleBean();
			interview.setInterviewID("NoMatchFound");
			interviewBean=interview;
		}
	}
	
	catch(Exception e)
	{
		interviewBean=null;
	}
		return interviewBean;
}



public boolean finalizeResultDecision(String interviewID, String result) {
	boolean b=false;
	int i=-1;
	
	try
	{
		Query q=sessionFactory.getCurrentSession().createQuery("UPDATE InterviewScheduleBean set result=? WHERE interviewID=? ");
		q.setString(0,result);
		q.setString(1,interviewID);
		i=q.executeUpdate();
	
		if(i==1)
		{
			b=true;
		}
	}
	
	catch(Exception e)
	{
		b=false;
	}
	return b;
}



public boolean declareResults(String interviewId, int share) {
	boolean ans=false;
	int i=-1;
	try
	{
		Query q=sessionFactory.getCurrentSession().createQuery("UPDATE InterviewScheduleBean set shareResult=? WHERE interviewID=?");
		q.setInteger(0,share);
		q.setString(1,interviewId);
		i=q.executeUpdate();
		if(i==1)
		{
			ans=true;
		}
	}
	catch(Exception e)
	{
		ans=false;
	}
	return ans;
}

public String getTechnicalDate(String id) 
{	System.out.println("Inside DAO Sql");
	Connection conn;
	java.util.Date date=new java.util.Date();
	PreparedStatement pstmt;
	String sql="select interviewdate from its_tbl_interview_schedule where candidateid='"+id+"'";
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		ResultSet rs=conn.prepareStatement(sql).executeQuery();
		while(rs.next()){
			date=rs.getDate(1);
		}
	
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	SimpleDateFormat sf=new SimpleDateFormat("yyyy/MM/dd");
	String ans=sf.format(date);
	return ans;
	/*//CandidateBean candidateBean;
	InterviewScheduleBean interviewBean;
	List<InterviewScheduleBean> l=new ArrayList<InterviewScheduleBean>();
	Query q;
	
		System.out.println("ABC"+id);
	
	try{
		System.out.println("Done List");
		q=sessionFactory.getCurrentSession().createQuery("FROM InterviewScheduleBean WHERE candidateBean.candidateID=?");
		
		q.setString(0,id);
		l=q.list();
	}catch(Exception e){
		System.out.println(" problem with query");
	}
	

	
	//List<InterviewScheduleBean> l=sessionFactory.getCurrentSession().createQuery(qry).list();
	System.out.println(l);
	Date d=null;
	Iterator<InterviewScheduleBean> it=l.iterator();
	while(it.hasNext())
	{
		interviewBean=it.next();
		
			if(it.hasNext())
			{
				continue;
			}
			
			else
			{
				d=interviewBean.getInterviewDate();
				System.out.println("Date in Dao"+d);
			}
	
	}
	return d;

	}*/
}
public boolean logout(String userId) {
	// TODO Auto-generated method stub
	System.out.println(userId);
	CredentialsBean cb=(CredentialsBean) sessionFactory.getCurrentSession().get(CredentialsBean.class, userId);
	cb.setLoginStatus(0);
	sessionFactory.getCurrentSession().update(cb);
	return true;
}


public ArrayList<InterviewScheduleBean> viewAllInterviewDetails() {
	// TODO Auto-generated method stub
	
	ArrayList<InterviewScheduleBean> al;
	
	try
	{
		Query q=sessionFactory.getCurrentSession().createQuery("FROM InterviewScheduleBean");
		al=(ArrayList<InterviewScheduleBean>) q.list();
	}
	
	catch(Exception e)
	{
		al=null;
	}
	
	return al;
}
}



/*public boolean logout(String userId) {
		// TODO Auto-generated method stub
		CredentialsBean credentialsBean=new CredentialsBean();
		credentialsBean.setUserID(userId);
		int loginStatus=1;
		boolean ans=authentication.changeLoginStatus(credentialsBean, loginStatus);
		return ans;
		//return false;
	}*/

