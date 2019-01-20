 package com.wipro.its.util;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.log.SysoLogger;
import com.wipro.its.bean.CredentialsBean;

@Component
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AuthenticationImpl implements Authentication{
	
	@Autowired
	private SessionFactory sessionFactory;
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean authenticate(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		boolean st=false;
		System.out.println(credentialsBean.getUserID());
		CredentialsBean cb=(CredentialsBean) sessionFactory.getCurrentSession().get(CredentialsBean.class,credentialsBean.getUserID());
		System.out.println(cb);
		if(cb==null)
			st= false;
		else
		{
			if(!cb.getPassword().equals(credentialsBean.getPassword()))
			{
				st= false;
			}
			else 
			{
				int k=-5;
				 k=cb.getLoginStatus();
				
				 System.out.println("Value of login"+k);
				if(k==0)
				{
					
					
					System.out.println("fullly authenticated");
					boolean p=changeLoginStatus(cb, 0);
					
					if(p==true)
						System.out.println("Succesfully logged inn value changed to 1");
					else
						System.out.println("Value nt changing");
							
					st= true;
				}
				else
				{
					System.out.println("Alreadyy logged inn ");
					st= false;
				}
			}
		}
		return st;
			
	}*/
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String authenticate(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		CredentialsBean bean = (CredentialsBean) sessionFactory.getCurrentSession().get(CredentialsBean.class, credentialsBean.getUserID());
		if(bean==null)
			return "false";
		else if(!bean.getPassword().equals(credentialsBean.getPassword()))
			return "false";
		else {
			return changeLoginStatus(bean, 1);
		}
			
	}

	//@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String authorize(String userID) {
		
		// TODO Auto-generated method stub
		CredentialsBean bean = (CredentialsBean) sessionFactory.getCurrentSession().get(CredentialsBean.class, userID);
		return bean.getUserType();
	}

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) {
		// TODO Auto-generated method stub
		CredentialsBean cb=(CredentialsBean) sessionFactory.getCurrentSession().get(CredentialsBean.class,credentialsBean.getUserID());
		if(cb.getLoginStatus()==1)
			return "already";
		else{
		credentialsBean.setLoginStatus(loginStatus);
		sessionFactory.getCurrentSession().update(credentialsBean);
		return "changed";
	}
	}
}
