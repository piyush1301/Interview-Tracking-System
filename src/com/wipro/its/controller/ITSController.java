package com.wipro.its.controller;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.bean.HRPanelBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;
import com.wipro.its.service.Administrator;
import com.wipro.its.service.HRPanel;
import com.wipro.its.service.TechPanel;
import com.wipro.its.util.User;

@Controller
@SessionAttributes
public class ITSController {
	
	@Autowired
	private User user;
	
	@Autowired
	Administrator administrator;
	
	@Autowired
	HRPanel hrpanel;
	
	@Autowired
	TechPanel techpanel; 
	
	
	ProfileBean tempProfileBean=new ProfileBean();
	CandidateBean tempCandidateBean=new CandidateBean();
	InterviewScheduleBean tempInterviewBean=new InterviewScheduleBean();
	InterviewScheduleBean tempReInterviewBean=new InterviewScheduleBean();
	String interviewId;
	public String getInterviewId() {
		return interviewId;
	}


	public void setInterviewId(String interviewId) {
		this.interviewId = interviewId;
	}

	InterviewScheduleBean tempHRInterviewBean=new InterviewScheduleBean();
	
	public InterviewScheduleBean getTempHRInterviewBean() {
		return tempHRInterviewBean;
	}


	public void setTempHRInterviewBean(InterviewScheduleBean tempHRInterviewBean) {
		this.tempHRInterviewBean = tempHRInterviewBean;
	}


	public InterviewScheduleBean getTempReInterviewBean() {
		return tempReInterviewBean;
	}


	public void setTempReInterviewBean(InterviewScheduleBean tempReInterviewBean) {
		this.tempReInterviewBean = tempReInterviewBean;
	}


	public InterviewScheduleBean getTempInterviewBean() {
		return tempInterviewBean;
	}


	public void setTempInterviewBean(InterviewScheduleBean tempInterviewBean) {
		this.tempInterviewBean = tempInterviewBean;
	}
	
	public CandidateBean getTempCandidateBean() {
		return tempCandidateBean;
	}


	public void setTempCandidateBean(CandidateBean tempCandidateBean) {
		this.tempCandidateBean = tempCandidateBean;
	}
	@RequestMapping(value="/goToAdmin",method=RequestMethod.GET)
	public ModelAndView ADMIN()
	{
		return new ModelAndView("AdminHome");
	}
	
String id3;
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("command")CredentialsBean credentialsBean,BindingResult result)
	{
		return new ModelAndView("login");
	}
	@RequestMapping(value="/userChk",method=RequestMethod.GET)
	public ModelAndView userChk(HttpSession session,@ModelAttribute("command")CredentialsBean credentialsBean,BindingResult result)
	{
		
		String s=user.login(credentialsBean);
		String ans="";
		if(s.equals("A"))
		{ 
			//ans="AdminHome";
			session.setAttribute("SessionBegin",credentialsBean.getUserID());
			id3=credentialsBean.getUserID();
			return new ModelAndView("AdminHome");
		}
		if(s.equals("T"))
		{
			//ans="TechHome";
			session.setAttribute("SessionBegin",credentialsBean.getUserID());
			id3=credentialsBean.getUserID();
			return new ModelAndView("TechHome");
		}
		if(s.equals("H"))
		
		{
			//ans="HRHome";
			session.setAttribute("SessionBegin",credentialsBean.getUserID());
			id3=credentialsBean.getUserID();
			return new ModelAndView("HRHome");
		}
		if(s.equalsIgnoreCase("already"))
			return new ModelAndView("alreadyLogin");
		return new ModelAndView("login","msg", "invalid username or password");
	}
	
	public ProfileBean getTempProfileBean() {
		return tempProfileBean;
	}


	public void setTempProfileBean(ProfileBean tempProfileBean) {
		this.tempProfileBean = tempProfileBean;
	}


	@RequestMapping(value="/AddCandidate",method=RequestMethod.GET)
	public ModelAndView addCandidateProfileForm(@ModelAttribute("ProfileDetails") ProfileBean profileBean,BindingResult result)
	{
		return new ModelAndView("AddNewProfile");
	}
	
	
	@RequestMapping(value="/AddInProfile",method=RequestMethod.POST)
	public ModelAndView addCandidateProfile(@Valid @ModelAttribute("ProfileDetails") ProfileBean profileBean,BindingResult result)
	{
		if(result.hasErrors())
		{
			
			//System.out.println(profileBean.getCandidateId());
			System.out.println(profileBean.getFirstName());
			System.out.println(profileBean.getLastName());
			System.out.println(profileBean.getDateOfBirth());
			System.out.println(profileBean.getGender());
			System.out.println(profileBean.getStreet());
			System.out.println(profileBean.getLocation());
			System.out.println(profileBean.getCity());
			System.out.println(profileBean.getState());
			System.out.println(profileBean.getPincode());
			System.out.println(profileBean.getMobileNo());
			System.out.println(profileBean.getEmailId());
			return new ModelAndView("AddNewProfile");
		}
		else
		{
			
		setTempProfileBean(profileBean);
		return new ModelAndView("redirect:AddCandidateDetails.html");
		
		}
	}
	
	@RequestMapping(value="/AddCandidateDetails",method=RequestMethod.GET)
	public ModelAndView addCandidateCandidateForm(@ModelAttribute("CandidateDetails") CandidateBean candidateBean)
	{
		return new ModelAndView("AddNewCandidate");
	}
	
	@RequestMapping(value="/AddInCandidate",method=RequestMethod.POST)
	public ModelAndView addCandidateCandidate(@Valid @ModelAttribute("CandidateDetails") CandidateBean candidateBean, BindingResult result)
	{
		System.out.println(candidateBean);
		if(!result.hasErrors()) 
		{
			String output="";
			System.out.println("Inside error freee candidate skill");
			String ans=administrator.addCandidate(getTempProfileBean(), candidateBean);
			
			if(!ans.equalsIgnoreCase("ERROR"))
			{
				output="addOutput";
			}
			
			else if(ans.equalsIgnoreCase("ERROR"))
			{
				output="ERROR";
			}
			
			return new ModelAndView(output,"ID",ans);
			
		}
		else
		{
			System.out.println("Inside error  candidate skill");
			
			candidateBean.getPrimarySkills();
			candidateBean.getSecondarySkills();
			candidateBean.getDesignation();
			candidateBean.getExperience();
			candidateBean.getLocation();
			candidateBean.getNoticePeriod();
			return new ModelAndView("AddNewCandidate");
		}
	}
	
	@RequestMapping(value="/ViewCandidate",method=RequestMethod.GET)
	public ModelAndView viewCandidateForm(@ModelAttribute("CandidateSkillSet") CandidateBean candidateBean)
	{
		return new ModelAndView("SelectionDetails");
	}
	
	@RequestMapping(value="/GetCandidates",method=RequestMethod.POST)
	public ModelAndView viewCandidateFromCriteria(@ModelAttribute("CandidateSkillSet") CandidateBean candidateBean)
	{
		String ans="";
		ArrayList<CandidateBean> al=administrator.viewCandidate(candidateBean.getPrimarySkills(), candidateBean.getExperience(), candidateBean.getQualification());
		
		
		
		if(al==null)
		{
			ans="ERROR";
		}
		
		else if(al.isEmpty())
		{
			ans="NoCandidateEligible";
		}
		
		else
		{
			ans="EligibleCandidateList";
		}
		return new ModelAndView(ans,"BeanList",al);
	}
	
	
	@RequestMapping(value="/viewCandidateHr",method=RequestMethod.GET)
	public ModelAndView viewCandidateHr(@ModelAttribute("command")InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		return new ModelAndView("viewhr");
	}

	
	@RequestMapping(value="/viewhrdet",method=RequestMethod.GET)
	public ModelAndView viewHrDet(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		
		//ArrayList<CandidateBean> a1=techpanel.viewCandidates(interviewschedulebean.getTechPanelBean().getTechID(), interviewschedulebean.getInterviewDate());
		//System.out.println(a1);
		/*if(a1.isEmpty())
		return new ModelAndView("viewtech","msg","no candidates have interview on this date");
		else
		return new ModelAndView("viewtechdetails","techdet",a1);*/
			ArrayList<CandidateBean> a1=hrpanel.viewCandidates(interviewschedulebean.getHrPanelBean().getEmpHRID(), interviewschedulebean.getEmpHRInterviewDate());
		System.out.println(a1);
		if(a1.isEmpty())
			return new ModelAndView("viewhr","msg","no candidates have interview on this date");
		else
		return new ModelAndView("viewhrdetails","hrdet",a1);
		
}
	
	@RequestMapping(value="/submitRatingshr",method=RequestMethod.GET)
	public ModelAndView submitRatings(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		return new ModelAndView("submitRate");
	}
	
	String id;
	
	@RequestMapping(value="/subrathr",method=RequestMethod.GET)
	public ModelAndView subrathr(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		//System.out.println(interviewschedulebean.getInterviewID());
		InterviewScheduleBean a1=hrpanel.getInterviewBean(interviewschedulebean.getInterviewID());
		System.out.println(a1);
		id = interviewschedulebean.getInterviewID();
		//boolean b=hrpanel.submitRatings(interviewschedulebean.getInterviewID(), interviewschedulebean.getEmpHRID(), interviewschedulebean.getEmpHRRating());
		return new ModelAndView("submitrathr","bean",a1);
	}
	
	@RequestMapping(value="/ratehr",method=RequestMethod.GET)
	public ModelAndView ratehr(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		System.out.println(interviewschedulebean);
		System.out.println(interviewschedulebean.getHrPanelBean().getEmpHRID());
		interviewschedulebean.setInterviewID(id);
		boolean b=hrpanel.submitRatings(interviewschedulebean.getInterviewID(), interviewschedulebean.getHrPanelBean().getEmpHRID(), interviewschedulebean.getEmpHRRating());
		return new ModelAndView("success");
	}
	
	@RequestMapping(value="/viewFinalResults",method=RequestMethod.GET)
	public ModelAndView viewFinalResults(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		
		
		return new ModelAndView("viewFinRes");
		
	}
	
	@RequestMapping(value="/finalRes",method=RequestMethod.GET)
	public ModelAndView finalRes(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		InterviewScheduleBean interviewBean=hrpanel.getInterviewBean(interviewschedulebean.getInterviewID());
		String ans="";
		if(interviewBean==null)
		{
			ans="ERROR";
		}
		
		
		else if(interviewBean.getInterviewID().equalsIgnoreCase("No obj exist"))
		{
			ans="NoId";
		}
		else if(!(interviewBean.getShareResult()==1||interviewBean.getShareResult()==0))
		{
			
			if(interviewBean.getTechRating()==null)
			{
				ans="NoTechRating";
			}
		
			else if(interviewBean.getTechRating()<=2.5)
			{
				ans="TechFailed";
			}
		
			else if(interviewBean.getHrPanelBean()==null)
			{
				ans="TechPassed";
			}
		
			else if(interviewBean.getEmpHRRating()==null)
			{
			ans="HRDone";
			}
		
			else if(interviewBean.getResult()==null)
			{
				ans="HRScores";
			}
			
			else
			{
				ans="PrintResult";
			}
		
		}
		
		else
		{
			ans="NotPermitted";
		}
		return new ModelAndView(ans,"ID",interviewBean);
		
	}
	
	@RequestMapping(value="/viewCandidatetech",method=RequestMethod.GET)
	public ModelAndView viewCandidatetech(@ModelAttribute("command")InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		return new ModelAndView("viewtech");
	}

	
	@RequestMapping(value="/viewtechdet",method=RequestMethod.GET)
	public ModelAndView viewtechDet(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		ArrayList<CandidateBean> a1=techpanel.viewCandidates(interviewschedulebean.getTechPanelBean().getTechID(), interviewschedulebean.getInterviewDate());
		System.out.println(a1);
		if(a1.isEmpty())
		return new ModelAndView("viewtech","msg","no candidates have interview on this date");
		else
		return new ModelAndView("viewtechdetails","techdet",a1);
			
		
}
	@RequestMapping(value="/submitRatingstech",method=RequestMethod.GET)
	public ModelAndView submitRatingstech(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		ArrayList<InterviewScheduleBean> a1=new ArrayList<InterviewScheduleBean>();
		
		a1=techpanel.viewAllInterviewDetails();
		return new ModelAndView("submitRatetech","bean",a1);
	}
	
	//String id;
	
	@RequestMapping(value="/subrattech",method=RequestMethod.GET)
	public ModelAndView subrattech(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		//System.out.println(interviewschedulebean.getInterviewID());
		InterviewScheduleBean a1=techpanel.getInterviewBean(interviewschedulebean.getInterviewID());
		System.out.println(a1);
		id = interviewschedulebean.getInterviewID();
		//boolean b=hrpanel.submitRatings(interviewschedulebean.getInterviewID(), interviewschedulebean.getEmpHRID(), interviewschedulebean.getEmpHRRating());
		return new ModelAndView("submitrattech","bean",a1);
	}
	
	@RequestMapping(value="/ratetech",method=RequestMethod.GET)
	public ModelAndView ratetech(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		System.out.println(interviewschedulebean);
		//System.out.println(interviewschedulebean.getEmpHRID());
		interviewschedulebean.setInterviewID(id);
		boolean b=techpanel.submitRatings(interviewschedulebean.getInterviewID(), interviewschedulebean.getTechPanelBean().getTechID(), interviewschedulebean.getTechRating());
		if(b==true)
			return new ModelAndView("submitrattech","msg","ratings added successfully");
		else
			return new ModelAndView("submitrattech","msg","Ratings should not be greater than 5.0 ");
		
			
	}
	@RequestMapping(value="/viewFinalResultstech",method=RequestMethod.GET)
	public ModelAndView viewFinalResultstech(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
ArrayList<InterviewScheduleBean> a1=new ArrayList<InterviewScheduleBean>();
		
		a1=techpanel.viewAllInterviewDetails();
		
		return new ModelAndView("viewFinRestech","bean",a1);
		
	}
	
	@RequestMapping(value="/finalRestech",method=RequestMethod.GET)
	public ModelAndView finalRestech(@ModelAttribute("command") InterviewScheduleBean interviewschedulebean,BindingResult result)
	{
		InterviewScheduleBean interviewBean=techpanel.getInterviewBean(interviewschedulebean.getInterviewID());
		String ans="";
		if(interviewBean==null)
		{
			ans="ERROR";
		}
		
		
		else if(interviewBean.getInterviewID().equalsIgnoreCase("No obj exist"))
		{
			ans="NoId";
		}
		else if(!(interviewBean.getShareResult()==3||interviewBean.getShareResult()==0))
		{
			
			if(interviewBean.getTechRating()==null)
			{
				ans="NoTechRating";
			}
		
			else if(interviewBean.getTechRating()<=2.5)
			{
				ans="TechFailed";
			}
		
			else if(interviewBean.getHrPanelBean()==null)
			{
				ans="TechPassed";
			}
		
			else if(interviewBean.getEmpHRRating()==null)
			{
			ans="HRDone";
			}
		
			else if(interviewBean.getResult()==null)
			{
				ans="HRScores";
			}
			
			else
			{
				ans="PrintResult";
			}
		
		}
		
		else
		{
			ans="NotPermitted";
		}
		return new ModelAndView(ans,"ID",interviewBean);
		
	}
	
	@RequestMapping(value="/ScheduleInterview",method=RequestMethod.POST)
	public String checkCandidateStatus(@ModelAttribute("command") CandidateBean candidateBean)
	{
		String ans="";
		String temp=administrator.getUserAttempt(candidateBean);
		if(temp.equalsIgnoreCase("FIRST"))
		{
			ans="FIRST";
		}
		
		else if(temp.equalsIgnoreCase("SECOND"))
		{
			ans="SECOND";
		}
					
		else if(temp.equalsIgnoreCase("ERROR"))
		{
			ans="ERROR";
		}
		
		setTempCandidateBean(candidateBean);//id is there in candidatebean
		return ("redirect:"+ans+".html");
	}
	
	@RequestMapping(value="/ERROR",method=RequestMethod.GET)
	public ModelAndView ErrorPage()
	{
		return new ModelAndView("ERROR");
	}
	
	
	@RequestMapping(value="/FIRST",method=RequestMethod.GET)
	public ModelAndView getTechnicalForm(@ModelAttribute("TechDetails") InterviewScheduleBean interviewBean)
	{
		return new ModelAndView("Technical","C_ID",getTempCandidateBean().getCandidateID());
	}
	
	@RequestMapping(value="/VerifyTechnical",method=RequestMethod.POST)
	public ModelAndView checkAvalibility(@Valid @ModelAttribute("TechDetails") InterviewScheduleBean interviewBean,BindingResult res)
	{
		
		if(res.hasErrors())
		{
			
			return new ModelAndView("Technical");
		}
		else
		{
		
		String ans=administrator.checkTechnicalAvalibility(interviewBean);
			
			if(ans.equalsIgnoreCase("Avaliable"))
			{
				ans="Yes_Ava";
				setTempInterviewBean(interviewBean);//date,time,techname,cid is set here
				
			}
			
			else if(ans.equalsIgnoreCase("Not_Avaliable"))
			{
				ans="No_Ava";
			}
			
			else if(ans.equalsIgnoreCase("ERROR"))
			{
				ans="ERROR";
			}
		return new ModelAndView(ans);
	}
	}
	
	@RequestMapping(value="/FixInterviewBean",method=RequestMethod.POST)
	public ModelAndView makeTechnicalBean()
	{
		String ans="DisplayTech";
		InterviewScheduleBean interviewBean=administrator.makeTechObject(getTempInterviewBean());
			if(interviewBean==null)
			{
				ans="ERROR";
			}
			setTempInterviewBean(interviewBean);//complete upto technical
		return new ModelAndView(ans,"Bean",interviewBean);
	}
	
	@RequestMapping(value="/ConfirmTech",method=RequestMethod.POST)
	public ModelAndView confirmTechnicalInterview()
	{
		String ans="";
		String id=administrator.scheduleInterviewforTech(getTempInterviewBean());
		if(id.equalsIgnoreCase("ERROR"))
		{
			ans="ERROR";
		}
		
		else
		{
			ans="TechnicalBooked";
		}
		return new ModelAndView(ans,"ID",id);
	}
	
	@RequestMapping(value="/CancelTech",method=RequestMethod.POST)
	public ModelAndView cancelTechnicalInterview()
	{
		return new ModelAndView("CancelTechnical");
	}
	
	@RequestMapping(value="/SECOND",method=RequestMethod.GET)
	public ModelAndView ifNotFirst()
	{
		String ans="";
		String temp=administrator.ifNotFirst(getTempCandidateBean());
			
			if(temp.equalsIgnoreCase("TechnicalresultAwaited"))
			{
				ans="TechScoreNA";
			}
		
			else if(temp.equalsIgnoreCase("TechnicalReScheduled"))
			{
				ans="ReScheduled";
			}
			
			else if(temp.equalsIgnoreCase("NotApplicable"))
			{
				ans="NoInterview";
			}
			
			else if(temp.endsWith("BookForHr"))
			{
				setInterviewId(temp.substring(0,6));
				ans="HRForm";
			}
			
			else if(temp.equalsIgnoreCase("HRresultAwaited"))
			{
				ans="HRScoreNA";
			}
			
			else if(temp.equalsIgnoreCase("ResultNotSet"))
			{
				ans="NoResult";
			}
			
			else if(temp.equalsIgnoreCase("PASS"))
			{
				ans="PASS";
			}
		return new ModelAndView(ans);
	}
	
	
	@RequestMapping(value="/ReInt",method=RequestMethod.GET)
	public ModelAndView reSchTech(@ModelAttribute("ReTech") InterviewScheduleBean ibean)
	{
		return new ModelAndView("ReTech_IntDet","ID",getTempCandidateBean().getCandidateID());
	}
	
	@RequestMapping(value="/SeeAvalibility",method=RequestMethod.POST)
	public ModelAndView verifyDetails(@ModelAttribute("ReTech") InterviewScheduleBean ibean)
	{
		String ans=administrator.checkTechnicalAvalibility(ibean);
		
		if(ans.equalsIgnoreCase("Avaliable"))
		{
			ans="Yes_Ava_Re";
			setTempReInterviewBean(ibean);//date,time,techname,cid is set here
			
		}
		
		else if(ans.equalsIgnoreCase("Not_Avaliable"))
		{
			ans="No_Ava_Re";
		}
		
		else if(ans.equalsIgnoreCase("ERROR"))
		{
			ans="ERROR";
		}
		
		return new ModelAndView(ans);
	}
	
	//FixInterviewRe
	
	@RequestMapping(value="/FixInterviewRe",method=RequestMethod.POST)
	public ModelAndView makeTechnicalBeanRe()
	{
		String ans="DisplayTechRe";
		InterviewScheduleBean interviewBean=administrator.makeTechObject(getTempReInterviewBean());
			if(interviewBean==null)
			{
				ans="ERROR";
			}
			setTempReInterviewBean(interviewBean);//complete upto technical
		return new ModelAndView(ans,"Bean",interviewBean);
	}
	
	@RequestMapping(value="/ConfirmTechRe",method=RequestMethod.POST)
	public ModelAndView confirmTechnicalInterviewRe()
	{
		String ans="";
		String id=administrator.scheduleInterviewforTech(getTempReInterviewBean());
		if(id.equalsIgnoreCase("ERROR"))
		{
			ans="ERROR";
		}
		
		else
		{
			ans="TechnicalBooked";
		}
		return new ModelAndView(ans,"ID",id);
	}
	@RequestMapping(value="/HrInterviewStop",method=RequestMethod.GET)
	public ModelAndView hrFormStop()
	{
		return new ModelAndView("hrStop");
	}

	@RequestMapping(value="/HrInterviewStart",method=RequestMethod.GET)
	public ModelAndView hrFormStart(@ModelAttribute("HRDetail") InterviewScheduleBean interviewBean)
	{
		return new ModelAndView("HrDetailForm","ID",getTempCandidateBean().getCandidateID());
	}
	
	
	@RequestMapping(value="/VerifyHR",method=RequestMethod.POST)
	public ModelAndView checkHRAvalibility(@ModelAttribute("HRDetail") InterviewScheduleBean interviewBean)
	{
		String ans="";
		String	temp=administrator.checkHRAvalibility(interviewBean);
		String message="";
		
		if(temp.startsWith("InCorrectDate"))
		{
			String date=temp.substring(13);
			message="Please Enter a date after "+date+" (Technical Interview Date)";
			ans="HrDetailForm";
		}
		
		else if(temp.equalsIgnoreCase("Avalibile"))
		{
			ans="Yes";
			setTempHRInterviewBean(interviewBean);
		}
		
		else if(temp.equalsIgnoreCase("NotAvalible"))
		{
			message="HR is already associated with a  interview on that day";
			ans="HrDetailForm";
		}
		else if(temp.equalsIgnoreCase("ERROR"))
		{
			ans="ERROR";
		}
		return new ModelAndView(ans,"msg",message);
	}
	//BookHR(yes)
	
	@RequestMapping(value="/BookHR",method=RequestMethod.POST)
	public ModelAndView makeObjHR()
	{
		String ans="ERROR";
		InterviewScheduleBean interviewBean=new InterviewScheduleBean();
		interviewBean=getTempHRInterviewBean();
		interviewBean.setInterviewID(getInterviewId());
		String temp=administrator.scheduleInterviewforHR(interviewBean);
		
		if(temp.equalsIgnoreCase("SUCCESS"))
		{
			ans="Done";
		}
		
		return new ModelAndView(ans,"ID",getInterviewId());
	}
	
	@RequestMapping(value="/ShareDetails",method=RequestMethod.GET)
	public ModelAndView shareDetail(@ModelAttribute("sharing") CandidateBean candidateBean)
	{
		return new ModelAndView("SharingInfo");
	}
	//fixSharing
	@RequestMapping(value="/fixSharing",method=RequestMethod.POST)
	public ModelAndView shareDetailToDb(@ModelAttribute("sharing") CandidateBean candidateBean)
	{
		System.out.println("ID"+candidateBean.getCandidateID());
		System.out.println("Value="+candidateBean.getShareDetails());
		String ans="";
		String panel=String.valueOf(candidateBean.getShareDetails());
		System.out.println("Actual gone"+panel);
		boolean b=administrator.shareCandidateDetails(candidateBean.getCandidateID(), panel);
		
		if(b==false)
		{
			ans="ERROR";
		}
		
		
		else
		{
			ans="ShareUpdate";
		}
		return new ModelAndView(ans);
	}
	
	@RequestMapping(value="/ViewRatings",method=RequestMethod.GET)
	public ModelAndView viewInterRating(@ModelAttribute("GetRatings") InterviewScheduleBean interviewScheduleBean)
	{
		return new ModelAndView("InterViewRating");
	}
	
	@RequestMapping(value="/ProcessRating",method=RequestMethod.POST)
	public ModelAndView viewInterRatingFromDB(@ModelAttribute("GetRatings") InterviewScheduleBean interviewScheduleBean)
	{
		String ans="";
		InterviewScheduleBean interviewBean=administrator.viewRatings(interviewScheduleBean.getInterviewID());
		if(interviewBean==null)
		{
			ans="ERROR";
		}
		else if(interviewBean.getInterviewID().equalsIgnoreCase("NoMatchFound"))
		{
			ans="NoSuchIdExist";
		}
		
		else
		{
			ans="OutputInterview";
		}
		return new ModelAndView(ans,"Bean",interviewBean);
	}
	
	@RequestMapping(value="/TakeResult",method=RequestMethod.GET)
	public ModelAndView takeResultForm(@ModelAttribute("takeResultDecision") InterviewScheduleBean interviewScheduleBean)
	{
		return new ModelAndView("TakeResultInput");
	}
	
	@RequestMapping(value="/CheckResult",method=RequestMethod.POST)
	public ModelAndView takeResultFormCheck(@ModelAttribute("takeResultDecision") InterviewScheduleBean interviewScheduleBean)
	{
		String ans="";
		InterviewScheduleBean interviewBean=administrator.viewRatings(interviewScheduleBean.getInterviewID());
		if(interviewBean==null)
		{
			ans="ERROR";
		}
		else if(interviewBean.getInterviewID().equalsIgnoreCase("NoMatchFound"))
		{
			ans="NoSuchIdExist";
		}
		
		else if(interviewBean.getEmpHRRating()==null)
		{
			ans="HRResultAwaited";
		}
		
		else if(interviewBean.getEmpHRRating()!=null)
		{
			ans="HRResultGot";
		}
		
		return new ModelAndView(ans,"Bean",interviewBean);
	}
	
	@RequestMapping(value="/Decided",method=RequestMethod.POST)
	public ModelAndView takeResultToDB(@ModelAttribute("takeResultDecision") InterviewScheduleBean interviewScheduleBean)
	{
		String ans="";
		boolean b=administrator.finalizeResultDecision(interviewScheduleBean.getInterviewID(),interviewScheduleBean.getResult());
		
		if(b==true)
		{
			ans="ResultSET";
		}
		
		else
		{
			ans="ERROR";
		}
		return new ModelAndView(ans);
		
	}
	
	@RequestMapping(value="/ShareResult",method=RequestMethod.GET)
	public ModelAndView shareResultInfo(@ModelAttribute("ResultInfo") InterviewScheduleBean interviewScheduleBean)
	{
		return new ModelAndView("TakeResultInfo");
	}

	//FixResultInfo
	@RequestMapping(value="/FixResultInfo",method=RequestMethod.POST)
	public ModelAndView shareResultInfoToDB(@ModelAttribute("ResultInfo") InterviewScheduleBean interviewScheduleBean)
	{
		String ans="";
		boolean b=administrator.declareResults(interviewScheduleBean.getInterviewID(),interviewScheduleBean.getShareResult());
		
		if(b==true)
		{
			ans="ResultShared";
		}
		
		else if(b==false)
		{
			ans="ERROR";
		}
		return new ModelAndView(ans);
	}
	
	// Logout module
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView doTheLogOut(HttpSession session)
	{
		String ans="";
		//String userId=id3;
		String userId=(String)session.getAttribute("SessionBegin");
		System.out.println(userId+"lllll");
		boolean b=user.logout(userId);
		
		if(b==true)
		{
			ans="../../index";
			session.removeAttribute("SessionBegin");
			session.invalidate();
		}
		else
		{
			ans="FAIL";
		}
		return new ModelAndView(ans);
	}
	/*@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView doTheLogOut(@ModelAttribute("command")CredentialsBean credentialsBean,BindingResult result)
	{
		String ans="";
		String userId=id3;
		//String userId=(String)session.getAttribute("SessionBegin");
		boolean b=user.logout(userId);
		
		if(b==true)
		{
			ans="../../index";
		}
		else
		{
			ans="FAIL";
		}
		return new ModelAndView(ans);
	}
	*/
	// Logout module end
	
	/*// change pwd

	@RequestMapping(value="/changePassword", method=RequestMethod.GET)
	public ModelAndView changePassword(@ModelAttribute("command") CredentialsBean credentialsBean,BindingResult result){

	return new ModelAndView("newPassword");

	}

	@RequestMapping(value="/passwordChange2", method=RequestMethod.POST)
	public ModelAndView newPassword(HttpSession session,@RequestParam("password") String password){
		System.out.println(password+"ggg3ggg");
		System.out.println("fjgfgvb"+session.getAttribute("LoginUserID"));
		String userID=(String) session.getAttribute("LoginUserID");
		System.out.println(userID+"session");
			user.changePassword(userID,password);
		
	return new ModelAndView("passwordSuccess","userID",userID);

	}
	
	//chf pwd end
*/	
	String id2;
	@RequestMapping(value="/changePassword", method=RequestMethod.GET)
	public ModelAndView changePassword(@ModelAttribute("command") CredentialsBean credentialsBean,BindingResult result){
//id2=credentialsBean.getUserID();
System.out.println(id3);
	return new ModelAndView("oldpassword");

	}
	
	@RequestMapping(value="/pwdCheck", method=RequestMethod.GET)
	public ModelAndView PwdCheck(@ModelAttribute("command") CredentialsBean credentialsBean,BindingResult result){
		
		System.out.println("enter con");
		credentialsBean.setUserID(id3);
		System.out.println(credentialsBean.getPassword());
			boolean b=user.checkPwd(credentialsBean);
			System.out.println(b);
			if(b==true)
			return new ModelAndView("newPassword");
			else
		return new ModelAndView("oldpassword","msg", "incorrect password");
	}	
	
	
	
	@RequestMapping(value = "confirmpwd", method = RequestMethod.GET)
	public ModelAndView newPassword(HttpSession session, @RequestParam("password") String password) {
		if(password.trim().equals("")||password.trim()==null)
			return new ModelAndView("newPassword","msg", "enter valid password");
		String userID = (String) session.getAttribute("SessionBegin");
		user.changePassword(userID, password);
		return new ModelAndView("pwdSuccesss", "userID", userID);

	}
	
	@RequestMapping(value="/goToTech",method=RequestMethod.GET)
	public ModelAndView TECH()
	{
		return new ModelAndView("TechHome");
	}
	@RequestMapping(value="/goToHR",method=RequestMethod.GET)
	public ModelAndView HR()
	{
		return new ModelAndView("HRHome");
	}
}
