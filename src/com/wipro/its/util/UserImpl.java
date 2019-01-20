package com.wipro.its.util;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.dao.xyzDAO;

@Component
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserImpl implements User{
	
@Autowired
private Authentication authentication;
@Autowired
private SessionFactory sess;

@Autowired
private xyzDAO itsDAO;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String login(CredentialsBean credentialsBean ) {
		
		// TODO Auto-generated method stub
		//boolean b=
	String ret=authentication.authenticate(credentialsBean);
	if(ret=="changed") {
		return authentication.authorize(credentialsBean.getUserID());
	}
	else if(ret=="already")
		return "already"; 
	else
		return "false";
	}

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean logout(String userId) {
		// TODO Auto-generated method stub
		
		return itsDAO.logout(userId);
		//return false;
	}

/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public boolean logout(String userId) {
		// TODO Auto-generated method stub
		CredentialsBean credentialsBean=new CredentialsBean();
		credentialsBean.setUserID(userId);
		int loginStatus=1;
		boolean ans=authentication.changeLoginStatus(credentialsBean, loginStatus);
		return ans;
		//return false;
	}
*/
	
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public boolean changePassword(String userID, String newPassword) 
{
	
	
CredentialsBean cb=(CredentialsBean) sess.getCurrentSession().get(CredentialsBean.class,userID);
cb.setPassword(newPassword);
	//sessionFactory.getCurrentSession().saveOrUpdate(cb);
Query q = sess.getCurrentSession().createQuery("update CredentialsBean set password=:password where userID=:userID");
q.setString("password", newPassword);
q.setString("userID", userID);
q.executeUpdate();
return true;
	
	
}

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public boolean checkPwd(CredentialsBean cb) 
{System.out.println("hello..enter");
System.out.println("cb ka pwd"+cb.getPassword());
System.out.println(cb.getUserID());
	CredentialsBean cbo=(CredentialsBean) sess.getCurrentSession().get(CredentialsBean.class,cb.getUserID());
	System.out.println(cbo);
	String pwd1=cbo.getPassword();
	System.out.println(pwd1);
	if(pwd1.equals(cb.getPassword()))
		return true;
	else
	return false;
}



}
